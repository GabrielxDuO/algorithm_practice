#include <cstdio>
#include <utility>
#include <functional>
#include <unordered_map>

using namespace std;

struct Info {
    int x, y;

    bool operator==(const Info& o) const {
        return x == o.x && y == o.y;
    }
};

struct InfoHash {
    size_t operator()(const Info& info) const {
        return hash<int>()(info.x) ^ hash<int>()(info.y);
    }
};

const int N = 2e5 + 10;
unordered_map<char, Info> DIRS;
int t, n;
char s[N];
unordered_map<Info, int, InfoHash> mp;

void solve() {
    scanf("%d%s", &n, s + 1);
    mp.clear();
    int x = 0, y = 0;
    int mn = n + 1, l = -1;
    for (int i = 1; i <= n; ++i) {
        mp[{x, y}] = i;
        const Info& DIR = DIRS[s[i]];
        x += DIR.x, y += DIR.y;
        int j = mp[{x, y}];
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
    DIRS['L'] = {-1, 0};
    DIRS['R'] = {1, 0};
    DIRS['U'] = {0, 1};
    DIRS['D'] = {0, -1};
    while (t--) solve();

    return 0;
}