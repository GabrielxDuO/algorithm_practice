#include <cstdio>
#include <cstring>

using namespace std;

const int N = 1e5 + 10;
int n;
char s1[N], s2[N];

int main() {
    scanf("%d", &n);
    for (int k = 1; k <= n; ++k) {
        scanf("%s%s", s1, s2);
        int l1 = strlen(s1), l2 = strlen(s2);
        int i = 0, j = 0;
        for (; i < l1 && j < l2; ++j) {
            if (s1[i] == s2[j]) ++i;
        }
        printf("Case #%d: ", k);
        if (i == l1) printf("%d\n", l2 - l1);
        else puts("IMPOSSIBLE");
    }

    return 0;
}