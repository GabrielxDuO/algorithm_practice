function solve(cards, squares) {
    const used = new Array(squares.length);
    const chosen = [], res = [];

    for (let card of cards) {
        chosen.push(card);
        dfs(card, 0);
        chosen.pop();
    }

    function dfs(sum, st) {
        if (sum > 36) return;
        if (sum == 36) {
            res.push([...chosen]);
            return;
        }
        for (let i = st; i < squares.length; ++i) {
            if (!used[i]) {
                used[i] = true;
                chosen.push([squares[i], i]);
                dfs(sum + squares[i], i + 1);
                used[i] = false;
                chosen.pop();
            }
        }
    }

    return res;
}

const res = solve([13,9,7,2], [9,8,10,2,11,2,8,7,9,5]);
console.log(res);