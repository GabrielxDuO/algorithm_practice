#include <cstdio>

using namespace std;

int k;

int main() {
    scanf("%d", &k);
    int ans = 0, d = 0;
    while (k > 0) {
        ++d;
        ans += d * d;
        k -= d;
    }
    ans += k * d;
    printf("%d\n", ans);

    return 0;
}