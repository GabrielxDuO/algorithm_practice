#include <cstdio>
#include <iostream>
#include <limits>
#include <algorithm>
#include <string>
#include <string_view>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int n;
string q, a;

int main() {
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    while (n--) {
        getline(cin, q);
        cout << q << "\nAI: ";
        int n = q.size();
        a.clear();
        int i = 0;
        while (q[i] == ' ') ++i;
        for (; i < n; ++i) {
            if (q[i] == ' ') {
                while (i + 1 < n && q[i + 1] == ' ') ++i;
                if (i + 1 < n && isalnum(q[i + 1])) a += ' ';
            } else {
                if (q[i] == 'I') a += 'I';
                else if (q[i] == '?') a += '!';
                else a += tolower(q[i]); 
            }
        }
        n = a.size();
        int pos = 0;
        while ((pos = a.find("can you", pos)) != a.npos) {
            int st = pos++, ed = st + 6;
            if (st > 0 && isalnum(a[st - 1]) || ed < n && isalnum(a[ed + 1])) continue;
            a = a.substr(0, st) + "I can" + a.substr(ed + 1);
        }
        pos = 0;
        while ((pos = a.find("could you", pos)) != a.npos) {
            int st = pos++, ed = st + 8;
            if (st > 0 && isalnum(a[st - 1]) || ed < n && isalnum(a[ed + 1])) continue;
            a = a.substr(0, st) + "I could" + a.substr(ed + 1);
        }
        pos = 0;
        while ((pos = a.find('I', pos)) != a.npos) {
            int st = pos++;
            if (st > 0 && isalnum(a[st - 1]) || st < n && isalnum(a[st + 1])) continue;
            int ed1 = st + 4, ed2 = st + 6;
            if (ed1 < n && a.substr(st, ed1 + 1) == "I can" ||
                ed2 < n && a.substr(st, ed2 + 1) == "I could") continue;
            a = a.substr(0, st) + "you" + a.substr(st + 1);
        }
        pos = 0;
        while ((pos = a.find("me", pos)) != a.npos) {
            int st = pos++, ed = st + 1;
            if (st > 0 && isalnum(a[st - 1]) || ed < n && isalnum(a[ed + 1])) continue;
            a = a.substr(0, st) + "you" + a.substr(ed + 1);
        }
        cout << a << '\n';
    }

    return 0;
}