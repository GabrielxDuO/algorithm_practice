#include <cstdio>
#include <vector>

using namespace std;

const int N = 1e5 + 10, M = 110;
int n, m, k;
vector<int> ne[N];
int saves[M];

int main() {
    scanf("%d%d", &n, &m);
    for (int u = 1; u <= n; ++u) {
        scanf("%d", &k);
        ne[u].resize(k + 1);
        for (int i = 1; i <= k; ++i) scanf("%d", &ne[u][i]);
    }
    int curr = 1;
    while (m--) {
        int op, x;
        scanf("%d%d", &op, &x);
        if (op == 0) {
            curr = ne[curr][x];
        } else if (op == 1) {
            saves[x] = curr;
            printf("%d\n", curr);
        } else {
            curr = saves[x];
        }
    }
    printf("%d\n", curr);

    return 0;
}