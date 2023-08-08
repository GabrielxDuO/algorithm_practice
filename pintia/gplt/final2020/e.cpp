#include <cstdio>
#include <algorithm>

using namespace std;

int a[4], mn, rng;

int main() {
    scanf("%d%d%d%d%d%d", &a[0], &a[1], &a[2], &a[3], &mn, &rng);
    int mx = max(max(a[0], a[1]), max(a[2], a[3])), cnt = 0, wn = -1;
    for (int i = 0; i < 4; ++i) {
        if (mx - a[i] > rng || a[i] < mn) {
            ++cnt;
            wn = i;
        }
    }
    if (!cnt) puts("Normal");
    else if (cnt == 1) printf("Warning: please check #%d!", wn + 1);
    else puts("Warning: please check all the tires!");

    return 0;
}