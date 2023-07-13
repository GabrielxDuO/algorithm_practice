#include <cstdio>

using namespace std;

typedef long long LL;

int n;
int a, b;

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d%d", &a, &b);
        int sa = 0, sb = 0;
        int t = a;
        while (t) {
            sa += t % 10;
            t /= 10;
        }
        t = b;
        while (t) {
            sb += t % 10;
            t /= 10;
        }
        if (a % sb == 0 && b % sa == 0 || a % sb && b % sa) puts(a > b ? "A" : "B");
        else if (a % sb == 0) puts("A");
        else puts("B");
    }

    return 0;
}