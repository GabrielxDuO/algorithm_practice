#include <cstdio>
#include <algorithm>
#include <unordered_map>
#include <vector>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 1010;
int m, n, k, l, d;
unordered_map<int, int> r, c;
vector<PII> vec;
vector<int> ans;

int main() {
    scanf("%d%d%d%d%d", &m, &n, &k, &l, &d);
    while (d--) {
        int x, y, p, q;
        scanf("%d%d%d%d", &x, &y, &p, &q);
        if (x == p) ++c[min(y, q)];
        else ++r[min(x, p)];
    }
    for (auto pr : r) vec.push_back(pr);
    sort(vec.begin(), vec.end(), [](const PII& a, const PII& b) { return a.se > b.se; });
    for (auto pr : vec) {
        if (--k < 0) break;
        ans.push_back(pr.fi);
    }
    sort(ans.begin(), ans.end());
    for (auto x : ans) printf("%d ", x);
    puts("");
    vec.clear();
    for (auto pr : c) vec.push_back(pr);
    sort(vec.begin(), vec.end(), [](const PII& a, const PII& b) { return a.se > b.se; });
    ans.clear();
    for (auto pr : vec) {
        if (--l < 0) break;
        ans.push_back(pr.fi);
    }
    sort(ans.begin(), ans.end());
    for (auto x : ans) printf("%d ", x);

    return 0;
}