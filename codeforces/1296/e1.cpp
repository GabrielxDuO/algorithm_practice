#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 210;
int n;
char s[N];
int pos[N];
int h[N], e[N * N], ne[N * N], idx;
int color[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool dye(int u, int c) {
    color[u] = c;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (color[v] == -1 && !dye(v, !c) || color[v] == c) return false;
    }
    return true;
}

int main() {
    scanf("%d%s", &n, s + 1);
    memset(h, -1, sizeof(h));
    for (int i = 1; i <= n; ++i) pos[i] = i;
    for (int i = 1; i <= n - 1; ++i) {
        for (int j = 1; j <= n - i; ++j) {
            if (s[j] > s[j + 1]) {
                swap(s[j], s[j + 1]), swap(pos[j], pos[j + 1]);
                add(pos[j], pos[j + 1]), add(pos[j + 1], pos[j]);
            }
        }
    }
    memset(color, -1, sizeof(color));
    for (int u = 1; u <= n; ++u) {
        if (color[u] == -1 && !dye(u, 0)) {
            puts("NO");
            return 0;
        }
    }
    puts("YES");
    for (int i = 1; i <= n; ++i) putchar('0' + color[i]);

    return 0;
}