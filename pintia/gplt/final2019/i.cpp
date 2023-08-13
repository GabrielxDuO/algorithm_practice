#include <cstdio>
#include <unordered_set>

using namespace std;

const int N = 1e4 + 10;
int l, r;
unordered_set<int> vis, non;
int cnts[N];
bool ord[N];

void check(int n) {
    if (non.find(n) != non.end() || ord[n]) return;
    vis.clear();
    int x = n;
    if (x == 1) cnts[x] = 1;
    while (x != 1) {
        vis.insert(x);
        int y = 0;
        while (x) {
            y += (x % 10) * (x % 10);
            x /= 10;
        }
        if (non.find(y) != non.end() || vis.find(y) != vis.end()) {
            for (auto z : vis) non.insert(z);
            break;
        }
        if (y >= l && y <= r) {
            ord[y] = true;
        }
        ++cnts[n];
        x = y;
    }
}

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    scanf("%d%d", &l, &r);
    for (int x = l; x <= r; ++x) check(x);
    bool has = false;
    for (int x = l; x <= r; ++x) {
        if (non.find(x) == non.end() && !ord[x]) {
            printf("%d %d\n", x, cnts[x] * (1 + is_prime(x)));
            has = true;
        }
    }
    if (!has) puts("SAD");

    return 0;
}