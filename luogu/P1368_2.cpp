#include <cstdio>
#include <cstring>

using namespace std;

const int N = 6e5 + 10;
int n, m = 128;
int a[N];
int sa[N], rk[N], rk_bak[N * 2], cnts[N], pk[N], sk[N];

bool dup(const int& x, const int& y, const int& w) {
    return rk_bak[x] == rk_bak[y] && rk_bak[x + w] == rk_bak[y + w];
}

void get_sa() {
    for (int i = 1; i <= n; ++i) ++cnts[rk[i] = a[i]];
    for (int i = 1; i <= m; ++i) cnts[i] += cnts[i - 1];
    for (int i = n; i >= 1; --i) sa[cnts[rk[i]]--] = i;
    for (int w = 1; w < n; w <<= 1) {
        int idx = 0;
        for (int i = n; i > n - w; --i) sk[++idx] = i;
        for (int i = 1; i <= n; ++i) {
            if (sa[i] > w) sk[++idx] = sa[i] - w;
        }
        memset(cnts + 1, 0, m * sizeof(int));
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
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &a[i]);
        a[n + i] = a[i];
    }
    n *= 2;
    get_sa();
    for (int i = 1; i <= n; ++i) {
        if (sa[i] > n / 2) continue;
        for (int j = sa[i]; j <= n / 2; ++j) printf("%d ", a[j]);
        for (int j = 1; j < sa[i]; ++j) printf("%d ", a[j]);
        break;
    }

    return 0;
}