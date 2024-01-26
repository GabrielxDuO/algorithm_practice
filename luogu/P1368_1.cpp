#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 3e5 + 10;
int n;
int a[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    int i = 1, j = 2, k = 0;
    while (i <= n && j <= n) {
        for (k = 0; k <= n && a[(i + k) % n] == a[(j + k) % n]; ++k);
        (a[i + k] > a[j + k] ? i : j) += k + 1;
        if (i == j) ++j;
    }
    int st = min(i, j);
    for (i = st; i <= n; ++i) printf("%d ", a[i]);
    for (i = 1; i < st; ++i) printf("%d ", a[i]);

    return 0;
}