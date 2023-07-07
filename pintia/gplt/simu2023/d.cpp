#include <cstdio>

using namespace std;

int a, b;

int main() {
    scanf("%d%d", &a, &b);
    int ans = 1;
    for (int x = 1; x <= a + b; ++x) ans *= x;
    printf("%d\n", ans);

    return 0;
}