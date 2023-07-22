#include <cstdio>

using namespace std;

const int N = 300;
int cnts[N];
int n, k, s;
int cnt;

int main() {
    scanf("%d%d%d", &n, &k, &s);
    while (n--) {
        int x, y;
        scanf("%d%d", &x, &y);
        if (x < 175) continue;
        if (y >= s) ++cnt;
        else if (++cnts[x] <= k) ++cnt;
    }
    printf("%d\n", cnt);

    return 0;
}