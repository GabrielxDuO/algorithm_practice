#include <cstdio>
#include <iostream>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

string s;

int main() {
    cin >> s;
    if (s.size() == 6) cout << s.substr(0, 4) << '-' << s.substr(4) << '\n';
    else cout << (stoi(s.substr(0, 2)) < 22 ? "20" : "19") << s.substr(0, 2) << '-' << s.substr(2) << '\n';

    return 0;
}