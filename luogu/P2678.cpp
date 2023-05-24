#include <iostream>

using namespace std;

const int MAX_N = 5e4 + 10, INF = 0x3f3f3f3f;
int L, N, M;
int a[MAX_N];

bool check(int m) {
    int cnt = 0, prev = 0;
    for (int i = 1; i <= N; ++i) {
        if (a[i] - prev < m) {
            if (++cnt > M) return false;
        } else prev = a[i];
    }
    return cnt <= M;
}

int main() {
    scanf("%d%d%d", &L, &N, &M);
    int l = INF, r = L;
    for (int i = 1; i <= N; ++i) {
        scanf("%d", &a[i]);
        l = min(l, a[i] - a[i - 1]);
    }
    a[++N] = L;
    l = min(l, a[N + 1] - a[N]);
    while (l < r) {
        int m = l + r + 1 >> 1;
        if (check(m)) l = m;
        else r = m - 1;
    }
    printf("%d\n", l);

    return 0;
}