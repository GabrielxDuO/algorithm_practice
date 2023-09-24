#include <cstdio>
#include <algorithm>
#include <cstring>

using namespace std;

int n;
const int N = 1e3 + 10, M = 2e4 + 10;
struct Slab {
    int h, l, r;
} slabs[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d%d%d", &slabs[i].h, &slabs[i].l, &slabs[i].r);
    }
    for (int i = 1; i <= n; ++i) {
        int h = slabs[i].h, l = slabs[i].l, r = slabs[i].r;
        int l_mx = 0, l_id = 0, r_mx = 0, r_id = 0;
        for (int j = 1; j <= n; ++j) {
            if (slabs[j].h >= h) continue;
            if (slabs[j].l < l && slabs[j].r > l) {
                if (slabs[j].h > l_mx) l_mx = slabs[j].h, l_id = j;
            }
            if (slabs[j].l < r && slabs[j].r > r) {
                if (slabs[j].h > r_mx) r_mx = slabs[j].h, r_id = j;
            }
        }
        printf("%d %d\n", l_id, r_id);
    }

    return 0;
}