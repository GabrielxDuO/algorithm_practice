#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e4 + 10;
int n, m;
LL f[N];

int main() {
    scanf("%d%d", &n, &m);
    f[0] = 1LL;
    for (int i = 0; i < n; ++i) {
        int v; scanf("%d", &v);
        for (int j = m; j >= v; --j) {
            f[j] += f[j - v];
        }
    }
    printf("%lld\n", f[m]);

    return 0;
}