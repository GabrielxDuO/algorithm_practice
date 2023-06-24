#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n, s, k;
int boxes[N];
int mp[N];

int main() {
    scanf("%d%d", &n, &s);
    for (int i = 0; i < n; ++i) scanf("%d", &boxes[i]);
    int st = 0, row = n / s;
    for (int i = 0; i < row; ++i) {
        int idx = st + s - 1;
        for (int j = 0; j < s; ++j, --idx) scanf("%d", &mp[boxes[idx]]);
        st += s;
    }
    scanf("%d", &k);
    while (k--) {
        int x; scanf("%d", &x);
        if (!mp[x]) puts("Wrong Number");
        else printf("%d\n", mp[x]);
    }

    return 0;
}