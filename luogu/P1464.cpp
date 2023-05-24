#include <iostream>

using namespace std;

typedef long long LL;

const int N = 30;
int f[N][N][N];
bool vis[N][N][N];

LL w(LL a, LL b, LL c) {
    if (a <= 0 || b <= 0 || c <= 0) return 1L;
    if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
    if (vis[a][b][c]) return f[a][b][c];
    LL res; 
    if (a < b && b < c) res = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
    else res = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    vis[a][b][c] = true;
    return f[a][b][c] = res;
}

int main() {
    LL a, b, c;
    while (~scanf("%lld%lld%lld", &a, &b, &c) && (~a || ~b || ~c)) {
        printf("w(%lld, %lld, %lld) = %lld\n", a, b, c, w(a, b, c));
    }

    return 0;
}