#include <cstdio>
#include <set>
#include <vector>

using namespace std;

const int N = 110;
int n;
multiset<int> a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int c, x;
        scanf("%d", &c);
        while (c--) scanf("%d", &x), a[i].insert(x);
    }
    int x; scanf("%d", &x);
    vector<int> anss;
    int mn = 100;
    for (int i = 0; i < n; ++i) {
        if (a[i].find(x) == a[i].end()) continue;
        if (a[i].size() > mn) continue;
        if (a[i].size() < mn) anss.clear();
        anss.push_back(i);
        mn = a[i].size();
    }
    printf("%d\n", anss.size());
    for (const int ans : anss) printf("%d ", ans + 1);

    return 0;
}