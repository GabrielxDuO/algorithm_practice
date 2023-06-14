#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010;
char s[N];
int n;
int ans = 1;

void extend(int l, int r) {
    while (l >= 0 && r < n && s[l] == s[r]) --l, ++r;
    ans = max(ans, r - l - 1);
}

int main() {
    cin.getline(s, N);
    n = strlen(s);
    for (int i = 0; i < n - 1; ++i) {
        extend(i, i), extend(i, i + 1);
    }
    printf("%d\n", ans);

    return 0;
}