#include <cstdio>

using namespace std;

double a, b;
int t;

int main() {
    scanf("%lf%d%lf", &a, &t, &b);
    double c = t ? 1.26 : 2.455;
    printf("%.2lf ", a * c);
    puts(a * c >= b ? "T_T" : "^_^");

    return 0;
}