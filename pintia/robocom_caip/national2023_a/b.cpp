#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;

int t;
int a[10][10];
int k1, k2, t1, t2;
bool vis[10][10];

void dfs(int u, int sum, int arr[], int l, int r) {
    if (u == 3) {
        if (sum >= l && sum <= r) ++t1;
        else ++t2;
        return;
    }
    for(int x = 1; x <= 8; ++ x) {
        if(!vis[arr[u]][x]) {
            vis[arr[u]][x] = true;
            dfs(u + 1, sum + x, arr, l, r);
            vis[arr[u]][x] = false; 
        }
    }
}

void check(int arr[], int l, int r) {
    t1 = t2 = 0;
    dfs(0, 0, arr, l, r);
    int mt = min(t1, t2), mk = min(k1, k2);
    if (mt > mk || mt == mk && abs(t1 - t2) < abs(k1 - k2))
        k1 = t1, k2 = t2;
}

int main() {
    scanf("%d", &t);
    while (t--) {
        k1 = k2 = -1;
        memset(vis, false, sizeof(vis));
        int n; scanf("%d", &n);
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= 6; ++j) {
                scanf("%d", &a[i][j]);
                vis[j][a[i][j]] = true;
            }
        }
        for (int i = 1; i <= 6; ++i) {
            for (int j = i + 1; j <= 6; ++j) {
                for (int k = j + 1; k <= 6; ++k) {
                    for (int l = 3; l <= 24; ++l) {
                        for (int r = l; r <= 24; ++r) {
                            int arr[] = {i, j, k};
                            check(arr, l, r);
                        }
                    }
                }
            }
        }
        printf("%d\n", (int) pow(8 - n, 3) * max(k1, k2));
    }

    return 0;
}