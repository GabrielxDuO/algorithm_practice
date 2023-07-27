#include <cstdio>

using namespace std;


int x;

int main() {
    scanf("%d", &x);
    int len = 1, y = 1;
    while (y < x) y = y * 10 + 1, ++len;
    while (true) {
        printf("%d", y / x);
        if (y % x == 0) break;
        else y = y % x * 10 + 1, ++len;
    }
    printf(" %d\n", len);

    return 0;
}