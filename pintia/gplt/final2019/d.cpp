#include <cstdio>

using namespace std;

int x, y;

int main() {
    scanf("%d%d", &x, &y);
    double St = 100 * 100 / 2;
    double St1 = x * y / 2.0;
    double St2 = (100 - x) * (100 - y) / 2.0;
    double Sr = y * (100 - x);
    printf("%.0lf\n", St - St1 - St2 - Sr);

    return 0;
}