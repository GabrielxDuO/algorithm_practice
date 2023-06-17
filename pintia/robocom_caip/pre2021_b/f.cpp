#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <cstring>

using namespace std;

const int N = 100;
int n, m;
char s[10];
char g[N][N];

int main() {
    scanf("%d%d\n", &n, &m);
    memset(g, '.', sizeof(g));
    while (m--) {
        cin.getline(s, 10);
        int len = strlen(s);
        int x, y, i;
        for (i = 0; i < len; ++i) {
            if (s[i] == ';') {
                sscanf(s, "%d;%d", &x, &y);
                break; 
            } else if (s[i] == '/') {
                sscanf(s, "%d/%d", &x, &y);
                break;
            }
        }
        if (i == len) {
            int t = atoi(s);
            x = t / 100, y = t % 100;
        }
        g[x][y] = '#';
    }
    for (int j = n; j >= 1; --j) {
        for (int i = 1; i <= n; ++i) {
            printf("%c", g[i][j]);
        }
        puts("");
    }

    return 0;
}