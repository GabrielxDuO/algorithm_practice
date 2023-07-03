#include <cstdio>
#include <cstring>
#include <set>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10, M = 1e4 + 10;
int n, m, k;
int boxes[N];
int cnts[M];
set<int> st;

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &boxes[i]);
    scanf("%d", &k);
    while (k--) {
        memset(cnts, 0, sizeof(cnts));
        st.clear();
        int x;
        while (~scanf("%d", &x) && x) {
            st.insert(boxes[x]);
            ++cnts[boxes[x]];
        }
        int cnt = 0;
        for (auto& y : st) {
            printf("B%d-%d", y, cnts[y]);
            printf(++cnt == st.size() ? "\n" : " ");
        }
    }

    return 0;
}