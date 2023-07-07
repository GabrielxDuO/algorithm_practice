#include <cstdio>

using namespace std;

int n;
bool vis[10][10];
int a[10];

int main() {
    for (int i = 0; i < 6; ++i) {
        scanf("%d", &a[i]);
        vis[i][a[i]] = true;
    }
    scanf("%d", &n);
    while (n--) {
        for (int i = 0; i < 6; ++i) {
            int x = 6;
            while (vis[i][x]) --x;
            a[i] = x;
            vis[i][x] = true;
        }
    }
    printf("%d", a[0]);
    for (int i = 1; i < 6; ++i) {
        printf(" %d", a[i]);
    }

    return 0;
}