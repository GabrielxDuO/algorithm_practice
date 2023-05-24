#include <iostream>

using namespace std;

int main() {
    // freopen("in", "r", stdin);
    // freopen("out", "w", stdout);
    string s;
    char c;
    while (~scanf("%c", &c) && c != 'E') {
        if (c == '\n') continue;
        s += c;
    }
    int n = s.size();
    if (n == 0) {
        cout << "0:0" << endl << endl << "0:0" << endl;
        return 0;
    }
    for (int i = 0, j; i < n; i = j + 1) {
        int w = 0, l = 0;
        for (j = i; j < n; ++j + 1) {
            if (s[j] == 'W') ++w;
            else ++l;
            if ((w >= 11 || l >= 11) && abs(w - l) > 1) break;
        }
        cout << w << ":" << l << endl;
    }
    puts("");
    for (int i = 0, j; i < n; i = j + 1) {
        int w = 0, l = 0;
        for (j = i; j < n; ++j) {
            if (s[j] == 'W') ++w;
            else ++l;
            if ((w >= 21 || l >= 21) && abs(w - l) > 1) break;
        }
        cout << w << ":" << l << endl;
    }

    return 0;
}