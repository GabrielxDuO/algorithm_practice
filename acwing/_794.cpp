#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int _ = []{
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

vector<int> div(const vector<int>& a, const int& b, int& rem) {
    const int n = a.size();
    vector<int> c(n);
    rem = 0;
    for (int i = n - 1; i >= 0; --i) {
        rem = rem * 10 + a[i];
        c[n - i - 1] = rem / b;
        rem %= b;
    }
    reverse(c.begin(), c.end());
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
    int r;
    auto c = div(a, b, r);
    for (int i = c.size() - 1; i >= 0; --i) cout << c[i];
    cout << '\n' << r;

    return 0;
}