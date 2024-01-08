#include <cstdio>

using namespace std;

const int N = 1e6 + 10;
char s[N];

int main() {
    scanf("%s", s);
    int ans = 0;
    for (int i = 1; s[i]; ++i) {
        if (s[i] == '?' || s[i - 1] == '?' || s[i] == s[i - 1]) ++ans, ++i;
    }
    printf("%d\n", ans);

    return 0;
}