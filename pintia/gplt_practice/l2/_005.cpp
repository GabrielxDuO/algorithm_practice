#include <cstdio>
#include <unordered_set>

using namespace std;

const int N = 55;
int n, k;
unordered_set<int> sts[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int cnt; scanf("%d", &cnt);
        while (cnt--) {
            int x; scanf("%d", &x);
            sts[i].insert(x);
        }
    }
    scanf("%d", &k);
    while (k--) {
        int a, b;
        scanf("%d %d", &a, &b);
        int same = 0;
        for (auto& c : sts[a]) {
            if (sts[b].find(c) != sts[b].end()) ++same;
        }
        int total = sts[a].size() + sts[b].size() - same;
        printf("%.2lf%%\n", same * 100.0 / total);
    }

    return 0;
}