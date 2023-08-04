#include <cstdio>

using namespace std;

int n, x;

int main() {
    scanf("%d%d", &n, &x);
    printf("%d", x & 1);
    x /= 2;
    while (x--) n <<= 1;
    printf(" %d\n", n);

    return 0;
}