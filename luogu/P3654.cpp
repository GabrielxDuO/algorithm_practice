#include <iostream>

using namespace std;

const int N = 110;
int r, c, k;
char g[N][N];

int main() {
    scanf("%d%d%d\n", &r, &c, &k);
    for (int i = 0; i < r; ++i) cin.getline(g[i], c + 1);
    int ans = 0;
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            int cnt = 0;
            while (g[i][j] == '.') ++j, ++cnt;
            ans += max(0, cnt - k + 1);
        }
    }
    for (int j = 0; j < c; ++j) {
        for (int i = 0; i < r; ++i) {
            int cnt = 0;
            while (g[i][j] == '.') ++i, ++cnt;
            ans += max(0, cnt - k + 1);
        }
    }
    printf("%d\n", k == 1 ? ans / 2 : ans);

    return 0;
}