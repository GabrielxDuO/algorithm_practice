#include <cstdio>

using namespace std;

const int N = 5010;
int n, m, p;
int roots[N];

int find(int x) {
    return x == roots[x] ? x : (roots[x] = find(roots[x]));
}

void join(int a, int b) {
    roots[find(a)] = find(b);
}

int main() {
    scanf("%d%d%d", &n, &m, &p);
    for (int u = 1; u <= n; ++u) roots[u] = u;
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        join(a, b);
    }
    while (p--) {
        int a, b;
        scanf("%d%d", &a, &b);
        puts(find(a) == find(b) ? "Yes" : "No"); 
    }

    return 0;
}