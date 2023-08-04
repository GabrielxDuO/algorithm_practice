#include <cstdio>

using namespace std;

int a, b;

int main() {
    scanf("%d%d", &a, &b);
    printf("%.2lf", a * (b * 1.0 / 10));

    return 0;
}