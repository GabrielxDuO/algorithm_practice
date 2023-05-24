#include <iostream>
#include <vector>

using namespace std;

typedef long long LL;

const int N = 13, S = 1 << 12, MOD = 1e8;
int n, m;
vector<int> states;
vector<int> fit[S];
LL f[N][S];
int g[N];

bool check(int x) {
    return !((x & x << 1) || (x & x >> 1));
}

bool check(int x, int y) {
    return !(x & y);
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        int curr = 0;
        for (int j = 0; j < m; ++j, curr <<= 1) {
            int d; scanf("%d", &d);
            if (!d) curr |= 1;
        }
        curr >>= 1;
        g[i] = curr;
    }
    for (int x = 0; x < (1 << m); ++x) {
        if (check(x)) states.push_back(x);
    }
    for (auto& x : states) {
        for (auto& y : states) {
            if (check(x, y)) fit[x].push_back(y);
        }
    }
    f[0][0] = 1L;
    for (int i = 1; i <= n; ++i) {
        for (auto& x : states) {
            if (x & g[i]) continue;
            for (auto& y : fit[x]) {
                f[i][x] = (f[i][x] + f[i - 1][y]) % MOD;
            }
        }
    }
    LL ans = 0;
    for (auto& s : states) ans = (ans + f[n][s]) % MOD;
    printf("%lld\n", ans);

    return 0;
}