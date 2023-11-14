#include <cstdio>

using namespace std;

int n, m, p;

int main() {
    scanf("%d%d%d", &n, &m, &p);
    int ans = 0;
    for (int x = m; x <= n; x += p, ++ans);
    printf("%d\n", ans);

    return 0;
}