#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long LL;

int n;
vector<int> m1, m2, f1, f2;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        if (x & 1) m1.push_back(x);
        else m2.push_back(x);
    }
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        if (x & 1) f1.push_back(x);
        else f2.push_back(x);
    }
    sort(m1.begin(), m1.end());
    sort(m2.begin(), m2.end());
    sort(f1.begin(), f1.end());
    sort(f2.begin(), f2.end());
    int st1 = 0, st2 = 0;
    LL sum = 0LL;
    for (; st1 < m1.size(); ++st1) {
        if (st1 < f1.size()) sum += m1[st1] + f1[st1] >> 1;
        else sum += m1[st1] + f2[st2++] >> 1;
    }
    for (int i = 0; i < m2.size(); ++i) {
        if (st2 < f2.size()) sum += m2[i] + f2[st2++] >> 1;
        else sum += m2[i] + f1[st1++] >> 1;
    }
    printf("%lld\n", sum);

    return 0;
}