#include <bits/stdc++.h>

using namespace std;

double p2pDist(int x1, int y1, int x2, int y2) {
    int dx = x2 - x1, dy = y2 - y1;
    return sqrt(dx * dx + dy * dy);
}

double p2lDist(int x1, int y1, int x2, int y2, int x3, int y3) {
    int doub_area = abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    int dx = x2 - x1, dy = y2 - y1;
    double a = sqrt(dx * dx + dy * dy);
    return doub_area / a;
}

int main() {
    int ltx, lty, rbx, rby, x, y;
    scanf("%d%d%d%d%d%d", &ltx, &lty, &rbx, &rby, &x, &y);
    if (x >= ltx && x <= rbx && y >= rby && y <= lty) printf("0");
    else if (y >= rby && y <= lty) printf("%lf", min(
        p2lDist(ltx, lty, ltx, rby, x, y), p2lDist(rbx, lty, rbx, rby, x, y)));
    else if (x >= ltx && x <= rbx) printf("%lf", min(
        p2lDist(ltx, lty, rbx, lty, x, y), p2lDist(ltx, rby, rbx, rby, x, y)));
    else printf("%lf", min(
        min(p2pDist(x, y, ltx, lty), p2pDist(x, y, rbx, lty)),
        min(p2pDist(x, y, rbx, rby), p2pDist(x, y, ltx, rby))
    ));

    return 0;
}