#include <cstdio>
#include <cstring>

using namespace std;

const int N = 15;
int t, n, m;
char ss[N][N];
char ans[N];
int cnts[26];

bool check(const char s[]) {
    for (int i = 0; i < n; ++i) {
        int cnt = 0;
        for (int j = 0; j < m; ++j) {
            if (ss[i][j] != s[j]) {
                if (++cnt > 1) return false;
            }
        }
    }
    return true;
}

void solve() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%s", ss[i]);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            for (int k = 0; k < 26; ++k) {
                if (++ss[i][j] > 'z') ss[i][j] = 'a';
                if (check(ss[i])) {
                    puts(ss[i]);
                    return;
                }
            }
        }
    }
    puts("-1");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}