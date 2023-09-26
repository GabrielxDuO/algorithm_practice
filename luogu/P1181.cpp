#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n, m;
int a[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    int sum = 0, cnt = 0;
    for (int i = 0; i < n; ++i) {
        if (sum + a[i] > m) ++cnt, sum = a[i];
        else sum += a[i];
    }
    if (sum > 0) ++cnt;
    printf("%d\n", cnt);

    return 0;
}