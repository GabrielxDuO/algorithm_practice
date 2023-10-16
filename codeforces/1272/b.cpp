#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int q;
char s[N];

int main() {
    scanf("%d", &q);
    while (q--) {
        scanf("%s", s);
        int u = 0, d = 0, l = 0, r = 0;
        for (int i = 0; s[i]; ++i) {
            if (s[i] == 'L') ++l;
            else if (s[i] == 'R') ++r;
            else if (s[i] == 'U') ++u;
            else ++d;
        }
        l = r = min(l, r);
        u = d = min(u, d);
        if (l == 0) u = d = min(u, 1);
        if (u == 0) l = r = min(l, 1);
        printf("%d\n", l + r + u + d);
        while (l--) putchar('L');
        while (u--) putchar('U');
        while (r--) putchar('R');
        while (d--) putchar('D');
        putchar('\n');
    }

    return 0;
}