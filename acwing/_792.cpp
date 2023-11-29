#include <iostream>
#include <string>
#include <vector>

using namespace std;

int _ = []{
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

bool cmp(const vector<int>& a, const vector<int>& b) {
    if (a.size() != b.size()) return a.size() < b.size();
    for (int i = a.size() - 1; i >= 0; --i) {
        if (a[i] != b[i]) return a[i] < b[i];
    }
    return false;
}

vector<int> sub(const vector<int>& a, const vector<int>& b) {
    vector<int> c(a.size());
    for (int i = 0, rem = 0; i < a.size(); ++i) {
        rem += a[i];
        if (i < b.size()) rem -= b[i];
        c[i] = (rem + 10) % 10;
        rem = -(rem < 0);
    }
    while (c.size() > 1 && c.back() == 0) c.pop_back();
    return c;
}

int main() {
    string s1, s2;
    cin >> s1 >> s2;
    int n = s1.size(), m = s2.size();
    vector<int> a(n), b(m);
    for (int i = 0; i < n; ++i) a[i] = s1[n - i - 1] - '0';
    for (int i = 0; i < m; ++i) b[i] = s2[m - i - 1] - '0';
    auto c = cmp(a, b) ? cout << '-', sub(b, a) : sub(a, b);
    for (int i = c.size() - 1; i >= 0; --i) cout << c[i];

    return 0;
}