#include <cstdio>
#include <iostream>
#include <limits>

using namespace std;

int n, m;
string s;

int main() {
    cin >> n >> m;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    while (n--) {
        getline(cin, s);
        if (s.find("qiandao") != s.npos || s.find("easy") != s.npos) continue;
        if (m-- == 0) {
            puts(s.c_str());
            return 0;
        }
    }
    puts("Wo AK le");

    return 0;
}