#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 110;
int n;
int a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    for (int i = 0, j = a[0]; i < n; ++i, ++j) {
        if (a[i] != j) {
            printf("%d\n", j);
            return 0;
        }
    }

    return 0;
}