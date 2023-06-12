#include <iostream>
#include <string>

using namespace std;

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    string n;
    cin >> n;
    bool all_prime = true;
    while (!n.empty()) {
        int x = stoi(n);
        bool isp = is_prime(x);
        if (!isp) all_prime = false;
        cout << n << ' ' << (isp ? "Yes" : "No") << '\n';
        n = n.substr(1);
    }
    if (all_prime) puts("All Prime!");

    return 0;
}