#include <cstdio>
#include <algorithm>

using namespace std;

int a, b;

int main() {
    scanf("%d%d", &a, &b);
    int x = max(0, max(a, b)), y = max(0, a + b);
    printf("%d %d\n", x, y);
    if (!x && !y) puts("-_-");
    else if (y > x) puts("^_^");
    else puts("T_T");

    return 0;
}