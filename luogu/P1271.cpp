#include <iostream>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int N = 2e6 + 10;
int a[N];
int m;

int main() {
    scanf("%*d%d", &m);
    for (int i = 0; i < m; ++i) scanf("%d", &a[i]);
    sort(a, a + m);
    for (int i = 0; i < m; ++i) printf("%d ", a[i]);

    return 0;
}