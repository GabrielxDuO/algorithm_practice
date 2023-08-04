#include <cstdio>

using namespace std;

int n, x;

int main() {
    scanf("%d", &n);
    int odd = 0;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &x);
        if (x & 1) ++odd;
    }
    printf("%d %d\n", odd, n - odd);

    return 0;
}