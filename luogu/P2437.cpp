#include <iostream>

using namespace std;

typedef long long LL;

const int N = 1010;
int m, n;
LL f[N];

int main() {
    scanf("%d%d", &m, &n);
    int x = n - m;
    f[0] = f[1] = 1L;
    for (int i = 2; i <= x; ++i) f[i] = f[i - 1] + f[i - 2];
    printf("%lld\n", f[x]);

    return 0;
}