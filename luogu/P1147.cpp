#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e6 + 10;
int m;

LL sum(LL x) {
    return x * (x + 1) / 2;
}

int main() {
    scanf("%d", &m);
    int n = m / 2 + 1;
    for (int x = 0; x <= n; ++x) {
        LL sl = sum(x);
        int l = x, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum(mid) >= sl + m) r = mid;
            else l = mid + 1;
        }
        if (sum(l) - sl == m) printf("%d %d\n", x + 1, l);
    }

    return 0;
}