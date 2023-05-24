#include <iostream>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int N = 1e6 + 10;
int n;
PII segs[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d%d", &segs[i].first, &segs[i].second);
    sort(segs, segs + n, [](const auto& a, const auto& b) { return a.second < b.second; });
    int ed = -1, cnt = 0;
    for (int i = 0; i < n; ++i) {
        if (segs[i].first >= ed) {
            ++cnt;
            ed = segs[i].second;
        }
    }
    printf("%d\n", cnt);

    return 0;
}