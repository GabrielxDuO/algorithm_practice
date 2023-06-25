#include <cstdio>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n;
double z, r;
int scale[N];
int h[N], e[N], ne[N], idx;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

double dfs(int u, double x) {
    if (scale[u]) return x * r * scale[u];
    double w = x * r;
    double sum = 0.0;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        sum += dfs(v, w);
    }
    return sum;
}

int main() {
    scanf("%d%lf%lf", &n, &z, &r);
    r = (100 - r) / 100;
    memset(h, -1, sizeof(h));
    int k, v;
    for (int u = 0; u < n; ++u) {
        scanf("%d", &k);
        if (!k) {
            scanf("%d", &scale[u]);
            continue;
        }
        while (k--) {
            scanf("%d", &v);
            add(u, v);
        }
    }
    if (r == 0.0) {
        printf("%lld\n", (LL) (z * scale[0]));
        return 0;
    }
    printf("%lld\n", (LL) dfs(0, z / r));

    return 0;
}