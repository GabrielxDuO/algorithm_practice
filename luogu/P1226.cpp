#include <iostream>

int main() {
    int a, b, p;
    scanf("%d%d%d", &a, &b, &p);
    int expo = b;
    long long base = a, ans = 1L;
    while (expo) {
        if (expo & 1) ans = ans * base % p;
        base = base * base % p;
        expo >>= 1;
    }
    printf("%lld^%lld mod %lld=%lld", a, b, p, ans);
}