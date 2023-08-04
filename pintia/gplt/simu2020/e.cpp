#include <cstdio>

using namespace std;

const int N = 110;
int n, m;
int s[N];
bool ans[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) scanf("%d", &s[i]);
    for (int i = 0; i < m; ++i) scanf("%d", &ans[i]);
    while (n--) {
        int sel, tot = 0;
        for (int i = 0; i < m; ++i) {
            scanf("%d", &sel);
            if (!(sel ^ ans[i])) tot += s[i];
        }
        printf("%d\n", tot);
    } 

    return 0;
}