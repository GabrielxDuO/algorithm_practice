#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int n, k;
char s[N], c[2];
bool has[128];

int main() {
    scanf("%d%d%s", &n, &k, s);
    while (k--) scanf("%s", c), has[c[0]] = true;
    int prev = 0;
    LL ans = 0LL;
    for (int i = 0; i < n; ++i) {
        if (!has[s[i]]) {
            ans += 1LL * (i - prev) * (i - prev + 1) / 2;
            prev = i + 1;
        }
    }
    ans += 1LL * (n - prev) * (n - prev + 1) / 2;
    printf("%lld\n", ans);

    return 0;
}