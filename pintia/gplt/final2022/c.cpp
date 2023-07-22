#include <cstdio>

using namespace std;

int a, b, x, y;

int main() {
    scanf("%d%d%d%d", &a, &b, &x, &y);
    if (x >= a && y >= a) printf("%d-Y %d-Y\nhuan ying ru guan", x, y);
    else if (x < a && y < a) printf("%d-N %d-N\nzhang da zai lai ba", x, y);
    else if (x < a && y < b) printf("%d-N %d-Y\n2: huan ying ru guan", x, y);
    else if (x < b && y < a) printf("%d-Y %d-N\n1: huan ying ru guan", x, y);
    else if (x < a && y >= b) printf("%d-Y %d-Y\nqing 2 zhao gu hao 1", x, y);
    else if (y < a && x >= b) printf("%d-Y %d-Y\nqing 1 zhao gu hao 2", x, y);

    return 0;
}