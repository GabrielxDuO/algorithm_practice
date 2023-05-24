#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010;
int n;
int f[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        f[i] = 1;
        for (int j = 1; j <= i / 2; ++j) f[i] += f[j];
    }
    printf("%d\n", f[n]);

    return 0;
}