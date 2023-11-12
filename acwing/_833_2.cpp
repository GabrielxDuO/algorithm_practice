#include <cstdio>

using namespace std;

const int N = 1e6 + 10, M = 1e5 + 10;
int n, m;
char p[M], s[N];
int pi[M];

int main() {
    scanf("%d%s", &m, p);
    scanf("%d%s", &n, s);
    pi[0] = 0;
    for (int i = 1, j = 0; i < m; ++i) {
        while (j > 0 && p[i] != p[j]) j = pi[j - 1];
        if (p[i] == p[j]) ++j;
        pi[i] = j;
    }
    for (int i = 0, j = 0; i < n; ++i) {
        while (j > 0 && s[i] != p[j]) j = pi[j - 1];
        if (s[i] == p[j]) ++j;
        if (j == m) {
            printf("%d ", i - j + 1);
            j = pi[j - 1];
        }
    }

    return 0;
}