#include <iostream>
#include <limits>
#include <queue>

using namespace std;

typedef pair<int, int> PII;
typedef pair<PII, int> PIII;

const int N = 110, DIRS[][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
int X, Y, x, y;
bool g[N][N];

int main() {
    scanf("%d%d%d%d", &X, &Y, &x, &y);
    for (int i = Y; i >= 1; --i) {
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        for (int j = 1; j <= X; ++j) {
            char c;
            scanf("%c", &c);
            g[j][i] = c == '*';
        }
    }
    queue<PIII> que;
    que.push({{x, y}, 0});
    g[x][y] = true;
    int mx = 0;
    while (!que.empty()) {
        auto pr = que.front();
        que.pop();
        x = pr.first.first, y = pr.first.second;
        int step = pr.second;
        mx = max(mx, step);
        for (auto& DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx > 0 && nx <= X && ny > 0 && ny <= Y && !g[nx][ny]) {
                que.push({{nx, ny}, step + 1});
                g[nx][ny] = true;
            }
        }
    }
    printf("%d\n", mx);
    
    return 0;
}