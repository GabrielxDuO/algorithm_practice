#include <iostream>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
struct Row {
    int x, i;
} a[N];
int n, q;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int x;
        scanf("%d", &a[i].x);
        a[i].i = i;
    }
    sort(a + 1, a + n + 1, [](Row& j, Row& k) { return j.x < k.x; });
    scanf("%d", &q);
    while (q--) {
        int x;
        scanf("%d", &x);
        int l = 1, r = n;
        while (l < r) {
            int m = l + r >> 1;
            if (a[m].x >= x) r = m;
            else l = m + 1;
        }
        if (a[l].x != x) puts("0");
        else printf("%d\n", a[l].i);
    }

    return 0;
}