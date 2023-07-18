#include <iostream>

using namespace std;

int main() {
    int N, M;
    scanf("%d%d", &N, &M);
    int weights[N], values[N], c, total_value = 0;
    for (int i = 0; i < N; ++i) scanf("%d", &weights[i]);
    for (int i = 0; i < N; ++i) {
        scanf("%d", &c);
        values[i] = c;
        total_value += c;
    }
    int dp[total_value + 1];
    fill(dp + 1, dp + total_value + 1, 0x3f3f3f3f);
    dp[0] = 0;
    for (int i = 0; i < N; ++i) {
        for (int j = total_value; j >= values[i]; --j) {
            dp[j] = min(dp[j], dp[j - values[i]] + weights[i]);
        }
    }
    while (dp[total_value] > M) total_value--;
    printf("%d", total_value);

    return 0;
}
