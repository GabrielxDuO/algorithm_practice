#include <cstdio>

using namespace std;

int t, n;

void solve() {
    int sum = 0;
    bool has_odd = false, has_even = false;
    scanf("%d", &n);
    while (n--) {
        int x; scanf("%d", &x);
        sum += x;
        if (x & 1) has_odd = true;
        else has_even = true;
    }
    puts((sum & 1) || has_odd && has_even ? "YES" : "NO");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}