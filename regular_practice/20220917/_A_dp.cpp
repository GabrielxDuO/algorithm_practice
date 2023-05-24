#include <iostream>

using namespace std;

const int MOD = 1e9 + 7;
const int opp[] = {-1, 4, 5, 6, 1, 2, 3};
bool conflict[7][7];
long long dp[2][7];

int main() {
    int n, m;
    scanf("%d%d", &n, &m);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        conflict[a][b] = true;
        conflict[b][a] = true;
    }
    for (int i = 1; i <= 6; ++i) dp[0][i] = 1L;
    int prev = 1, curr = 0;
    for (int level = 2; level <= n; ++level) {
        swap(curr, prev);
        for (int upper_top = 1; upper_top <= 6; ++upper_top) {
            long poss = 0L;
            int upper_bottom = opp[upper_top];
            for (int lower_top = 1; lower_top <= 6; ++lower_top) {
                if (conflict[lower_top][upper_bottom]) continue;
                poss = (poss + dp[prev][lower_top]) % MOD;
            }
            dp[curr][upper_top] = poss;
        }
    }
    long long sum = 0L;
    for (int i = 1; i <= 6; ++i) sum = (sum + dp[curr][i]) % MOD;
    long long ans = 1L, base = 4L;
    while (n != 0) {
        if ((n & 1) != 0) ans = (ans * base) % MOD;
        base = (base * base) % MOD;
        n >>= 1;
    }
    printf("%lld", (sum * ans) % MOD);

    return 0;
}