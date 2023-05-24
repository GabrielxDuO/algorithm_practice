#include <iostream>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;
typedef long long LL;

const int N = 1010;
int n;
PII a[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &a[i].first);
        a[i].second = i;
    }
    sort(a + 1, a + n + 1);
    double sum = 0.0;
    for (int i = 1; i <= n; ++i) {
        sum += a[i].first * (n - i);
        printf("%d ", a[i].second);
    }
    printf("\n%.2lf", sum / n);

    return 0;
}