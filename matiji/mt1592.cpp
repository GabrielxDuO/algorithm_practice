#include <bits/stdc++.h>

using namespace std;

int main() {
    int ltx, lty, rbx, rby, x, y;
    scanf("%d%d%d%d%d%d", &ltx, &lty, &rbx, &rby, &x, &y);
    printf(x > ltx && x < rbx && y > rby && y < lty ? "YES" : "NO");

    return 0;
}