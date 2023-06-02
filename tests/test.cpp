#include <cstdio>

#define lowbit(x) (x & -x)

using namespace std;

const int N = 1e5 + 10;
int n, m, s[N];
int tr[N];

void add(int i, int x) {
    for (; i <= n; i += lowbit(i)) tr[i] += x;
}

int qry(int i) {
    int res = 0;
    for (; i; i -= lowbit(i)) res += tr[i];
    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &s[i]);
        s[i] += s[i - 1];
        tr[i] = s[i] - s[i - lowbit(i)];
    }
    while (m--) {
        int k, a, b;
        scanf("%d%d%d", &k, &a, &b);
        if (k) add(a, b);
        else printf("%d\n", qry(b) - qry(a - 1));
    }

    return 0;
}