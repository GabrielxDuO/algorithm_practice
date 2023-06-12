#include <cstdio>
#include <algorithm>

using namespace std;

int n, t;

int main() {
    scanf("%d%d", &n, &t);
    int st = 0, mx = 0;
    bool exceed = false, has = false;
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        mx = max(mx, x);
        if (x <= t && exceed) {
            printf("[%d, %d]\n", st, i - 1);
            exceed = false;
        } else {
            if (x > t && !exceed) {
                st = i;
                exceed = has = true;
            }
        }
    }
    if (exceed) printf("[%d, %d]\n", st, n - 1);
    if (!has) printf("%d\n", mx);

    return 0;
}