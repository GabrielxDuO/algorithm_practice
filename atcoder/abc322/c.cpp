#include <cstdio>
#include <cstring>

using namespace std;

const int N = 2e5 + 10;
int n, m;
int a[N];

int main() {
    scanf("%d%d", &n, &m);
    memset(a, -1, sizeof(a));
    while (m--) {
        int x; scanf("%d", &x);
        a[x] = 0;
    }
    for (int i = n; i >= 1; --i) {
        if (a[i] != 0) a[i] = a[i + 1] + 1;
    }
    for (int i = 1; i <= n; ++i) printf("%d\n", a[i]);

    return 0;
}