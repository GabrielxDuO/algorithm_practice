#include <cstdio>

using namespace std;

const int N = 1e6 + 10, M = 1e5 + 10;
int n, m;
char p[M], s[N];
int pi[M];

int main() {
    scanf("%d%s", &m, p + 1);
    scanf("%d%s", &n, s + 1);
    for (int i = 2, j = 0; i <= m; ++i) {
        while (j > 0 && p[i] != p[j + 1]) j = pi[j];
        if (p[i] == p[j + 1]) ++j;
        pi[i] = j;
    }
    for (int i = 1, j = 0; i <= n; ++i) {
        while (j > 0 && s[i] != p[j + 1]) j = pi[j];
        if (s[i] == p[j + 1]) ++j;
        if (j == m) {
            printf("%d ", i - j);
            j = pi[j];
        }
    }

    return 0;
}