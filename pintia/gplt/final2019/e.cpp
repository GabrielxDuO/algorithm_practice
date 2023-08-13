#include <cstdio>

using namespace std;

double w, h;

int main() {
    scanf("%lf%lf", &w, &h);
    double bmi = w / (h * h);
    printf("%.1lf\n", bmi);
    puts(bmi > 25 ? "PANG" : "Hai Xing");

    return 0;
}