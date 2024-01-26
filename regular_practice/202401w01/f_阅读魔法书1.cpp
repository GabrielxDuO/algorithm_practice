#include <cstdio>
#include <cstring>

using namespace std;

const int N = 5e5 + 10, M = 1e3 + 10;
char s[N];
int n;
char p[N];

int main() {
    scanf("%s%d", s, &n);
    int ans = 0;
    while (n--) {
        scanf("%s", p);
        char* pt = s;
        while (pt = strstr(pt, p)) ++ans, ++pt;
    }
    printf("%d\n", ans);

    return 0;
}