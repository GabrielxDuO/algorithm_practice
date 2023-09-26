#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 110;
int n, x, a[N];

int main() {
    scanf("%d%d", &n, &x);
    for (int i = 1; i < n; ++i) scanf("%d", &a[i]);
    sort(a + 1, a + n);
    int mid_sum = 0, tot;
    for (int i = 2; i < n - 1; ++i) mid_sum += a[i];
    for (int i = 0; i <= 100; ++i) {
        if (i < a[1]) tot = mid_sum + a[1];
        else if (i > a[n - 1]) tot = mid_sum + a[n - 1];
        else tot = mid_sum + i;
        if (tot >= x) {
            printf("%d\n", i);
            return 0;
        }
    }
    puts("-1");

    return 0;
}