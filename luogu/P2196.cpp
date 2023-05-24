#include <iostream>
#include <vector>

using namespace std;

const int N = 30;
int n;
int w[N];
bool con[N][N];
bool vis[N];
vector<int> path;
int ans;
vector<int> ans_path;

void dfs(int u, int sum) {
    for (int v = u + 1; v <= n; ++v) {
        if (con[u][v] && !vis[v]) {
            vis[v] = true;
            path.push_back(v);
            dfs(v, sum + w[v]);
            vis[v] = false;
            path.pop_back();
        }
    }
    if (sum > ans) {
        ans = sum;
        ans_path = path;
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &w[i]);
    for (int i = 1; i < n; ++i) {
        for (int j = i + 1; j <= n; ++j) scanf("%d", &con[i][j]);
    }
    for (int i = 1; i < n; ++i) con[0][i] = 1;
    dfs(0, 0);
    for (auto& p : ans_path) printf("%d ", p);
    printf("\n%d\n", ans);

    return 0;
}