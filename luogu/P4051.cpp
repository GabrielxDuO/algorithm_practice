#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
char s[N * 2];
int sa[N * 2], rk[N * 2], rk_bak[N * 4], cnts[N * 2], pk[N * 2], sk[N * 2];

bool dup(const int& x, const int& y, const int& w) {
    return rk_bak[x] == rk_bak[y] && rk_bak[x + w] == rk_bak[y + w];
}

int main() {
    scanf("%s", s + 1);
    int n = strlen(s + 1);
    strcpy(s + 1 + n, s + 1);
    n *= 2;
    int m = 128;
    for (int i = 1; i <= n; ++i) ++cnts[rk[i] = s[i]];
    for (int i = 1; i <= m; ++i) cnts[i] += cnts[i - 1];
    for (int i = n; i >= 1; --i) sa[cnts[rk[i]]--] = i;
    for (int w = 1; w < n; w <<= 1) {
        int idx = 0;
        for (int i = n; i > n - w; --i) sk[++idx] = i;
        for (int i = 1; i <= n; ++i) {
            if (sa[i] > w) sk[++idx] = sa[i] - w;
        }

        memset(cnts, 0, (m + 1) * sizeof(int));
        for (int i = 1; i <= n; ++i) ++cnts[pk[i] = rk[sk[i]]];
        for (int i = 1; i <= m; ++i) cnts[i] += cnts[i - 1];
        for (int i = n; i >= 1; --i) sa[cnts[pk[i]]--] = sk[i];

        memcpy(rk_bak + 1, rk + 1, n * sizeof(int));
        int p = 0;
        for (int i = 1; i <= n; ++i) {
            rk[sa[i]] = dup(sa[i], sa[i - 1], w) ? p : ++p;
        }
        if (p == n) break;
        m = p;
    }
    for (int i = 1; i <= n; ++i) {
        int len = n - sa[i] + 1;
        if (len > n / 2) putchar(s[sa[i] + n / 2 - 1]);
    }

    return 0;
}