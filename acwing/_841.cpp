#include <cstdio>

using namespace std;

typedef unsigned long long ULL;

const int N = 1e5 + 10, P = 13331;
int n, m;
char s[N];
ULL p[N], h[N];

ULL get(int l, int r) {
    return h[r] - (h[l - 1] * p[r - l + 1]);
}

int main() {
    scanf("%d%d%s", &n, &m, s + 1);
    p[0] = 1ULL;
    for (int i = 1; i <= n; ++i) {
        p[i] = p[i - 1] * P;
        h[i] = h[i - 1] * P + s[i];
    }
    while (m--) {
        static int l1, r1, l2, r2;
        scanf("%d%d%d%d", &l1, &r1, &l2, &r2);
        puts(get(l1, r1) == get(l2, r2) ? "Yes" : "No");
    }

    return 0;
}