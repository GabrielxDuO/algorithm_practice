#include <cstdio>
#include <unordered_map>

using namespace std;

const int N = 1010;
int n, m;
int heap[N];
unordered_map<int, int> mp;

void up(int u) {
    int p = u >> 1;
    if (p > 0 && heap[p] > heap[u]) {
        swap(heap[p], heap[u]);
        up(p);
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        int x; scanf("%d", &heap[i]);
    }
    for (int i = 1; i <= n; ++i) up(i);
    for (int i = 1; i <= n; ++i) mp[heap[i]] = i;
    while (m--) {
        char s[10];
        int x;
        scanf("%d %s", &x, s);
        if (s[0] == 'a') {
            int y; scanf("%d", &y);
            int ix = mp[x], iy = mp[y];
            // siblings
            puts((ix >> 1) == (iy >> 1) ? "T" : "F");
            scanf("%*s %*s");
        } else {
            scanf("%s", s);
            if (s[0] == 'a') {
                int y; scanf("%*s %*s %d", &y);
                int ix = mp[x], iy = mp[y];
                // child
                puts((ix >> 1) == iy ? "T" : "F");
            } else {
                scanf("%s", s);
                // root
                if (s[0] == 'r') puts(mp[x] == 1 ? "T" : "F");
                else {
                    int y; scanf("%*s %d", &y);
                    int ix = mp[x], iy = mp[y];
                    // parent
                    puts(ix == (iy >> 1) ? "T" : "F");
                }
            }
        }
    }

    return 0;
}