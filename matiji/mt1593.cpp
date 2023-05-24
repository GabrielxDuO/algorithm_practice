#include <bits/stdc++.h>

using namespace std;

int main() {
    int x1, y1, x2, y2, x3, y3;
    scanf("%d%d%d%d%d%d", &x1, &y1, &x2, &y2, &x3, &y3);
    int doub_area = abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    int dx = x2 - x1, dy = y2 - y1;
    double a = sqrt(dx * dx + dy * dy);
    printf("%.2f", doub_area / a);

    return 0;
}