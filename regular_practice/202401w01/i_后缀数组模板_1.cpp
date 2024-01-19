#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1e6 + 10;
int n;
char s[N];
int sa[N], rk[N * 2], rk_bak[N * 2];

bool dup(const int& x, const int& y, const int& w) {
    return rk_bak[x] == rk_bak[y] && rk_bak[x + w] == rk_bak[y + w];
}

int main() {
    scanf("%s", s + 1);
    n = strlen(s + 1);
    for (int i = 1; i <= n; ++i) sa[i] = i, rk[i] = s[i];
    for (int w = 1; w < n; w <<= 1) {
        sort(sa + 1, sa + n + 1, [&](const int& x, const int& y) {
            return rk[x] == rk[y] ? rk[x + w] < rk[y + w] : rk[x] < rk[y];
        });
        memcpy(rk_bak + 1, rk + 1, n * sizeof(int));
        int p = 0;
        for (int i = 1; i <= n; ++i) {
            rk[sa[i]] = dup(sa[i], sa[i - 1], w) ? p : ++p;
        }
        if (p == n) break;
    }
    for (int i = 1; i <= n; ++i) printf("%d ", sa[i]);

    return 0;
}