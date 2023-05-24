#include <iostream>
#include <limits>
#include <queue>

using namespace std;

const int MAX_N = 41;
const int DIRECTIONS[][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int r, c;
char g[MAX_N][MAX_N];
bool vis[MAX_N][MAX_N];

struct State {
    int x, y, step;
};

int bfs() {
    queue<State> que;
    que.push({0, 0, 1});
    vis[0][0] = true;
    while (!que.empty()) {
        State state = que.front();
        que.pop();
        if (state.x == r - 1 && state.y == c - 1) return state.step;
        for (auto d : DIRECTIONS) {
            int nx = state.x + d[0], ny = state.y + d[1];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c ||
                g[nx][ny] == '#' || vis[nx][ny]) continue;
            que.push({nx, ny, state.step + 1});
            vis[nx][ny] = true;
        }
    }

    return -1;
}

int main() {
    scanf("%d%d", &r, &c);
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    for (int i = 0; i < r; ++i) gets(g[i]);
    printf("%d", bfs());

    return 0;
}