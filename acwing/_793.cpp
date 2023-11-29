#include <iostream>
#include <string>
#include <vector>

using namespace std;

int _ = []{
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

vector<int> mul(const vector<int>& a, const int& b) {
    const int n = a.size();
    int t = b, m = 0;
    while (t) ++m, t /= 10;
    int len = n + m + 1;
    vector<int> c(len);
    for (int i = 0, rem = 0; i < len || rem; ++i) {
        if (i < n) rem += a[i] * b;
        c[i] = rem % 10;
        rem /= 10;
    }
    while (c.size() > 1 && c.back() == 0) c.pop_back();
    return c;
}

int main() {
    string s;
    int b;
    cin >> s >> b;
    int n = s.size();
    vector<int> a(n);
    for (int i = 0; i < n; ++i) a[i] = s[n - i - 1] - '0';
    auto c = mul(a, b);
    for (int i = c.size() - 1; i >= 0; --i) cout << c[i];

    return 0;
}