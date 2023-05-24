#include <iostream>
#include <cstring>

using namespace std;

const int N = 35;
int l, r;
int len, digits[N];
int f[N][N][N];

int dfs(int pos, int zero, int one, bool lead, bool lim) {
    if (pos < 0) return zero >= one;
    if (!lim && !lead && ~f[pos][zero][one]) return f[pos][zero][one];
    int res = 0, up = lim ? digits[pos] : 1;
    for (int d = 0; d <= up; ++d) {
        bool lead_zero = lead && !d;
        res += dfs(pos - 1, zero + (!lead_zero && !d), one + d, lead_zero, lim && d == digits[pos]);
    }
    return lim || lead ? res : f[pos][zero][one] = res;
}

int count(int n) {
    for (len = 0; n; n >>= 1) digits[len++] = n & 1;
    memset(f, -1, sizeof(f));
    return dfs(len - 1, 0, 0, true, true);
}

int main() {
    scanf("%d%d", &l, &r);
    printf("%d\n", count(r) - count(l - 1));

    return 0;
}