#include <cstdio>

using namespace std;

typedef unsigned long long ULL;

ULL n;

int main() {
    scanf("%llu", &n);
    printf("%llu\n", n * (n + 1) * (2 * n + 1) / 6);

    return 0;
}