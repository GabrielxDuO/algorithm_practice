#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> chosen;
int ans;
vector<vector<int>> anss;

void dfs(int u, int sum) {
    if (sum > n) return;
    if (u == 10) {
        if (sum == n) {
            ++ans;
            anss.push_back(vector<int>(chosen));
        }
        return;
    }
    for (int x = 1; x <= 3; ++x) {
        chosen.push_back(x);
        dfs(u + 1, sum + x);
        chosen.pop_back();
    }
} 

int main() {
    scanf("%d", &n);
    if (n < 10) {
        puts("0");
        return 0;
    }
    dfs(0, 0);
    printf("%d\n", ans);
    for (auto& vec : anss) {
        for (int& x : vec) printf("%d ", x);
        puts("");
    }

    return 0;
}