#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n;

int main() {
    scanf("%d", &n);
    int curr = 0, prev = -1;
    int ans = n;
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        curr += x;
        if (curr >= 0 && ~prev) ans += (i - prev) * 2, prev = -1;
        else if (curr < 0 && !~prev) prev = i;
    }
    printf("%d\n", ans);

    return 0;
}