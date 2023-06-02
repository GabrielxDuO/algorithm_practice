#include <cstdio>

#define lowbit(x) (x & -x)

using namespace std;

const int N = 1e5 + 10;
int n, m, a[N];
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
    // 将原数组转化为差分数组再建树状数组
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &a[i]);
        // 要建原数组的差分数组的树状数组 那么可以把原数组当成差分数组的前缀和数组
        // 然后根据定义建树状数组 tr[i]=sum(diff[i-lowbit(i)+1]...diff[i])=a[i]-a[i-lowbit(i)]
        tr[i] = a[i] - a[i - lowbit(i)];
    }
    while (m--) {
        char op;
        scanf("\n%c", &op);
        if (op == 'C') {
            int l, r, d;
            scanf("%d%d%d", &l, &r, &d);
            // 区间修改在差分数组上体现为修改两个点(diff[l]+=x, diff[r+1]-=x)
            add(l, d), add(r + 1, -d);
        } else {
            // 单点查询再差分数组上体现为前缀和查询
            int x; scanf("%d", &x);
            printf("%d\n", qry(x));
        }
    }

    return 0;
}