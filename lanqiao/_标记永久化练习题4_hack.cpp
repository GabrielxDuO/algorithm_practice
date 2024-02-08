#include <cstdio>

using namespace std;

int main() {
    freopen("in", "w", stdout);
    int n = 1e5;
    printf("%d\n", n);
    puts("1 2 -100");
    for (int i = 2; i <= n; ++i) printf("%d %d %d\n", i, 1, -100);

    return 0;
}