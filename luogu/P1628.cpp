#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int n;
vector<string> vec;

int main() {
    cin >> n;
    while (n--) {
        string s; cin >> s;
        vec.push_back(s);
    }
    sort(vec.begin(), vec.end());
    string t; cin >> t;
    int len = t.size();
    for (const auto& s : vec) {
        if (s.size() < len) continue;
        bool flag = true;
        for (int i = 0; i < len; ++i) {
            if (s[i] != t[i]) flag = false;
        }
        if (flag) cout << s << '\n';
    }

    return 0;
}