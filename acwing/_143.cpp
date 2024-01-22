#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10, K = 31;
int n, a[N];
int sons[N * K][K], idx;

void insert(int x) {
    int p = 0;
    for (int i = K - 1; i >= 0; --i) {
        int d = (x >> i) & 1;
        if (sons[p][d] == 0) sons[p][d] = ++idx;
        p = sons[p][d];
    }
}

int query(int x) {
    int p = 0, res = 0;
    for (int i = K - 1; i >= 0; --i) {
        int d = (x >> i) & 1;
        if (sons[p][d ^ 1] == 0) p = sons[p][d];
        else p = sons[p][d ^ 1], res |= 1 << i;
    }
    return res;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]), insert(a[i]);
    int ans = 0;
    for (int i = 0 ; i < n; ++i) {
        ans = max(ans, query(a[i]));
    }
    printf("%d\n", ans);

    return 0;
}