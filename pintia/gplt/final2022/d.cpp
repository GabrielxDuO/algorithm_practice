#include <cstdio>

using namespace std;

int a, b;

int main() {
    scanf("%d%d", &a, &b);
    int mul = 1;
    for (int x = 1; x <= a + b; ++x) mul *= x;
    printf("%d\n", mul);

    return 0;
}