#include <cstdio>

using namespace std;

const int N = 25;
int n, k;
int a[N];
int sum, cnt;

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false; 
    }
    return true;
}

void dfs(int u, int st) {
    if (n - st < k - u) return;
    if (u == k) {
        if (is_prime(sum)) ++cnt;
        return;
    }
    for (int i = st; i < n; ++i) {
        sum += a[i];
        dfs(u + 1, i + 1);
        sum -= a[i];
    }
}

int main() {
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    dfs(0, 0);
    printf("%d\n", cnt);

    return 0;
}