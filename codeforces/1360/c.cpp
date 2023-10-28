#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 105;
int t, n;
bool has[N];

void solve() {
    memset(has, false, sizeof(has));
    scanf("%d", &n);
    int odd = 0;
    bool op2 = false;
    while (n--) {
        int x; scanf("%d", &x);
        has[x] = true;
        if (x & 1) ++odd;
        if (has[x - 1] || has[x + 1]) op2 = true;
    }
    puts((odd & 1) == 0 || op2 ? "YES" : "NO");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}