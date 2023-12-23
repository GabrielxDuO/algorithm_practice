#include <cstdio>

using namespace std;

int n, m;

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) {
        if (m >= 9) {
            putchar('9');
            m -= 9;
            continue;
        }
        putchar(m + '0');
        m = 0;
    }

    return 0;
}