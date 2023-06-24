#include <cstdio>
#include <iostream>
#include <limits>
#include <cstring>

using namespace std;

const int N = 110, M = 15;
int n, m, k;
string mp[N];
int rows[M];
int g[N][M];

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main() {
    cin >> n >> m;
    string s;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    for (int i = 1; i <= n; ++i) {
        getline(cin, s);
        mp[i] = s;
    }
    for (int i = 0; i < m; ++i) {
        int r; cin >> r;
        rows[i] = r;
    }
    memset(g, -1, sizeof(g));
    for (int i = 0; i < m; ++i) {
        int& r = rows[i];
        for (int j = 0; j < 10; ++j) cin >> g[r][j];
    }
    cin >> k;
    while (k--) {
        int x; cin >> x;
        int y = x % 10;
        x /= 10;
        cout << (~g[x][y] ? mp[g[x][y]] : "?") << '\n';
    }


    return 0;
}