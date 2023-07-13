#include <cstdio>

using namespace std;

int a, b;

int main() {
    scanf("%d%d", &a, &b);
    printf("%d\n%d\n%d\n%d", a + b - 16, a + b - 3, a + b - 1, a + b);

    return 0;
}