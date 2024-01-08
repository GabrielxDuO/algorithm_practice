#include <cstdio>

using namespace std;

int n;

int main() {
    scanf("%d", &n);
    int a1 = 0, a2 = 0;
    while (n) {
        ++a1;
        if (a2 == 0 && n % 3 == 1) a2 = a1;
        n -= n / 3 + (n % 3 > 0);
    }
    printf("%d %d\n", a1, a2);

    return 0;
}