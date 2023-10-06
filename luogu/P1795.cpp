#include <cstdio>
#include <unordered_set>

using namespace std;

int t;
unordered_set<int> st;

int main() {
    scanf("%d", &t);
    int sum = 1;
    for (int i = 0; sum <= 1e9; ++i) {
        sum += i;
        st.insert(sum);
    }
    while (t--) {
        int x; scanf("%d", &x);
        printf("%d\n", st.find(x) != st.end());
    }

    return 0;
}