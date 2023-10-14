#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e6 + 10;
int n, m;
char s[N * 2], t[N];
int ne[N];

int main() {
    scanf("%d%s%s", &n, s + 1, t + 1);
    m = n, n *= 2;
    for (int i = 1; i <= m; ++i) {
        s[m + i] = s[i];
        t[i] = t[i] <= 'Z' ? t[i] + 32 : t[i] - 32;
    }
    for (int i = 2, j = 0; i <= m; ++i) {
        while (j && t[i] != t[j + 1]) j = ne[j];
        if (t[i] == t[j + 1]) ++j;
        ne[i] = j;
    }
    for (int i = 1, j = 0; i <= n; ++i) {
        while (j && s[i] != t[j + 1]) j = ne[j];
        if (s[i] == t[j + 1]) ++j;
        if (j == m) {
            puts("Yes");
            printf("%d\n", min(i - m, m - (i - m)));
            return 0;
        }
    }
    puts("No");

    return 0;
}