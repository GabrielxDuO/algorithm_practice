#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long LL;

int n;
vector<int> costs[10];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        costs[a].push_back(b);
    }
    for (int i = 0; i < 10; ++i) sort(costs[i].begin(), costs[i].end());
    LL ans = 0LL;
    for (int i = 0; i < 10; ++i) {
        if (costs[i].size() <= n / 10) continue;
        for (int j = 0; j < costs[i].size() - n / 10; ++j) {
            ans += costs[i][j];
        }
    }
    printf("%lld\n", ans);

    return 0;
}