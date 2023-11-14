#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 110;
int n;
int d[N][N];

int main() {
    scanf("%d", &n);
    int mx_x = 0, mx_y = 0;
    while (n--) {
        int x1, y1, x2, y2;
        scanf("%d%d%d%d", &x1, &x2, &y1, &y2);
        ++x1, ++y1, ++x2, ++y2;
        ++d[x1][y1];
        --d[x2][y1];
        --d[x1][y2];
        ++d[x2][y2];
        mx_x = max(mx_x, x2);
        mx_y = max(mx_y, y2);
    }
    int ans = 0;
    for (int i = 1; i <= mx_x; ++i) {
        for (int j = 1; j <= mx_y; ++j) {
            d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
            if (d[i][j] > 0) ++ans;
        }
    }
    printf("%d\n", ans);

    return 0;
}