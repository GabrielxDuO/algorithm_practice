#include <cstdio>

#define lowbit(x) (x & -x)

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, m, a[N];
LL tr1[N], tr2[N];

void add(LL tr[], int i, LL x) {
    for (; i <= n; i += lowbit(i)) tr[i] += x;
}

LL qry(LL tr[], int i) {
    LL res = 0L;
    for (; i; i -= lowbit(i)) res += tr[i];
    return res;
}

LL pref_sum(int i) {
    // sum(a[1]...a[i]) = sum(sum(b[1]), sum(b[1], b[2]), ... sum(b[1], b[i]))
    // = sum(b[1]...b[i]) * (i+1) - sum(1*b[1]...i*b[i])
    return qry(tr1, i) * (i + 1) - qry(tr2, i);
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &a[i]);
        int b = a[i] - a[i - 1];
        // 设原数组a的差分数组是b 则tr1维护b的树状数组 tr2维护[b1*1, b2*2, ..., bi*i]的树状数组
        add(tr1, i, b);
        add(tr2, i, 1L * b * i);
    }
    while (m--) {
        char op[2];
        int l, r;
        scanf("%s%d%d", op, &l, &r);
        if (op[0] == 'C') {
            int d; scanf("%d", &d);
            add(tr1, l, d), add(tr1, r + 1, -d);
            add(tr2, l, d * l), add(tr2, r + 1, 1L * -d * (r + 1));
        } else printf("%lld\n", pref_sum(r) - pref_sum(l - 1));
    }

    return 0;
}