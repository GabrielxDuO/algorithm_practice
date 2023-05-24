#include <iostream>

using namespace std;

const int N = 10;
int n;
int chosen[N];
bool used[N];

void dfs(int u) {
    if (u == n) {
        for (int i = 0; i < n; ++i) printf("%5d", chosen[i]);
        puts(" ");
        return;
    }
    for (int x = 1; x <= n; ++x) {
        if (!used[x]) {
            chosen[u] = x;
            used[x] = true;
            dfs(u + 1);
            used[x] = false;
        }
    }
}

int main() {
    scanf("%d", &n);
    dfs(0);

    return 0;
}