#include <cstdio>
#include <algorithm>

using namespace std;

int t;

int main() {
    scanf("%d", &t);
    int sum = 0;
    while (t--) {
        int w; scanf("%d", &w);
        int mn = w;
        if (w >= 500) mn = min(mn, w - w / 10);
        if (w >= 1000) mn = min(mn, w - 150);
        if (w == 1111) mn = 0;
        mn = min(mn, w - w / 20);
        sum += mn;
    }
    printf("%d\n", sum);

    return 0;
}