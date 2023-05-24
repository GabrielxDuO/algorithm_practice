#include <iostream>
#include <cstring>

using namespace std;

const int N = 3000;
int n;
char g[N][N];

int main() {
    scanf("%d", &n);
    memset(g, ' ', sizeof(g));
    g[0][0] = g[1][1] = '/', g[0][1] = g[0][2] = '_', g[0][3] = g[1][2] = '\\';
    int len = 4;
    while (--n) {
        for (int i = 0; i < len / 2; ++i) {
            for (int j = 0; j < len; ++j) {
                g[i][j + len] = g[i][j];
                g[i + len / 2][j + len / 2] = g[i][j];
            }
        }
        len *= 2;
    }
    for (int i = len / 2 - 1; i >= 0; --i) {
        for (int j = 0; j < len; ++j) {
            printf("%c", g[i][j]);
        }
        puts("");
    }

    return 0;
}