#include <cstdio>
#include <cmath>

using namespace std;

int t;

int main() {
    scanf("%d", &t);
    while (t--) {
        int x; scanf("%d", &x);
        int t = x, n = 0;
        while (t) t /= 10, ++n;
        int hf = n / 2;
        int mask = pow(10, hf);
        int a = x / mask, b = x % mask;
        if (b == a + 1) {
            if ((int) pow((int) sqrt(x), 2) == x) {
                puts("2");
            } else puts("1");
        } else puts("0");
    }

    return 0;
}