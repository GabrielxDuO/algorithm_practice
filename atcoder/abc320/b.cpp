#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;
char s[N];
int n;
int mx = 1;

void extend(int l, int r) {
    while (s[l] == s[r] && l >= 0 && r < n) {
        --l, ++r;
    }
    mx = max(mx, r - l - 1);
}

int main() {
    scanf("%s", s);
    n = strlen(s);
    for (int i = 0; i < n; ++i) {
        extend(i, i);
        extend(i, i + 1);
    }
    printf("%d\n", mx);

    return 0;
}