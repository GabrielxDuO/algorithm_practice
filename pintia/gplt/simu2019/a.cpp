#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n, m;
int cnts[N];

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d", &m);
        for (int i = 0; i < m; ++i) {
            int x; scanf("%d", &x);
            cnts[x] += m - 1;
        }
    }
    scanf("%d", &m);
    bool is_first = true;
    while (m--) {
        int x; scanf("%d", &x);
        if (!cnts[x]) {
            if (is_first) is_first = false;
            else printf(" ");
            printf("%05d", x);
            cnts[x] = -1;
        }
    }
    if (is_first) puts("No one is handsome");

    return 0;
}