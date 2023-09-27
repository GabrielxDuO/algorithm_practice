#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e4 + 10;
int v, n, c;
int f[N];

int main() {
    scanf("%d%d%d", &v, &n, &c);
    for (int i = 0; i < n; ++i) {
        int vol, nrg;
        scanf("%d%d", &vol, &nrg);
        for (int j = c; j >= nrg; --j) {
            f[j] = max(f[j], f[j - nrg] + vol);
        }
    }
    for (int i = 0; i <= c; ++i) {
        if (f[i] >= v) {
            printf("%d\n", c - i);
            return 0;
        }
    }
    puts("Impossible");

    return 0;
}