#include <cstdio>
#include <set>

using namespace std;

const int N = 1e5 + 10;
int n;
set<int> st;

int main() {
    scanf("%d", &n);
    for (int i = n; i > 0; --i) {
        int x; scanf("%d", &x);
        auto it = st.upper_bound(x);
        if (it != st.end()) st.erase(it);
        st.insert(x);
    }
    printf("%d\n", st.size());

    return 0;
}