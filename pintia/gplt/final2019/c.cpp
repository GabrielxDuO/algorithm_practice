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

int main() {
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    string s;
    while (n--) {
        getline(cin, s);
        int n = s.find('.') + 1, hf = s.find(',');
        if (s.substr(n - 4, 3) != "ong" || hf < 3 || s.substr(hf - 3, 3) != "ong") {
            cout << "Skipped\n";;
            continue;
        }
        int i = n, cnt = 3;
        while (cnt) {
            --i;
            if (s[i] == ' ') --cnt;
        }
        cout << s.substr(0, i) << " qiao ben zhong." << '\n';
    }

    return 0;
}