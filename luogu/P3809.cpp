#include <cstdio>
#include <cstring>

using namespace std;

const int N = 1e6 + 10;
char s[N];
int n, m = 127;
int sa[N], rk[N], rk_bak[N * 2], cnts[N], pk[N], sk[N], hgt[N];

bool dup(const int& x, const int& y, const int& w) {
    return rk_bak[x] == rk_bak[y] && rk_bak[x + w] == rk_bak[y + w];
}

void get_sa() {
    for (int i = 1; i <= n; ++i) ++cnts[rk[i] = s[i]];
    for (int i = 2; i <= m; ++i) cnts[i] += cnts[i - 1];
    for (int i = n; i >= 1; --i) sa[cnts[rk[i]]--] = i;
    for (int w = 1; w < n; w <<= 1) {
        int idx = 0;
        for (int i = n; i > n - w; --i) sk[++idx] = i;
        for (int i = 1; i <= n; ++i) {
            if (sa[i] > w) sk[++idx] = sa[i] - w;
        }
        memset(cnts + 1, 0, m * sizeof(int));
        for (int i = 1; i <= n; ++i) ++cnts[pk[i] = rk[sk[i]]];
        for (int i = 2; i <= m; ++i) cnts[i] += cnts[i - 1];
        for (int i = n; i >= 1; --i) sa[cnts[pk[i]]--] = sk[i];
        memcpy(rk_bak + 1, rk + 1, n * sizeof(int));
        int p = 0;
        for (int i = 1; i <= n; ++i) {
            rk[sa[i]] = dup(sa[i], sa[i - 1], w) ? p : ++p;
        }
        if (p == n) break;
        m = p;
    }
}

void get_height() {
    for (int i = 1, k = 0; i <= n; ++i) {
        if (rk[i] == 1) continue;
        if (k) --k;
        int j = sa[rk[i] - 1];
        while (i + k <= n && j + k <= n && s[i + k] == s[j + k]) ++k;
        hgt[rk[i]] = k;
    }
}

int main() {
    scanf("%s", s + 1);
    n = strlen(s + 1);
    get_sa();
    get_height();

    for (int i = 1; i <= n; ++i) printf("%d ", sa[i]);
    putchar('\n');
    for (int i = 1; i <= n; ++i) printf("%d ", hgt[i]);

    return 0;
}