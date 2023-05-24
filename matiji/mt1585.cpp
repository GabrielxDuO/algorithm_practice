#include <bits/stdc++.h>

using namespace std;

int main() {
    int x1, y1, x2, y2;
    scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
    int dx = x2 - x1, dy = y2 - y1;
    printf("%.2f", sqrt(dx * dx + dy * dy));

    return 0;
}