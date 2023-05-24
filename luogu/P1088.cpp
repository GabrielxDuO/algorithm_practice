#include <iostream>

using namespace std;

const int N = 1e4 + 10;
int n, m;
int a[N];

void next_perm(int t) {
    while (t--) {
        int i = n - 2, j = n - 1;
        while (i >= 0 && a[i] >= a[i + 1]) --i;
        while (j > i && a[j] <= a[i]) --j;
        swap(a[i], a[j]);
        ++i, j = n - 1;
        while (i < j) swap(a[i++], a[j--]);
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    next_perm(m);
    for (int i = 0; i < n; ++i) printf("%d ", a[i]);

    return 0;
}