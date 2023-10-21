#include <cstdio>
#include <unordered_map>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10, MASK = 1e6;
int DIRS[128][2];
int t, n;
char s[N];
unordered_map<LL, int> mp;

void solve() {
    scanf("%d%s", &n, s + 1);
    mp.clear();
    int mn = n + 1, l = 0;
    int x = 0, y = 0;
    for (int i = 1; i <= n; ++i) {
        mp[1LL * x * MASK + y] = i;
        const auto& DIR = DIRS[s[i]];
        x += DIR[0], y += DIR[1];
        int j = mp[1LL * x * MASK + y];
        if (j) {
            int len = i - j + 1;
            if (len < mn) {
                mn = len;
                l = j;
            }
        }
    }
    if (mn <= n) printf("%d %d\n", l, l + mn - 1);
    else puts("-1");
}

int main() {
    scanf("%d", &t);
    DIRS['L'][0] = -1, DIRS['L'][1] = 0;
    DIRS['R'][0] = 1, DIRS['R'][1] = 0;
    DIRS['U'][0] = 0, DIRS['U'][1] = 1;
    DIRS['D'][0] = 0, DIRS['D'][1] = -1;
    while (t--) solve();

    return 0;
}