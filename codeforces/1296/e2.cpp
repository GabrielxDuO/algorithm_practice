#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 2e5 + 10;
int n;
char s[N];
int f[N], g[128];

int main() {
    scanf("%d%s", &n, &s);
    getchar();
    int mx = 0;
    for (int i = 0; i < n; ++i) {
        f[i] = 1;
        for (int j = 'a'; j <= 'z'; ++j) {
            if (j > s[i]) f[i] = max(f[i], g[j] + 1);
        }
        g[s[i]] = f[i];
        mx = max(mx, f[i]);
    }
    printf("%d\n", mx);
    for (int i = 0; i < n; ++i) printf("%d ", f[i]);

    return 0;
}