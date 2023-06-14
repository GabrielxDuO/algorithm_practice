#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e4 + 10;
int n;
struct Info {
    int id, cnt, balance;

    bool operator<(const Info& o) const {
        if (balance != o.balance) return balance > o.balance;
        if (cnt != o.cnt) return cnt > o.cnt;
        return id < o.id;
    }
} infos[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int k; scanf("%d", &k);
        infos[i].id = i;
        while (k--) {
            int id, p;
            scanf("%d%d", &id, &p);
            ++infos[id].cnt;
            infos[id].balance += p;
            infos[i].balance -= p;
        }
    }
    sort(infos + 1, infos + n + 1);
    for (int i = 1; i <= n; ++i) {
        printf("%d %.2lf\n", infos[i].id, infos[i].balance / 100.0);
    }

    return 0;
}