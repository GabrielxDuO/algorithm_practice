#include <cstdio>
#include <unordered_map>
#include <vector>

using namespace std;

typedef long long LL;

const int N = 3e5 + 10;
int n, a[N];
unordered_map<int, vector<int>> mp;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        mp[x].push_back(i);
    }
    LL ans = 0LL;
    for (auto& [x, btwn] : mp) {
        int sz = btwn.size();
        if (sz == 1) continue;
        for (int i = 0; i < sz - 1; ++i) {
            LL cnt = 1LL * (btwn[i + 1] - btwn[i] - 1) * (i + 1) * (sz - (i + 1));
            ans += cnt;
        }
    }
    printf("%lld\n", ans);

    return 0;
}