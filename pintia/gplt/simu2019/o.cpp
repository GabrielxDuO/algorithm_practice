#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 1e6 + 10;
char s[N];
LL f[N][5];

int main() {
    cin.getline(s, N);
    int n = strlen(s);
    f[0][0] = 1L;
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= 3; ++j) {
            f[i][j] += f[i - 1][j];
            if (j) f[i][j] += f[i - 1][j - 1];
            for (int k = i - 1; k >= 1 && i <= j + k; --k) {
                if (s[k - 1] == s[i - 1]) {
                    f[i][j] -= f[k - 1][j - i + k];
                    break;
                }
            }
        }
    }
    LL sum = 0L;
    for (int i = 0; i <= 3; ++i) sum += f[n][i];
    printf("%lld\n", sum);

    return 0;
}