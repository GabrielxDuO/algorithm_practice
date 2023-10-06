#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1010;
int n, m;
int degs[N];

int main() {
    scanf("%d%d", &n, &m);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        ++degs[a];
        ++degs[b];
    }
    int odd = 0;
    for (int u = 1; u <= n; ++u) {
        if (degs[u] & 1) ++odd;
    }
    printf("%d\n", max(odd / 2, 1));

    return 0;
}