#include <iostream>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 40;
char a[N];
LL n, t;

int main() {
    scanf("%s %lld", a + 1, &n);
    int len = strlen(a + 1);
    while (n > len) {
        t = len;
        while ((t << 1) < n) t <<= 1;
        n -= t + 1;
        if (n == 0) n = t;
    }
    printf("%c\n", a[n]);

    return 0;
}