#include <iostream>

using namespace std;

const int N = 1000;
int n;
int needs[N + 1] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
bool impos[N + 1];

int main() {
    scanf("%d", &n);
    n -= 4;
    for (int x = 10; x <= N; ++x) {
        int t = x, need = 0;
        while (t) need += needs[t % 10], t /= 10;
        if (need > n - 4) impos[x] = true;
        needs[x] = need;
    }
    int ans = 0;
    for (int a = 0; a <= N; ++a) {
        if (impos[a]) continue;
        for (int b = a; b <= N; ++b) {
            int c = a + b;
            if (impos[a] || c > N || impos[c] || needs[a] + needs[b] + needs[c] != n) continue;
            ans += a == b ? 1 : 2;
        }
    }
    printf("%d\n", ans);

    return 0;
}