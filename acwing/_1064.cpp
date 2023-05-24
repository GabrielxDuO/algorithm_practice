#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

typedef long long LL;

const int N = 11, K = 110, S = 1 << 10;
int n, k;
unordered_map<int, int> mp;
vector<int> fit[S];
LL f[N][K][S];

int count(int x) {
    int cnt = 0;
    while (x) x &= x - 1, ++cnt;
    return cnt;
}

bool check(int x) {
    return !((x & x << 1) || (x & x >> 1));
}

bool check(int x, int y) {
    return !((x & y) || (x & y << 1) || (x & y >> 1));
}

int main() {
    scanf("%d%d", &n, &k);
    for (int x = 0; x < (1 << n); ++x) {
        if (check(x)) mp[x] = count(x);
    }
    for (auto& [x, _] : mp) {
        for (auto& [y, _] : mp) {
            if (check(x, y)) fit[x].push_back(y);
        }
    }
    f[0][0][0] = 1L;
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= k; ++j) {
            for (auto& [x, c] : mp) {
                for (auto& y : fit[x]) {
                    if (j >= c) f[i][j][x] += f[i - 1][j - c][y];
                }
            }
        }
    }
    LL ans = 0L;
    for (auto&[s, _] : mp) ans += f[n][k][s];
    printf("%lld\n", ans);

    return 0;
}