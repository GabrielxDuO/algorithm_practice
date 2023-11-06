#include <cstdio>

using namespace std;

int n;

int main() {
    scanf("%d", &n);
    for (int i = 0; i <= n; ++i) {
        for (int j = 1; j <= 9; ++j) {
            if (n % j == 0 && i % (n / j) == 0) {
                putchar('0' + j);
                goto out;
            }
        }
        putchar('-');
        out:;
    }

    return 0;
}