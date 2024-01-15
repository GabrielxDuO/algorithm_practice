#include <cstdio>
#include <utility>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

const int N = 1e3 + 10, DIRS[][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
int n, m, t;
bool vis[N][N];

int main() {
    scanf("%d%d%d", &n, &m, &t);
    int cnt = t;
    queue<PII> que;
    while (t--) {
        int x, y;
        scanf("%d%d", &x, &y);
        vis[x][y] = true;
        que.push({x, y});
    }
    if (cnt == n * m) {
        puts("0");
        return 0;
    }
    int step = 0;
    while (!que.empty()) {
        int sz = que.size();
        while (sz--) {
            PII pr = que.front(); que.pop();
            int x = pr.first, y = pr.second;
            for (auto& DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx < 1 || nx > n || ny < 1 || ny > m || vis[nx][ny]) continue;
                ++cnt;
                vis[nx][ny] = true;
                que.push({nx, ny});
            }
        }
        ++step;
        if (cnt == n * m) {
            printf("%d\n", step);
            return 0;
        }
    }

    return 0;
}