#include <cstdio>
#include <algorithm>

using namespace std;

int n, x;

int main() {
    scanf("%d%d", &n, &x);
    int mn = 101, mx = -1;
    int sum = 0;
    for (int i = 1; i < n; ++i) {
        int a; scanf("%d", &a);
        mn = min(mn, a);
        mx = max(mx, a);
        sum += a;
    }
    sum = sum - mn - mx;
    int tot;
    for (int i = 0; i <= 100; ++i) {
        if (i < mn) tot = sum + mn;
        else if (i > mx) tot = sum + mx;
        else tot = sum + i;
        if (tot >= x) {
            printf("%d\n", i);
            return 0;
        }
    }
    puts("-1");

    return 0;
}