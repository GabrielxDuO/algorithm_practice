#include <cstdio>

using namespace std;

const int N = 310;
int t, n;
int a[N];

void solve() {
    scanf("%d", &n);
    for (int i = 0, j = n - 1 - (n & 1); i < n; ++i) {
        if (i < n / 2 + (n & 1)) scanf("%d", &a[i * 2]);
        else scanf("%d", &a[j]), j -= 2;
    }
    for (int i = 0; i < n; ++i) printf("%d ", a[i]);
    putchar('\n');
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}