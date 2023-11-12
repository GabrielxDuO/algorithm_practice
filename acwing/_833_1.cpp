#include <cstdio>
#include <cstring>

using namespace std;

const int N = 1e6 + 10, M = 1e5 + 10;
int n, m;
char p[M], s[N];
char str[N + M];
int pi[N * 2];

int main() {
    scanf("%d%s", &m, p);
    scanf("%d%s", &n, s);
    strcpy(str, p);
    str[m] = '#';
    strcpy(str + m + 1, s);
    for (int i = 1; i < m + 1 + n; ++i) {
        int j = pi[i - 1];
        while (j > 0 && str[i] != str[j]) j = pi[j - 1];
        if (str[i] == str[j]) ++j;
        pi[i] = j;
        if (pi[i] == m) printf("%d ", i - 2 * m);
    }

    return 0;
}