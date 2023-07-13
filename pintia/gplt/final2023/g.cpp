#include <cstdio>
#include <cmath>

using namespace std;

int a, b, n;

int main() {
    scanf("%d%d%d", &a, &b, &n);
    int mn = 1e9, mn_x = -1, mn_y = -1;
    for (int x = n - 1; x >= 1; --x) {
        int y = n - x;
        if (a % x == 0 && b % y == 0 && a != x && b != y) {
            int c1 = a / x, c2 = b / y;
            int diff = abs(c1 - c2);
            if (diff < mn) {
                mn = diff;
                mn_x = x;
                mn_y = y;
            }
        }
    }
    if (~mn_x) printf("%d %d\n", mn_x, mn_y);
    else puts("No Solution");

    return 0;
}