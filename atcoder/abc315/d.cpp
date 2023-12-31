#include <cstdio>

using namespace std;

const int N = 2010;
int n, m;
char g[N][N];
int row_cnts[N][26], col_cnts[N][26];
bool row_removed[N], col_removed[N];
int row_expunged[N], col_expunged[N], rec, cec;

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) {
        getchar();
        for (int j = 0; j < m; ++j) {
            g[i][j] = getchar();
            ++row_cnts[i][g[i][j] - 'a'];
            ++col_cnts[j][g[i][j] - 'a'];
        }
    }
    while (true) {
        rec = 0;
        for (int i = 0; i < n; ++i) {
            if (row_removed[i]) continue;
            int cnt = 0;
            bool sole = false;
            for (int c = 0; c < 26; ++c) {
                if (row_cnts[i][c] == 0) continue;
                cnt += row_cnts[i][c];
                sole = !sole;
                if (!sole) break;
            }
            if (sole && cnt >= 2) row_expunged[rec++] = i;
        }
        cec = 0;
        for (int j = 0; j < m; ++j) {
            if (col_removed[j]) continue;
            int cnt = 0;
            bool sole = false;
            for (int c = 0; c < 26; ++c) {
                if (col_cnts[j][c] == 0) continue;
                cnt += col_cnts[j][c];
                sole = !sole;
                if (!sole) break;
            }
            if (sole && cnt >= 2) col_expunged[cec++] = j;
        }
        if (rec == 0 && cec == 0) break;
        for (int i = 0; i < rec; ++i) {
            const int& r = row_expunged[i];
            row_removed[r] = true;
            for (int c = 0; c < m; ++c) {
                if (g[r][c] == '.') continue;
                --row_cnts[r][g[r][c] - 'a'];
                --col_cnts[c][g[r][c] - 'a'];
                g[r][c] = '.';
            }
        }
        for (int i = 0; i < cec; ++i) {
            const int& c = col_expunged[i];
            col_removed[c] = true;
            for (int r = 0; r < n; ++r) {
                if (g[r][c] == '.') continue;
                --row_cnts[r][g[r][c] - 'a'];
                --col_cnts[c][g[r][c] - 'a'];
                g[r][c] = '.';
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) ans += (g[i][j] != '.');
    }
    printf("%d\n", ans);

    return 0;
}