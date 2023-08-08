#include <cstdio>

using namespace std;

double a, c;
int b;

int main() {
    scanf("%lf%d%lf", &a, &b, &c);
    double d = a * (b ? 1.26 : 2.455);
    printf("%.2lf ", d);
    puts(d < c ? "^_^" : "T_T");

    return 0;
}