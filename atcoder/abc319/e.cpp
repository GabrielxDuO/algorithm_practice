#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10, LCM = 840;
int n, x, y, q;
LL p[N], t[N], mns[N];

int main() {
    scanf("%d%d%d", &n, &x, &y);
    for (int i = 0; i < n - 1; ++i) scanf("%d%d", &p[i], &t[i]);
    for (int st = 0; st < LCM; ++st) {
        LL& u = mns[st];
        u += st + x;
        for (int i = 0; i < n - 1; ++i) {
            if (u % p[i] != 0) u = (u / p[i] + 1) * p[i];
            u += t[i];
        }
        u += y;
    }
    scanf("%d", &q);
    while (q--) {
        LL qi; scanf("%lld", &qi);
        printf("%lld\n", qi / LCM * LCM + mns[qi % LCM]);
    }

    return 0;
}