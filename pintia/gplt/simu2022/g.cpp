#include <cstdio>

using namespace std;

const int N = 110;
int n, k, x;
int g[N][N];

int main() {
    scanf("%d%d%d", &n, &k, &x);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) scanf("%d", &g[i][j]);
    }
    for (int j = 1, cnt = 0; j < n; j += 2, ++cnt) {
        int move = (cnt % k) + 1;
        for (int i = n - 1; i >= move; --i) {
            g[i][j] = g[i - move][j];
        }
        for (int i = 0; i < move; ++i) g[i][j] = x;
    }
    bool is_first = true;
    for (int i = 0; i < n; ++i) {
        int sum = 0;
        for (int j = 0; j < n; ++j) sum += g[i][j];
        if (is_first) is_first = false;
        else printf(" ");
        printf("%d", sum);
    }

    return 0;
}