#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1010;
int n;
double d;
struct Cake {
    double s, tp, price;

    bool operator<(const Cake& c) const {
        return price > c.price;
    }
} cakes[N];

int main() {
    scanf("%d%lf", &n, &d);
    for (int i = 0; i < n; ++i) scanf("%lf", &cakes[i].s);
    for (int i = 0; i < n; ++i) {
        scanf("%lf", &cakes[i].tp);
        cakes[i].price = cakes[i].tp / cakes[i].s;
    }
    sort(cakes, cakes + n);
    double ans = 0.0;
    for (int i = 0; i < n; ++i) {
        double s = min(cakes[i].s, 1.0 * d);
        ans += cakes[i].price * s;
        d -= s;
    }
    printf("%.2lf\n", ans);

    return 0;
}