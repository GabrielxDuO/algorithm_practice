#include <cstdio>
#include <cctype>
#include <cstring>

using namespace std;

const int N = 5e5 + 10;
int n, q;
char s[N];
int keep[N];

int main() {
    scanf("%d%s%d", &n, s + 1, &q);
    int stat = 1, cnt = 0;
    while (q--) {
        int t, x;
        char c;
        scanf("%d%d %c", &t, &x, &c);
        if (t == 1) {
            s[x] = c;
            keep[x] = cnt;
        } else {
            stat = t;
            ++cnt;
        }
    }
    if (stat == 1) puts(s + 1);
    else {
        for (int i = 1; i <= n; ++i) {
            if (keep[i] != cnt) s[i] = stat == 2 ? tolower(s[i]) : toupper(s[i]);
            putchar(s[i]);
        }
    }

    return 0;
}