#include <cstdio>

using namespace std;

const int N = 210;
int t, n;
char s[N];

void solve() {
    scanf("%d%s", &n, s);
    if (s[0] == '2' && s[1] == '0' && s[2] == '2' && s[3] == '0') {
        puts("Yes");
        return;
    }
    if (s[n - 4] == '2' && s[n - 3] == '0' && s[n - 2] == '2' && s[n - 1] == '0') {
        puts("Yes");
        return;
    }
    if (s[0] == '2' && s[n - 3] == '0' && s[n - 2] == '2' && s[n - 1] == '0') {
        puts("Yes");
        return;
    }
    if (s[0] == '2' && s[1] == '0' && s[n - 2] == '2' && s[n - 1] == '0') {
        puts("Yes");
        return;
    }
    if (s[0] == '2' && s[1] == '0' && s[2] == '2' && s[n - 1] == '0') {
        puts("Yes");
        return;
    }
    puts("No");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}