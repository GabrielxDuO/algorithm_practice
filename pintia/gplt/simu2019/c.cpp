#include <cstdio>

using namespace std;

int main() {
    int x; scanf("%d", &x);
    x += 2;
    printf("%d", (x - 1) % 7 + 1);

    return 0;
}