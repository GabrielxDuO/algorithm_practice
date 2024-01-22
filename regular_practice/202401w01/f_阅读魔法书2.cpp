#include <cstdio>
#include <cstring>
#include <queue>

using namespace std;

const int S = 5e5 + 10, N = 110, P = 1e3 + 10, K = 26;
int n;
char str[S], pat[P];
int sons[N * P][K], cnts[N * P], idx, fail[N * P];

void insert(char* s) {
    int p = 0;
    for (int k = 0; s[k]; ++k) {
        int i = s[k] - 'a';
        if (!sons[p][i]) sons[p][i] = ++idx;
        p = sons[p][i];
    }
    ++cnts[p];
}

void build() {
    queue<int> que;
    for (int i = 0; i < K; ++i) {
        if (sons[0][i]) que.push(sons[0][i]);
    }
    while (!que.empty()) {
        int u = que.front(); que.pop();
        for (int i = 0; i < K; ++i) {
            int v = sons[u][i];
            if (v) fail[v] = sons[fail[u]][i], que.push(v);
            else sons[u][i] = sons[fail[u]][i];
        }
    }
}

int query(char* s) {
    int res = 0;
    for (int k = 0, u = 0; s[k]; ++k) {
        u = sons[u][s[k] - 'a'];
        for (int v = u; v; v = fail[v]) {
            res += cnts[v];
        }
    }
    return res;
}

int main() {
    scanf("%s", str);
    scanf("%d", &n);    
    while (n--) {
        scanf("%s", pat);
        insert(pat);
    }
    build();
    printf("%d\n", query(str));

    return 0;
}