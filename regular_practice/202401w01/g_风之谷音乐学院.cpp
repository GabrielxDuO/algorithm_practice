#include <cstdio>
#include <iostream>
#include <algorithm>
#include <set>

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
    set<string> mxs;
    int mx_cnt = 0;
    while (t--) {
        cin >> p;
        int cnt = 0;
        auto pos = s.find(p);
        while (pos != string::npos) {
            pos = s.find(p, pos + 1);
            ++cnt;
        }
        if (cnt < mx_cnt) continue;
        if (cnt > mx_cnt) mx_cnt = cnt, mxs.clear();
        mxs.insert(p);
    }
    cout << mx_cnt << '\n';
    for (const auto& p : mxs) cout << p << '\n';

    return 0;
}