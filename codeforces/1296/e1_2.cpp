#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 210;
int n;
int chr_color[128], pos_color[N];

int main() {
    scanf("%d", &n);
    getchar();
    for (int i = 0; i < n; ++i) {
        char c = getchar();
        for (char j = 'a'; j <= 'z'; ++j) {
            if (c < j) pos_color[i] = max(pos_color[i], chr_color[j]);
        }
        if (pos_color[i] > 1) {
            puts("NO");
            return 0;
        }
        chr_color[c] = ++pos_color[i];
    }
    puts("YES");
    for (int i = 0; i < n; ++i) putchar('0' + pos_color[i] - 1);

    return 0;
}