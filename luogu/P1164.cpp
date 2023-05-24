#include <iostream>

using namespace std;

const int N = 10010;
int n, m;
int f[N];

int main() {
    scanf("%d%d", &n, &m);
    f[0] = 1;
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        for (int j = m; j >= x; --j) {
            f[j] += f[j - x];
        }
    }
    printf("%d\n", f[m]);

    return 0;
}