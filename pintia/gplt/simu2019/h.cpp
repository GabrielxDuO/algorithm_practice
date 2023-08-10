#include <cstdio>
#include <iostream>
#include <limits>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int n;
char c;
string s;

int main() {
    cin >> n >> c;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    getline(cin, s);
    const int& len = s.length();
    if (n > len) {
        for (int i = 0; i < n - len; ++i) cout << c;
        cout << s << '\n';
    } else {
        cout << s.substr(len - n) << '\n';
    }

    return 0;
}