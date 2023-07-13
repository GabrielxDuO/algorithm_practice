#include <cstdio>

using namespace std;

int n, m, k;
char x[20];

int main() {
    scanf("%d%s%d%d", &n, x, &m, &k);
    if (k == n) printf("mei you mai %s de\n", x);
    else if (k == m) printf("kan dao le mai %s de\n", x);
    else printf("wang le zhao mai %s de", x);

    return 0;
}