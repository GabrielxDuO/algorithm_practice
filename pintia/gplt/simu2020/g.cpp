#include <cstdio>
#include <iostream>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int l, k;
string s;

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    cin >> l >> k >> s;
    for (int i = 0; i < l - k + 1; ++i) {
        string t = s.substr(i, k);
        if (is_prime(stoi(t))) {
            cout << t << '\n';
            return 0;
        }
    }
    cout << "404\n";

    return 0;
}