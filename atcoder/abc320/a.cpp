#include <cstdio>
#include <cmath>

using namespace std;

int main() {
    int a, b;
    scanf("%d%d", &a, &b);
    printf("%d\n", (int) (pow(a, b) + pow(b, a)));

    return 0;
}