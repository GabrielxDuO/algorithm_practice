#include <cstdio>
#include <queue>

using namespace std;

int n;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
    scanf("%d", &n);
    while (n--) {
        int x; scanf("%d", &x);
        pq.push(x);
    }
    int ans = 0;
    while (pq.size() > 1) {
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();
        ans += a + b;
        pq.push(a + b);
    }
    printf("%d\n", ans);

    return 0;
}