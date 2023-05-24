#include <iostream>

using namespace std;

int main() {
    int n, m;
    scanf("%d%d", &n, &m);
    int nums[n];
    for (int i = 0; i < n; ++i) scanf("%d", &nums[i]);
    while (m--) {
        int q;
        scanf("%d", &q);
        int l = 0, r = n - 1;
        while (l < r) {
            int c = l + (r - l >> 1);
            if (nums[c] >= q) r = c;
            else l = c + 1;
        }
        printf("%d ", nums[l] == q ? l + 1 : -1);
    }
}