#include <cstdio>
#include <iostream>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

string s, bef, aft;
int n, l, r;

int main() {
    cin >> s >> n;
    while (n--) {
        cin >> l >> r >> bef >> aft;
        --l, --r;
        string cb = s.substr(l, r - l + 1);
        s = s.substr(0, l) + s.substr(r + 1);
        auto pos = s.find(bef + aft);
        int split = pos == s.npos ? s.size() : pos + bef.size();
        s = s.substr(0, split) + cb + s.substr(split);
    }
    cout << s << '\n';

    return 0;
}