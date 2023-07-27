#include <cstdio>

using namespace std;

int t, a, b, c;

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d%d", &a, &b, &c);
        if (a * a + b * b + c * c == 3 * a * b * c) puts("Yes");
        else puts("No");
    }

    return 0;
}