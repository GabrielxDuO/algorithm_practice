#include <iostream>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, m;
int a[N], b[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    for (int i = 0; i < m; ++i) scanf("%d", &b[i]);
    sort(b, b + m);
    for (int i = 0; i < n; ++i) {
        int& x = a[i];
        int l = 0, r = m - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (b[m] >= x) r = m;
            else l = m + 1;
        }
        if (b[l] == x) printf("%d ", x);
    }

    return 0;
}