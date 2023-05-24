#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    int max_area = 0, max_cnt = 0;
    for (int i = 1; i <= n; ++i) {
        int l, w, h;
        scanf("%d%d%d", &l, &w, &h);
        int surf_area = l * w * 2 + w * h * 2 + l * h * 2;
        if (surf_area > max_area) {
            max_area = surf_area;
            max_cnt = i;
        }
    }
    printf("%d", max_cnt);

    return 0;
}