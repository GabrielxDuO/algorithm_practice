#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 3e4 + 10, M = 30;
int n, m;
int f[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int v, p;
        scanf("%d%d", &v, &p);
        for (int j = n; j >= v; --j) {
            f[j] = max(f[j], f[j - v] + v * p);
        }
    }
    printf("%d\n", f[n]);

    return 0;
}