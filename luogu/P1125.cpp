#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 110;
char s[N];
int cnts[128];

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    scanf("%s", s);
    for (int i = 0; s[i]; ++i) ++cnts[s[i]];
    int mx = 0, mn = 101;
    for (int c = 'a'; c <= 'z'; ++c) {
        if (!cnts[c]) continue;
        mx = max(mx, cnts[c]);
        mn = min(mn, cnts[c]);
    }
    if (is_prime(mx - mn)) printf("Lucky Word\n%d\n", mx - mn);
    else puts("No Answer\n0");

    return 0;
}