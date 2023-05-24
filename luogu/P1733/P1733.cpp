#include <iostream>
#include <cstdio>

using namespace std;

int main() {
    int l = 1, r = 1e9;
    while (l < r) {
        int m = l + r >> 1;
        cout << m << endl;
        int res;
        cin >> res;
        if (res >= 0) r = m;
        else l = m + 1;
    }
    cout << l << endl;

    return 0;
}