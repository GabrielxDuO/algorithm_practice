#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 2e5 + 10, INF = 0x3f3f3f3f;
int n;
int s[N];

int main() {
    scanf("%d", &n);
    int mn = 0, mx = -INF;
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &s[i]);
        s[i] += s[i - 1];
        mx = max(mx, s[i] - mn);
        mn = min(mn, s[i]);
    }
    printf("%d\n", mx);

    return 0;
}