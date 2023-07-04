#include <cstdio>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
map<vector<int>, int> mp;
struct Mod {
    vector<int> output;
    int cnt;

    bool operator<(const Mod& o) const {
        if (cnt != o.cnt) return cnt > o.cnt;
        for (int i = 0; i < m; ++i) {
            if (output[i] != o.output[i]) return output[i] < o.output[i];
        }
    }
};

int main() {
    scanf("%d%d", &n, &m);
    while (n--) {
        vector<int> vec;
        int x;
        for (int i = 0; i < m; ++i) {
            scanf("%d", &x);
            vec.push_back(x);
        }
        ++mp[vec];
    }
    vector<Mod> mods;
    for (auto pr : mp) mods.push_back({pr.first, pr.second});
    sort(mods.begin(), mods.end());
    printf("%d\n", mods.size());
    for (const Mod& mod : mods) {
        printf("%d", mod.cnt);
        for (const int& x : mod.output) printf(" %d", x);
        puts("");
    }


    return 0;
}