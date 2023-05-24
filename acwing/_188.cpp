#include <iostream>
#include <limits>
#include <queue>

using namespace std;

typedef pair<int, int> PII;
typedef pair<PII, int> PIII;

const int N = 160, DIRS[][2] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
int c, r, tx, ty;
bool g[N][N];

int main() {
    scanf("%d%d", &c, &r);
    queue<PIII> que;
    for (int i = 0; i < r; ++i) {
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        for (int j = 0; j < c; ++j) {
            char c;
            scanf("%c", &c);
            if (c == 'K') que.push({{i, j}, 0}), g[i][j] = true;
            else if (c == 'H') tx = i, ty = j;
            else if (c == '*') g[i][j] = true;
        }
    }
    while (!que.empty()) {
        auto pr = que.front();
        que.pop();
        int x = pr.first.first, y = pr.first.second, step = pr.second;
        if (x == tx && y == ty) {
            printf("%d\n", step);
            return 0;
        }
        for (auto& DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !g[nx][ny]){
                que.push({{nx, ny}, step + 1});
                g[nx][ny] = true;
            }
        }
    }
    
    return 0;
}