#include <iostream>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int N = 5010;
int n, s, a, b;
PII ap[N];
int len = 0;

int main() {
    scanf("%d%d%d%d", &n, &s, &a, &b);
    while (n--) {
        int x, y;
        scanf("%d%d", &x, &y);
        if (x > a + b) continue;
        ap[len].first = y, ap[len].second = x;
        ++len;
    }
    sort(ap, ap + len);
    int ans = 0;
    for (int i = 0; i < len; ++i) {
        int y = ap[i].first;
        if (y > s) break;
        ++ans;
        s -= y;
    }
    printf("%d\n", ans);

    return 0;
}