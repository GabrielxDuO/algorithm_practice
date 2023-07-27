#include <cstdio>

using namespace std;

int a, b;

int main() {
    scanf("%d%d", &a, &b);
    printf("%d/%.1lf=%d\n", a, 1.0 * a / b, b);

    return 0;
}