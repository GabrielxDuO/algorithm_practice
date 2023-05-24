#include <iostream>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int N = 110;
int n, t;
PII a[N];

int main() {
    scanf("%d%d", &n, &t);
    for (int i = 0; i < n; ++i) scanf("%d%d", &a[i].first, &a[i].second);
    sort(a, a + n, [](const auto& x, const auto& y) { return x.first * y.second < y.first * x.second; });
    int tot = 0;
    double ans = 0.0;
    for (int i = 0; i < n; ++i) {
        if (tot + a[i].first > t) {
            ans += 1.0 * a[i].second / a[i].first * (t - tot);
            break;
        } else {
            tot += a[i].first;
            ans += a[i].second;
        }
    }
    printf("%.2lf\n", ans);

    return 0;
}