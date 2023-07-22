#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 300010, M = N * 2, P = 1e9 + 7;
int n, root;
int h[N], e[M], ne[M], idx;
int sz[N], tr[N];
LL sum = 1L, s1, s2;

int lowbit(int x) {
    return x & -x;
}

void update(int i, int x) {
    for (; i < N; i += lowbit(i)) tr[i] += x;
}

int query(int i) {
    int sum = 0;
    for (; i > 0; i -= lowbit(i)) sum += tr[i];
    return sum;
}

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int p) {
    update(u, 1);
    s1 = (s1 + query(n) - query(u)) % P;
    sz[u] = 1;
    int cnt = 0;
    for (int i = h[u]; ~i; i = ne[i]) {
        int j = e[i];
        if (j == p) continue;
        dfs(j, u);
        sz[u] += sz[j];
        ++cnt;
    }
    for (int i = 1; i <= cnt; ++i) sum = sum * i % P;
    s2 = (s2 + n - query(n) - sz[u] + 1) % P;
    update(u, -1);
}

int main() {
    scanf("%d%d", &n, &root);
    memset(h, -1, sizeof h);
    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b), add(b, a);
    }
    dfs(root, -1);
    printf("%lld\n", (s1 * sum + s2 * sum % P * (P + 1) / 4) % P);

    return 0;
}