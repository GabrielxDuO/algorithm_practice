#include <cstdio>
#include <unordered_set>

using namespace std;

const int N = 1e4 + 10;
int n, k;
int roots[N];
unordered_set<int> st;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}


int main() {
    scanf("%d", &n);
    for (int i = 1; i < N; ++i) roots[i] = i;
    while (n--) {
        int x, y;
        scanf("%d%d", &k, &x);
        st.insert(x);
        while (--k) {
            scanf("%d", &y);
            join(x, y);
            st.insert(y);
        }
    }
    int group = 0;
    for (auto x : st) {
        if (roots[x] == x) ++group;
    }
    printf("%d %d\n", st.size(), group);
    scanf("%d", &k);
    while (k--) {
        int a, b;
        scanf("%d%d", &a, &b);
        puts(find(a) == find(b) ? "Y" : "N");
    }

    return 0;
}