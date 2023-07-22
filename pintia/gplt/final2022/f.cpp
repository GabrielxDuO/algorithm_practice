#include <cstdio>
#include <iostream>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

string a, b;

string solve(string a) {
    string s;
    for (int i = 1; i < a.size(); ++i) {
        if ((a[i] - '0') % 2 == (a[i - 1] - '0') % 2) {
            s += max(a[i] - '0', a[i - 1] - '0') + '0';
        }
    }
    return s;
}

int main() {
    cin >> a >> b;
    a = solve(a);    
    b = solve(b);
    cout << a << '\n';
    if (a != b) cout << b;

    return 0;
}