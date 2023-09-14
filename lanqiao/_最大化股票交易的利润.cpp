#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e4 + 10;
int n;

int main() {
    scanf("%d", &n);
    int mn, ans;
    scanf("%d", &mn);
    ans = -mn;
    while (--n) {
        int x; scanf("%d", &x);
        ans = max(ans, x - mn);
        mn = min(mn, x);
    }
    printf("%d\n", ans);

    return 0;
}