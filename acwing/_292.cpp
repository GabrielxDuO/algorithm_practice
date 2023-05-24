#include <iostream>
#include <vector>
#include <unordered_map>
#include <limits>

using namespace std;

typedef long long LL;

const int N = 110, S = 1 << 10;
int n, m;
unordered_map<int, int> mp;
vector<int> fit[S];
int f[2][S][S];
int g[N];

int count(int x) {
    int cnt = 0;
    while (x) x &= x - 1, ++cnt;
    return cnt;
}

bool check(int x) {
    return !((x & x << 1) || (x & x >> 1) || (x & x << 2) || (x & x >> 2));
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        int curr = 0;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        for (int j = 0; j < m; ++j, curr <<= 1) {
            char c; scanf("%c", &c);
            if (c == 'H') curr |= 1;
        }
        curr >>= 1;
        g[i] = curr;
    }
    for (int x = 0; x < (1 << m); ++x) {
        if (check(x)) mp[x] = count(x);
    }
    for (auto& [x, _] : mp) {
        for (auto& [y, _] : mp) {
            if (!(x & y)) fit[x].push_back(y);
        }
    }
    for (int i = 1; i <= n; ++i) {
        int curr = i & 1, prev = curr ^ 1;
        for (auto& [x, c] : mp) {
            if (x & g[i]) continue;
            for (auto& y : fit[x]) {
                for (auto& z : fit[y]) {
                    if (x & z) continue;
                    f[curr][x][y] = max(f[curr][x][y], f[prev][y][z] + c);
                }
            }
        }
    }
    int ans = 0;
    for (auto& [x, _] : mp) {
        for (auto& y : fit[x]) {
            ans = max(ans, f[n & 1][x][y]);
        }
    }
    printf("%d\n", ans);

    return 0;
}