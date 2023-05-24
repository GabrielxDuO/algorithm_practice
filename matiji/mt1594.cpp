#include <bits/stdc++.h>

using namespace std;

int main() {
    int cx, cy, x, y;
    double r;
    scanf("%d%d%lf%d%d", &cx, &cy, &r, &x, &y);
    int dx = x - cx, dy = y - cy;
    double dist = sqrt(dx * dx + dy * dy);
    if (dist <= r) printf("0\n");
    else printf("%.2f\n", dist - r);

    return 0;
}