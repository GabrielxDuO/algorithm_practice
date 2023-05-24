#include <iostream>

using namespace std;

typedef long long LL;

const int N = 5010;
int n;
LL f[N];

int main() {
    scanf("%d", &n);
    f[1] = 1L, f[2] = 2L;
    for (int i = 3; i <= n; ++i) {
        f[i] = f[i - 1] + f[i - 2];
    }
    printf("%lld\n", f[n]);

    return 0;
}