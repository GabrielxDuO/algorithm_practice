#include <cstdio>
#include <unordered_set>

using namespace std;

const int K = 1e5 + 10, N = 15, M = 1e3 + 10;
int a, b, n, m;
unordered_set<int> st;
bool is_out[N];
int g[N][M];
int winner_cnt;

int main() {
    scanf("%d%d%d%d", &a, &b, &n, &m);
    st.insert(a); st.insert(b);
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) scanf("%d", &g[i][j]);
    }
    winner_cnt = n;
    for (int k = 1; k <= m; ++k) {
        for (int i = 1; i <= n; ++i) {
            if (is_out[i]) continue;
            int& z = g[i][k];
            bool out = true;
            if (st.find(z) == st.end()) {
                for (auto& x : st) {
                    int y = x + z;
                    if (st.find(y) != st.end()) {
                        out = false;
                        break;
                    }
                }
            }
            if (out) {
                is_out[i] = true;
                --winner_cnt;
                printf("Round #%d: %d is out.\n", k, i);
            } else st.insert(z);
        }
    }
    if (!winner_cnt) puts("No winner.");
    else {
        printf("Winner(s):");
        for (int i = 1; i <= n; ++i) {
            if (!is_out[i]) printf(" %d", i);
        }
    }

    return 0;
}