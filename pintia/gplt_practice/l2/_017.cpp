#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, a[N];

int main() {
    scanf("%d", &n);
    int hf = n / 2;
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    int diff = 0;
    for (int i = 0; i < n; ++i) {
        if (i < hf) diff -= a[i];
        else diff += a[i];
    }
    printf("Outgoing #: %d\nIntroverted #: %d\nDiff = %d\n", n - hf, hf, diff);

    return 0;
}