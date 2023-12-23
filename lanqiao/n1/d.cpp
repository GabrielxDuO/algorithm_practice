#include <cstdio>

using namespace std;

typedef long long LL;
typedef unsigned long long ULL;

const int N = 3e4 + 10;
int n;
LL s[N];

int main() {
    scanf("%d", &n);
    ULL ans = 0LL;
    for (int i = 0; i < n; ++i) {
        scanf("%lld", &s[i]);
        s[i] += s[i - 1];
        ans += (s[i] - s[i - 1]) * s[i - 1];
    }
    printf("%llu\n", ans);

    return 0;
}