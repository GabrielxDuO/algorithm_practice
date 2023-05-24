#include <bits/stdc++.h>

using namespace std;

int main() {
    int ltx, lty, rbx, rby, x, y;
    scanf("%d%d%d%d%d%d", &ltx, &lty, &rbx, &rby, &x, &y);
    printf((x >= ltx && x <= rbx && (y == lty || y == rby)) ||
           (y >= rby && y <= lty && (x == ltx || x == rbx)) ? "YES" : "NO");

    return 0;
}