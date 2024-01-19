#include <cstdio>
#include <iostream>

using namespace std;

int t;
string s, p;

int _ = [] {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    return 0;
}();

int main() {
    cin >> s >> t;
    int ans = 0;
    while (t--) {
        cin >> p;
        auto pos = s.find(p);
        while (pos != string::npos) ++ans, pos = s.find(p, pos + 1);
    }
    cout << ans;

    return 0;
}