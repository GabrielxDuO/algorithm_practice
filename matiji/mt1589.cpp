#include <bits/stdc++.h>

using namespace std;

int main() {
    int cx, cy, r, x, y;
    scanf("%d%d%d%d%d", &cx, &cy, &r, &x, &y);
    int dx = x - cx, dy = y - cy;
    int squ_dist = dx * dx + dy * dy;
    printf(r * r == squ_dist ? "YES" : "NO");

    return 0;
}