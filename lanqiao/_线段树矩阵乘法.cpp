#include <cstdio>
#include <cstring>

using namespace std;

const int N = 1e5 + 10, K = 2, MOD = 998244353;
int n, q;
int a[N][K][K];
int op;
int idx, d[K][K];

struct Node {
    int l, r;
    int mat[K][K];
} tr[N * 4];

void prt(int mat[K][K]) {
    for (int i = 0; i < K; ++i) {
        for (int j = 0; j < K; ++j) {
            printf("%d ", mat[i][j]);
        }
    }
}

void mul(int c[][K], int a[][K], int b[][K]) {
    for (int i = 0; i < K; ++i) {
        for (int j = 0; j < K; ++j) {
            for (int k = 0; k < K; ++k) {
                c[i][j] = (int) ((c[i][j] + 1LL * a[i][k] * b[k][j] % MOD) % MOD);
            }
        }
    }
}

void push_up(int u) {
    memset(tr[u].mat, 0, K * K * sizeof(int));
    mul(tr[u].mat, tr[u << 1].mat, tr[u << 1 | 1].mat);
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) memcpy(tr[u].mat, a[l], K * K * sizeof(int));
    else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int i, int x[K][K]) {
    if (tr[u].l == tr[u].r) memcpy(tr[u].mat, x, K * K * sizeof(int));
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= i) modify(u << 1, i, x);
        else modify(u << 1 | 1, i, x);
        push_up(u);
    }
}

void query(int u, int l, int r, int res[K][K]) {
    if (tr[u].l >= l && tr[u].r <= r) memcpy(res, tr[u].mat, K * K * sizeof(int));
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= r) query(u << 1, l, r, res);
        else if (m + 1 <= l) query(u << 1 | 1, l, r, res);
        else {
            int lm[][K] = {{0, 0}, {0, 0}}, rm[][K] = {{0, 0}, {0, 0}};
            query(u << 1, l, r, lm);
            query(u << 1 | 1, l, r, rm);
            mul(res, lm, rm);
        }
    }
}

int main() {
    scanf("%d%d", &n, &q);
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j < K; ++j) {
            for (int k = 0; k < K; ++k) scanf("%d", &a[i][j][k]);
        }
    }
    build(1, 1, n);
    while (q--) {
        scanf("%d", &op);
        if (op == 1) {
            scanf("%d%d%d%d%d", &idx, &d[0][0], &d[0][1], &d[1][0], &d[1][1]);
            modify(1, idx, d);
        } else {
            int l, r; scanf("%d%d", &l, &r);
            int res[][K] = {{0, 0}, {0, 0}};
            query(1, l, r, res);
            prt(res);
            putchar('\n');
        }
    }

    return 0;
}