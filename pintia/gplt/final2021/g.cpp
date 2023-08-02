#include <cstdio>

using namespace std;

const int N = 1e6 + 10;
int n, x;
int cnts[N];

int main() {
    scanf("%d", &n);
    int mx = -1, mn = N;
    while (n--) {
        scanf("%d", &x);
        ++cnts[x];
        if (x < mn) mn = x;
        if (x > mx) mx = x;
    }
    printf("%d %d\n%d %d\n", mn, cnts[mn], mx, cnts[mx]);

    return 0;
}