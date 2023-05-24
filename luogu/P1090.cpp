#include <iostream>
#include <queue>

using namespace std;

int n;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
    scanf("%d", &n);
    while (n--) {
        int x;
        scanf("%d", &x);
        pq.push(x);
    }
    int ans = 0;
    while (pq.size() > 1) {
        int sum = pq.top(); pq.pop();
        sum += pq.top(); pq.pop();
        ans += sum;
        pq.push(sum);
    }
    printf("%d\n", ans);

    return 0;
}