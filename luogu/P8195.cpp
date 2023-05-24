#include <iostream>

using namespace std;

int main() {
    string s;
    getline(cin, s);
    int cnt = 0, i = -1;
    while (true) {
        i = s.find("chuanzhi", i + 1);
        if (~i) ++cnt;
        else break;
    }
    printf("%d\n", cnt);

    return 0;
}