#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 1010, K = 110;
int n, m, k;
vector<int> v[K], w[K];
int f[N];

int main() {
    scanf("%d%d", &m, &n);
    for (int i = 1; i <= n; ++i) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        v[c].push_back(a);
        w[c].push_back(b);
        k = max(k, c);
    }
    for (int i = 1; i <= k; ++i) {
        int sz = v[i].size();
        for (int j = m; j >= 0; --j) {
            for (int k = 0; k < sz; ++k) {
                if (j >= v[i][k]) f[j] = max(f[j], f[j - v[i][k]] + w[i][k]);
            }
        }
    }
    printf("%d\n", f[m]);

    return 0;
}