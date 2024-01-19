#include <cstdio>
#include <iostream>

using namespace std;

int _ = [] {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    return 0;
}();

string s, p;
int t;

int main() {
    cin >> s >> t;
    while (t--) {
        cin >> p;
        int cnt = 0;
        size_t pos = -1;
        while ((pos = s.find(p, pos + 1)) != string::npos) ++cnt;
        cout << cnt << '\n';
    }

    return 0;
}