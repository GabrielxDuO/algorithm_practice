#include <iostream>
#include <cstring>

using namespace std;

const int N = 110, M = N * N;
int n;
int ind[N];
int h[N], e[M], ne[M], idx;
int que[N];
int hh, tt = -1;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool top_sort() {
    for (int u = 1; u <= n; ++u) {
        if (!ind[u]) que[++tt] = u;
    }
    while (hh <= tt) {
        int u = que[hh++];
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (--ind[v] == 0) que[++tt] = v;
        }
    }
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int u = 1; u <= n; ++u) {
        int v;
        while (~scanf("%d", &v) && v) {
            add(u, v);
            ++ind[v];
        }
    }
    top_sort();
    for (int i = 0; i < n; ++i) printf("%d ", que[i]);

    return 0;
}