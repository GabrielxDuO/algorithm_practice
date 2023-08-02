#include <cstdio>

using namespace std;

int n, m;
double x;

int main() {
    scanf("%d%d", &n, &m);
    while (n--) {
        scanf("%lf", &x);
        if (x < m) printf("On Sale! %.1lf\n", x);
    }

    return 0;
}