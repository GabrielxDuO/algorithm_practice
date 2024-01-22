#include <cstdio>
#include <cstring>
#include <queue>
#include <algorithm>

using namespace std;

const int P = 1010, N = 105, S = 1e5 + 10, K = 26;
int n;
char pat[N][P], str[S];
int sons[P * N][K], mark[P * N], idx, fail[P * N];
int que[P * N], hh, tt = -1;
int cnts[N], anss[N];

void insert(char* s, int pos) {
    int p = 0;
    for (int k = 0; s[k]; ++k) {
        int i = s[k] - 'a';
        if (!sons[p][i]) sons[p][i] = ++idx;
        p = sons[p][i];
    }
    mark[p] = pos;
}

void build() {
    hh = 0, tt = -1;
    for (int i = 0; i < K; ++i) {
        if (sons[0][i]) que[++tt] = sons[0][i];
    }
    while (hh <= tt) {
        int u = que[hh++];
        for (int i = 0; i < K; ++i) {
            int v = sons[u][i];
            if (v) fail[v] = sons[fail[u]][i], que[++tt] = v;
            else sons[u][i] = sons[fail[u]][i];
        }
    }
}

void query(char* s) {
    int res = 0;
    for (int k = 0, u = 0; s[k]; ++k) {
        u = sons[u][s[k] - 'a'];
        for (int v = u; v; v = fail[v]) {
            ++cnts[mark[v]];
        }
    }
}

int main() {
    scanf("%s%d", str, &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%s", pat[i]);
        insert(pat[i], i);
    }
    build();
    query(str);
    int ansi = 0, mx = 0;
    for (int i = 1; i <= n; ++i) {
        if (cnts[i] > mx) {
            mx = cnts[i];
            ansi = 0;
        }
        if (cnts[i] == mx) anss[ansi++] = i;
    }
    sort(anss, anss + ansi, [&](const int & i, const int& j) { return strcmp(pat[i], pat[j]) < 0; });
    printf("%d\n", mx);
    for (int i = 0; i < ansi; ++i) puts(pat[anss[i]]);

    return 0;
}