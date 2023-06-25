#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n;
int head, tail;
int ne[N], pr[N];
int mp[N];

int main() {
    scanf("%d%d", &head, &n);
    int curr;
    pr[head] = -1;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &curr);
        scanf("%d%d", &mp[curr], &ne[curr]);
        if (~ne[curr]) pr[ne[curr]] = curr;
        else tail = curr;
    }
    curr = tail;
    ne[100001] = head;
    head = 100001;
    for (int i = 0; ; ++i) {
        if (i) printf("%05d\n", curr);
        printf("%05d %d ", curr, mp[curr]);
        if (i & 1) {
            curr = tail = pr[tail];
        } else {
            curr = head = ne[head];
        }
        if (head == tail) break;
    }
    puts("-1");

    return 0;
}