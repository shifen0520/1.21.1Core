/**
 * 校验 KubeJS 里所有 MMCREvents 结构的 pattern：
 *  - 每个 slice 内所有行等宽
 *  - 所有 slice 等宽
 *  - 所有 slice 等高
 * MMCR 的 BlockArray$Builder.pattern 会在运行时抛 IllegalArgumentException，
 * 但这个错误发生在进入世界时（事件阶段），KubeJS 的 "0 errors" 统计不到，
 * 所以在 CI/本地先静态扫一遍。
 *
 * 用法：node work/check_structures.js [目录，默认 kubejs/server_scripts]
 */
const fs = require('fs');
const path = require('path');

function walk(dir, out = []) {
    for (const e of fs.readdirSync(dir, { withFileTypes: true })) {
        const p = path.join(dir, e.name);
        if (e.isDirectory()) walk(p, out);
        else if (e.name.endsWith('.js')) out.push(p);
    }
    return out;
}

/** 提取一个文件里所有 .pattern(...) 的字符串字面量参数分组 */
function slicesOf(src) {
    const slices = [];
    const re = /\.pattern\s*\(([^)]*)\)/g;
    let m;
    while ((m = re.exec(src)) !== null) {
        const rows = [...m[1].matchAll(/(['"])(.*?)\1/g)].map(x => x[2]);
        slices.push(rows);
    }
    return slices;
}

const root = process.argv[2] || path.join(__dirname, '..', 'kubejs', 'server_scripts');
let bad = 0;
let checked = 0;

for (const file of walk(root)) {
    const src = fs.readFileSync(file, 'utf8');
    if (!src.includes('MMCREvents') || !src.includes('.pattern(')) continue;
    const slices = slicesOf(src);
    if (slices.length === 0) continue;
    const rel = path.relative(process.cwd(), file).replace(/\\/g, '/');
    checked++;

    const errs = [];
    slices.forEach((rows, i) => {
        const widths = new Set(rows.map(r => r.length));
        if (widths.size !== 1) {
            errs.push(`  层 ${i + 1} 行宽不一致: ${rows.map(r => `${r.length}"${r}"`).join(', ')}`);
        }
    });
    const allWidths = new Set(slices.map(r => r[0] ? r[0].length : 0));
    if (allWidths.size !== 1) {
        errs.push(`  各层宽度不一致: ${[...allWidths].join(' vs ')} → All pattern slices must have the same width`);
    }
    const allHeights = new Set(slices.map(r => r.length));
    if (allHeights.size !== 1) {
        errs.push(`  各层行数不一致: ${[...allHeights].join(' vs ')} → All pattern slices must have the same height`);
    }

    if (errs.length) {
        bad++;
        console.log(`[FAIL] ${rel}`);
        errs.forEach(e => console.log(e));
    } else {
        const h = slices[0].length, w = slices[0][0].length, d = slices.length;
        console.log(`[ OK ] ${rel}  ${w} x ${h} x ${d} (宽 x 深 x 层)`);
    }
}

console.log(`\n共 ${checked} 个结构，${bad} 个有问题。`);
process.exit(bad === 0 ? 0 : 1);
