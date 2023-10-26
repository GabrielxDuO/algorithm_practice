#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e6 + 10;
int n;
struct Seg {
    LL sum;
    int len;
} stk[N];
int tt;

int main() {
    scanf("%d", &n);
    while (n--) {
        Seg u = {0LL, 1};
        scanf("%lld", &u.sum);
        while (tt && u.sum * stk[tt].len <= stk[tt].sum * u.len) {
            u.sum += stk[tt].sum, u.len += stk[tt].len;
            --tt;
        }
        stk[++tt] = u;
    }
    for (int i = 1; i <= tt; ++i) {
        int len = stk[i].len;
        double avg = 1.0 * stk[i].sum / stk[i].len;
        while (len--) printf("%.9llf\n", avg);
    }

    return 0;
}