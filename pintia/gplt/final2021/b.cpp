#include <cstdio>

using namespace std;

int n, k, m;

int main() {
    scanf("%d%d%d", &n, &k, &m);
    printf("%d\n", n - k * m);

    return 0;
}