#include <cstdio>
#include <cmath>

using namespace std;

int n, ax, ay, bx, by;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d%d%d%d", &ax, &ay, &bx, &by);
        puts(gcd(abs(ax - bx), abs(ay - by)) != 1 ? "yes" : "no");
    }

    return 0;
}