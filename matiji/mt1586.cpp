#include <bits/stdc++.h>

using namespace std;

int main() {
    int x1, y1, x2, y2;
    scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
    int dx = abs(x1 - x2), dy = abs(y2 - y1);
    printf("%d", dx * dy);

    return 0;
}