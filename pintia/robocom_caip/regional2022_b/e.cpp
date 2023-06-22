#include <cstdio>
#include <algorithm>

using namespace std;

int x, y, a, b = 1;

int main() {
    scanf("%d%d", &x, &y);
    if (!y) b = 0;
    while (x) {
        a += x % 10;
        x /= 10;
    }
    while (y) {
        b *= y % 10;
        y /= 10;
    }
    if (a < b) swap(a, b);
    printf("%d%d\n", a, b);

    return 0;
}