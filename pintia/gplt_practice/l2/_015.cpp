#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e4 + 10, M = 25;
int n, k, m;
double a[N];

int main() {
    scanf("%d%d%d", &n, &k, &m);
    for (int i = 0; i < n; ++i) {
        int sum = 0, mn = 101, mx = -1;
        for (int j = 0; j < k; ++j) {
            int x; scanf("%d", &x);
            sum += x;
            mn = min(mn, x);
            mx = max(mx, x);
        }
        sum = sum - mn - mx;
        a[i] = sum * 1.0 / (k - 2);
    }
    sort(a, a + n);
    for (int i = max(0, n - m); i < n; ++i) {
        printf("%.3lf", a[i]);
        printf(i == n - 1 ? "\n" : " ");
    }

    return 0;
}