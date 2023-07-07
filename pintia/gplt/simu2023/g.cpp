#include <cstdio>
#include <unordered_set>

using namespace std;

int n, m, q;
unordered_set<int> sts[2];

int main() {
    scanf("%d%d%d", &n, &m, &q);
    while (q--) {
        int op, x;
        scanf("%d%d", &op, &x);
        sts[op].insert(x);
    }
    int r = sts[0].size(), c = sts[1].size();
    printf("%d\n", (n - r) * (m - c));

    return 0;
}