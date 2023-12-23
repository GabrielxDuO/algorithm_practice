#include <cstdio>

using namespace std;

int main() {
    int n, p1, p2;
    scanf("%d%d%d", &n, &p2, &p1);
    int ans = 0;
    for (int i = 0; i < n - 2; ++i) {
        int x; scanf("%d", &x);
        if (p1 >= p2 + x) ++ans;
        p2 = p1;
        p1 = x;
    }
    printf("%d\n", ans);

    return 0;
}