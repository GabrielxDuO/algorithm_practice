#include <iostream>
#include <limits>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

const int N = 900;
const int DIRS4[][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
const int DIRS8[][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
int t, n, m;
char g[N][N];

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d", &n, &m);
        queue<PII> oni_que, boy_que, girl_que;
        for (int i = 0; i < n; ++i) {
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            for (int j = 0; j < m; ++j) {
                char c;
                scanf("%c", &c);
                if (c == 'Z') oni_que.push({i ,j});
                else if (c == 'M') boy_que.push({i, j});
                else if (c == 'G') girl_que.push({i, j});
                g[i][j] = c;
            }
        }
        int step = 0;
        while (!oni_que.empty() && !boy_que.empty() && !girl_que.empty()) {
            ++step;
            int sz = oni_que.size();
            while (sz--) {
                auto pr = oni_que.front();
                oni_que.pop();
                int x = pr.first, y = pr.second;
                for (auto& DIR : DIRS8) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] != 'Z') {
                        g[nx][ny] = 'Z';
                        oni_que.push({nx, ny});
                    }
                }
                for (auto& DIR : DIRS4) {
                    int nx = x + DIR[0] * 2, ny = y + DIR[1] * 2;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] != 'Z') {
                        g[nx][ny] = 'Z';
                        oni_que.push({nx, ny});
                    }
                }
            }
            for (int k = 0; k < 3; ++k) {
                sz = boy_que.size();
                while (sz--) {
                    auto pr = boy_que.front();
                    boy_que.pop();
                    int x = pr.first, y = pr.second;
                    if (g[x][y] == 'Z') continue;
                    for (auto& DIR : DIRS4) {
                        int nx = x + DIR[0], ny = y + DIR[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                            g[nx][ny] == 'X' || g[nx][ny] == 'Z' || g[nx][ny] == 'M') continue;
                        if (g[nx][ny] == 'G') {
                            printf("%d\n", step);
                            goto out;
                        }
                        g[nx][ny] = 'M';
                        boy_que.push({nx, ny});
                    }
                }
            }
            sz = girl_que.size();
            while (sz--) {
                auto pr = girl_que.front();
                girl_que.pop();
                int x = pr.first, y = pr.second;
                if (g[x][y] == 'Z') continue;
                for (auto& DIR : DIRS4) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                        g[nx][ny] == 'X' || g[nx][ny] == 'Z' || g[nx][ny] == 'G') continue;
                    if (g[nx][ny] == 'M') {
                        printf("%d\n", step);
                        goto out;
                    }
                    g[nx][ny] = 'G';
                    girl_que.push({nx, ny});
                }
            }
        }
        puts("-1");
        out:;
    }
    
    return 0;
}   