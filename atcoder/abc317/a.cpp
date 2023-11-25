#include <cstdio>

using namespace std;

int n, h, x;

int main() {
    scanf("%d%d%d", &n, &h, &x);
    for (int i = 1; i <= n; ++i) {
        int p; scanf("%d", &p);
        if (p + h >= x) {
            printf("%d\n", i);
            return 0;
        }
    }

    return 0;
}