#include <cstdio>

using namespace std;

const int N = 110;
int n, m;
char s[N], t[N];

int main() {
    scanf("%d%d%s%s", &n, &m, s, t);
    int ans = 0;
    bool pf = true, sf = true;
    for (int i = 0; i < n; ++i) {
        if (s[i] != t[i]) {
            pf = false;
            break;
        }
    }
    for (int i = 0; i < n; ++i) {
        if (s[i] != t[m - n + i]) {
            sf = false;
            break;
        }
    }
    if (pf) ans |= 0b10;
    if (sf) ans |= 0b01;
    ans ^= 0b11;
    printf("%d\n", ans);

    return 0;
}