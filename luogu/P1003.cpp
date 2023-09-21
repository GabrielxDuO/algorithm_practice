#include <cstdio>

using namespace std;

const int N = 1e4 + 10;
int c[N][4], n;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d%d%d%d", &c[i][0], &c[i][1], &c[i][2], &c[i][3]);
        c[i][2] += c[i][0];
        c[i][3] += c[i][1];
    }
    int ax, ay;
    scanf("%d%d", &ax, &ay);
    for (int i = n; i >= 1; --i) {
        if (ax >= c[i][0] && ax <= c[i][2] && ay >= c[i][1] && ay <= c[i][3]) {
            printf("%d\n", i);
            return 0;
        }
    }
    puts("-1");

    return 0;
}