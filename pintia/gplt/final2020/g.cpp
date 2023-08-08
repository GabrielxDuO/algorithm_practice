#include <cstdio>

using namespace std;

int n, m;

int main() {
    scanf("%d%d", &n, &m);
    while (m--) {
        int x = 1 << (n - 1), res = 0;
        scanf("\n");
        for (int i = 0; i < n; ++i, x >>= 1) {
            char c; scanf("%c", &c);
            if (c == 'n') res += x;
        }
        printf("%d\n", res + 1);
    }

    return 0;
}