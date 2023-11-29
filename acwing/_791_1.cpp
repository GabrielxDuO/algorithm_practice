#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int _ = [] {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

vector<int> add(const vector<int>& a, const vector<int>& b) {
    const int n = a.size(), m = b.size(), len = max(n, m) + 1;
    vector<int> c(len);
    for (int i = 0, rem = 0; i < len || rem; ++i) {
        if (i < n) rem += a[i];
        if (i < m) rem += b[i];
        c[i] = rem % 10;
        rem /= 10;
    }
    if (c.back() == 0) c.pop_back();
    return c;
}

int main() {
    string s1, s2;
    cin >> s1 >> s2;
    int n = s1.size(), m = s2.size();
    vector<int> a(n), b(m);
    for (int i = 0; i < n; ++i) a[i] = s1[n - i - 1] - '0';
    for (int i = 0; i < m; ++i) b[i] = s2[m - i - 1] - '0';
    auto c = add(a, b);
    for (int i = c.size() - 1; i >= 0; --i) cout << c[i];

    return 0;
}