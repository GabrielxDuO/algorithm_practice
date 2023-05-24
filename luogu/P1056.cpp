#include <algorithm>
#include <iostream>

using namespace std;

const int N = 110;
int n, a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    int i = 0;
    for (int j = 0; j < n; ++j) {
        if (a[i] != a[j]) a[++i] = a[j];
    }
    printf("%d\n", i + 1);
    for (int k = 0; k <= i; ++k) printf("%d ", a[k]);

    return 0;
}