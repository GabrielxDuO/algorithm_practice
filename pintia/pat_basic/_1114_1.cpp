#include <cstdio>
#include <iostream>
#include <string>
#include <cmath>

using namespace std;

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    string s; cin >> s;
    int n = stoi(s), len = s.size();
    int mask = pow(10, len);
    bool all_prime = true;
    while (len--) {
        int top = n / mask;
        n -= mask * top;
        bool isp = is_prime(n);
        if (!isp) all_prime = false;
        string fmt = "%0" + to_string(len + 1) + "d " + (isp ? "Yes\n" : "No\n");
        printf(fmt.c_str(), n);
        mask /= 10;
    }
    if (all_prime) puts("All Prime!");

    return 0;
}