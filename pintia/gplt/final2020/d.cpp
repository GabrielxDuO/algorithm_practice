#include <cstdio>

using namespace std;

int n;
double sum;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        double x; scanf("%lf", &x);
        sum += 1 / x;
    }
    printf("%.2lf\n", 1 / (sum / n));

    return 0;
}