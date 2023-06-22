#include <cstdio>
#include <map>

using namespace std;

const int N = 1e3 + 10;
int n, m;
char g[N][N];
map<char, map<int, int>> mp;
int cnt;

bool check(int x, int y, int k) {
    char c = g[x][y];
    if (x + k - 1 >= n || y + k - 1 >= m) return false;
    for (int i = x; i < x + k; ++i) {
        if (g[i][y + k - 1] != c) return false; 
    }
    for (int j = y; j < y + k; ++j) {
        if (g[x + k - 1][j] != c) return false; 
    }
    return true;
}

void mark(int x, int y, int k) {
    for (int i = x; i < x + k; ++i) {
        for (int j = y; j < y + k; ++j) {
            g[i][j] = '#';
        }
    }
}

int main() {
    scanf("%d%d\n", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%s", g[i]);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (g[i][j] == '#') continue;
            int k = 1;
            while (check(i, j, k + 1)) ++k;
            char& c = g[i][j];
            ++mp[c][k];
            mark(i, j, k);
        }
    }
    for (auto pr : mp) cnt += pr.second.size();
    printf("%d\n", cnt);
    for (auto pr1 : mp) {
        for (auto pr2 : pr1.second) {
            printf("color = %c; size = %d; amount = %d\n", pr1.first, pr2.first, pr2.second);
        }
    }

    return 0;
}