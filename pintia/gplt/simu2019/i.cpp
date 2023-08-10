#include <cstdio>
#include <cmath>

using namespace std;

const int N = 1e5 + 10, M = 1e4 + 10;

int head, dummy1 = N - 1, dummy2 = N - 2, n;
int e[N], ne1[N], ne2[N];
bool vis[M];

int main() {
    scanf("%d%d", &head, &n);
    ne1[dummy1] = head;
    while (n--) {
        int a, b, c;
        scanf("%d%d%d", &a, &c, &b);
        e[a] = c;
        ne1[a] = b;
    }
    int prev1 = dummy1, prev2 = dummy2;
    for (int i = ne1[dummy1]; ~i; i = ne1[i]) {
        int val = abs(e[i]);
        if (vis[val]) {
            ne2[prev2] = i;
            prev2 = i;
            ne1[prev1] = ne1[i];
        } else {
            vis[val] = true;
            prev1 = i;
        }
    }
    ne2[prev2] = -1;
    for (int i = ne1[dummy1]; ~i; i = ne1[i]) {
        printf("%05d %d ", i, e[i]);
        if (~ne1[i]) printf("%05d\n", ne1[i]);
        else puts("-1");
    }
    for (int i = ne2[dummy2]; ~i; i = ne2[i]) {
        printf("%05d %d ", i, e[i]);
        if (~ne2[i]) printf("%05d\n", ne2[i]);
        else puts("-1");
    }

    return 0;
}