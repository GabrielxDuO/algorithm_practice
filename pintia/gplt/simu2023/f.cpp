#include <cstdio>
#include <iostream>
#include <limits>

using namespace std;

int n;
string s;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main() {
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    while (n--) {
        getline(cin, s);
        if (s.back() == '?') {
            for (int i = 0; i + 2 < s.size(); ++i) {
                if (s[i] == 'P' && s[i + 1] == 'T' && s[i + 2] == 'A') {
                    puts("Yes!");
                    goto out;
                }
            }
            puts("No.");
            out:;
        } else puts("enen");
    }

    return 0;
}