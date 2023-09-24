#include <cstdio>

using namespace std;

const int N = 110;
int n, avg;
int a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
        avg += a[i];
    }
    avg /= n;
    int ans = 0;
    for (int i = 0; i < n - 1; ++i) {
        if (a[i] != avg) {
            ++ans;
            a[i + 1] -= avg - a[i];
        }
    }
    printf("%d\n", ans);

    return 0;
}