#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e4 + 10;
int n;
struct Info {
    int id, cnt, val;

    bool operator<(const Info& o) const {
        if (val != o.val) return val > o.val;
        if (cnt != o.cnt) return cnt > o.cnt;
        return id < o.id;
    }
} a[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        a[i].id = i;
        int k; scanf("%d", &k);
        while (k--) {
            int x, y; scanf("%d%d", &x, &y);
            ++a[x].cnt;
            a[x].val += y;
            a[i].val -= y;
        }
    }
    sort(a + 1, a + n + 1);
    for (int i = 1; i <= n; ++i) {
        printf("%d %.2lf\n", a[i].id, a[i].val * 0.01);
    }

    return 0;
}