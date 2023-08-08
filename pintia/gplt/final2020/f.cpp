#include <cstdio>
#include <iostream>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

string s;
int tot, cnt, fst;

int main() {
    while (getline(cin, s) && s != ".") {
        ++tot;
        if (s.find("chi1 huo3 guo1") != s.npos) {
            ++cnt;
            if (!fst) fst = tot;
        }
    }
    cout << tot << '\n';
    if (!fst) cout << "-_-#";
    else cout << fst << ' ' << cnt;

    return 0;
}