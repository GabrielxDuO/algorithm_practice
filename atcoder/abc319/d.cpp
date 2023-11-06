#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int n, m;
int a[N];

bool check(LL len) {
    LL curr = 0LL;
    int line = 0;
    for (int i = 0; i < n; ++i) {
        if (curr + a[i] + 1 < len) curr += a[i] + 1;
        else if (curr + a[i] + 1 == len || curr + a[i] == len) ++line, curr = 0;
        else ++line, curr = a[i] + 1;
    }
    if (curr) ++line;
    return line <= m;
}

int main() {
    scanf("%d%d", &n, &m);
    int mx = 0;
    LL sum = 0LL;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
        mx = max(mx, a[i]);
        sum += a[i] + 1;
    }
    LL l = mx, r = sum - 1;
    while (l < r) {
        LL mid = l + (r - l >> 1);
        if (check(mid)) r = mid;
        else l = mid + 1;
    }
    printf("%lld\n", l);

    return 0;
}