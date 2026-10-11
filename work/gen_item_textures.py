"""生成科研系统物品贴图（16x16 RGBA PNG）。

不依赖 Pillow —— 环境里没有，手写 zlib + PNG chunk 更快也更可控。
每个物品画一张 16x16 的图，风格统一：深色底 + 亮色主体 + 单像素高光。
"""
import struct
import zlib
from pathlib import Path

W = H = 16

# 调色板：每项是 (key, (R,G,B,A))
C = {
    "0": (0, 0, 0, 0),          # 透明
    "k": (28, 26, 34, 255),     # 深色描边
    "d": (54, 50, 62, 255),      # 暗部
    "g": (86, 82, 96, 255),      # 中间调
    "l": (140, 138, 155, 255),   # 亮部
    "w": (226, 226, 234, 255),   # 高光
    "y": (250, 206, 70, 255),    # 强调黄
    "o": (232, 138, 44, 255),    # 橙
    "c": (86, 208, 214, 255),    # 青
    "c2": (44, 150, 162, 255),   # 深青
    "p": (168, 118, 224, 255),   # 紫
    "p2": (110, 70, 158, 255),   # 深紫
    "r": (206, 74, 68, 255),     # 红
    "gr": (128, 190, 96, 255),   # 绿
    "e": (58, 108, 92, 255),     # 电路绿
    "b": (62, 96, 168, 255),     # 蓝
    "n": (198, 156, 104, 255),   # 金/铜
}


class Img:
    def __init__(self):
        self.px = [["0"] * W for _ in range(H)]

    def set(self, x, y, c):
        if 0 <= x < W and 0 <= y < H:
            self.px[y][x] = c

    def rect(self, x0, y0, x1, y1, c):
        for y in range(y0, y1 + 1):
            for x in range(x0, x1 + 1):
                self.set(x, y, c)

    def frame(self, x0, y0, x1, y1, c):
        """空心矩形"""
        for x in range(x0, x1 + 1):
            self.set(x, y0, c)
            self.set(x, y1, c)
        for y in range(y0, y1 + 1):
            self.set(x0, y, c)
            self.set(x1, y, c)

    def hline(self, x0, x1, y, c):
        for x in range(x0, x1 + 1):
            self.set(x, y, c)

    def vline(self, x, y0, y1, c):
        for y in range(y0, y1 + 1):
            self.set(x, y, c)

    def disc(self, cx, cy, r, c):
        for y in range(H):
            for x in range(W):
                if (x - cx) ** 2 + (y - cy) ** 2 <= r * r:
                    self.set(x, y, c)

    def ring(self, cx, cy, r, c):
        for y in range(H):
            for x in range(W):
                d2 = (x - cx) ** 2 + (y - cy) ** 2
                if (r - 1) ** 2 < d2 <= r * r:
                    self.set(x, y, c)

    def save(self, path):
        raw = bytearray()
        for row in self.px:
            raw.append(0)  # filter type 0
            for key in row:
                raw.extend(C[key])

        def chunk(tag, data):
            return (struct.pack(">I", len(data)) + tag + data
                    + struct.pack(">I", zlib.crc32(tag + data) & 0xFFFFFFFF))

        png = b"\x89PNG\r\n\x1a\n"
        png += chunk(b"IHDR", struct.pack(">IIBBBBB", W, H, 8, 6, 0, 0, 0))
        png += chunk(b"IDAT", zlib.compress(bytes(raw), 9))
        png += chunk(b"IEND", b"")
        Path(path).write_bytes(png)


def card_base(body, trim):
    """卡片类物品：深色卡框 + 彩色面 + 左上高光条。"""
    im = Img()
    im.rect(3, 2, 12, 13, "k")          # 卡体
    im.frame(3, 2, 12, 13, "d")
    im.rect(4, 3, 11, 12, body)         # 正面
    im.hline(5, 10, 4, "w")             # 顶部高光
    im.hline(5, 10, 12, trim)           # 底部装饰条
    im.vline(4, 4, 11, trim)
    return im


def disk_base(body, trim):
    """硬盘类物品：方块盘体 + 亮色盘芯 + 底部接口条。

    盘芯留成同心环（外环亮、内芯暗），16x16 下才看得出"转盘"的形状，
    这是这套图标里唯一能一眼认出是"硬盘"的元素。
    """
    im = Img()
    im.rect(2, 2, 13, 11, "k")          # 盘壳描边
    im.rect(3, 3, 12, 10, trim)         # 盘体外圈（等级色）
    im.rect(4, 4, 11, 9, body)          # 盘面
    im.disc(7, 6, 3, "k")               # 转盘外沿
    im.disc(7, 6, 2, "w")               # 转盘面
    im.disc(7, 6, 1, trim)              # 中心轴
    im.hline(4, 11, 12, "l")            # 底部接口条
    im.hline(4, 11, 13, "d")
    return im


OUT = Path(__file__).resolve().parent / "out"
OUT.mkdir(exist_ok=True)


def save(img, name):
    img.save(OUT / f"{name}.png")
    print("wrote", name + ".png")


# ---- 身份卡：白底深色芯片，右上角一道青条
im = card_base("g", "c2")
im.rect(5, 6, 10, 10, "k")             # 芯片座
im.rect(6, 7, 9, 9, "c")               # 芯片本体
im.hline(7, 8, 8, "w")                 # 芯片高光
im.rect(9, 3, 11, 4, "y")              # 右上角标记
save(im, "identity_card")

# ---- 科研任务卡：紫底 + 清单勾选框
im = card_base("p2", "p")
im.rect(4, 5, 6, 7, "w")               # 勾选框
im.hline(5, 5, 6, "e")
im.vline(5, 6, 6, "e")
im.rect(7, 5, 11, 5, "w")              # 清单条目
im.rect(7, 7, 10, 7, "l")
im.rect(7, 9, 11, 9, "l")
save(im, "research_task_card")

# ---- T1 基础硬盘：4 个点亮格 = 容量 4
im = disk_base("g", "d")
for x in (4, 6, 8, 10):
    im.vline(x, 12, 13, "w")
save(im, "basic_disk")

# ---- T2 加密硬盘：青调 + 加密锁
im = disk_base("c", "c2")
im.rect(6, 5, 9, 8, "c2")
im.ring(7, 5, 2, "c")
im.rect(6, 7, 9, 8, "y")               # 锁体
im.set(7, 9, "y")
for x in (4, 6, 8, 10):
    im.vline(x, 12, 13, "w")
im.vline(12, 12, 13, "d")
save(im, "encrypted_disk")

# ---- T3 扩容硬盘：橙调 + 堆叠线（容量更大 → 点亮更多格）
im = disk_base("o", "y")
im.hline(4, 11, 4, "y")
im.hline(4, 11, 5, "w")
im.hline(4, 11, 6, "y")
im.rect(5, 7, 10, 8, "d")
for x in range(4, 12):
    im.vline(x, 12, 13, "w")
save(im, "expanded_disk")

# ---- T4 量子硬盘：金调 + 核心（接口条整条点亮 = 不限量）
im = disk_base("y", "n")
im.disc(7, 6, 4, "w")
im.disc(7, 6, 3, "y")
im.disc(7, 6, 2, "w")
im.disc(7, 6, 1, "y")
for x in range(4, 12):
    im.vline(x, 12, 13, "w")
save(im, "hard_disk")

print("done")
