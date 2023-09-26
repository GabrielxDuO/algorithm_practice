#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long LL;

int k;
vector<LL> vec;

void dfs(LL x, int d) {
    if (d < 0) return;
    if (x) vec.push_back(x);
    for (int i = d - 1; i >= 0; --i) dfs(x * 10 + i, i);
}

int main() {
    scanf("%d", &k);
    dfs(0LL, 10);
    sort(vec.begin(), vec.end());
    printf("%lld\n", vec[k - 1]);

    return 0;
}