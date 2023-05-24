#include <iostream>

using namespace std;

string solve() {
    char c;
    string s;
    while (~scanf("%c", &c)) {
        if (c == '[') {
            int d;
            scanf("%d", &d);
            string rep = solve();
            while (d--) s += rep;
        } else if (c == ']') return s;
        else s += c;
    }
}

int main() {
    printf("%s\n", solve().c_str());

    return 0;
}