#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e3 + 10;
LL f[N];
int n;

int main() {
    scanf("%d", &n);
    for (int x = 1; x <= n; ++x) {
        f[x] = 1LL;
        for (int y = x / 2; y >= 1; --y) f[x] += f[y];
    }
    
    printf("%lld\n", f[n]);

    return 0;
}