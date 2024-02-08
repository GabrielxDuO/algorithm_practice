#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;

int n, q;
int a[N];
int tmp[110];

int main() {
    scanf("%d%d", &n, &q);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    while (q--) {
        int l, r;
        scanf("%d%d", &l, &r);
        if (r - l + 1 > 100) {
            puts("YES");
            continue;
        }
        for (int i = l; i <= r; ++i) tmp[i - l] = a[i];
        sort(tmp, tmp + r - l + 1);
        for (int i = 1; i < r - l + 1; ++i) {
            if (tmp[i] - tmp[i - 1] <= 365) {
                puts("YES");
                goto out;
            }
        }
        puts("NO");
        out:;
    }

    return 0;
}