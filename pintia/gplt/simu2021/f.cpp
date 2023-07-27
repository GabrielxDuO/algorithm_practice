#include <cstdio>

using namespace std;

int t, x;

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &x);
        int y = 2 * x, syoshin = 0;
        while (y) syoshin += y % 10, y /= 10;
        for (int i = 3; i <= 9; ++i) {
            y = x * i;
            int sum = 0;
            while (y) sum += y % 10, y /= 10;
            if (sum != syoshin) {
                puts("NO");
                goto out;
            }
        }
        printf("%d\n", syoshin);
        out:;
    }

    return 0;
}