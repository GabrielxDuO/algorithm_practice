#include <iostream>
#include <cmath>

using namespace std;

int a, b;
int a_len, b_len;
int extra[] = {2, 3, 5, 7, 11};

bool is_prime(int n) {
    if (n < 2) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    scanf("%d%d", &a, &b);
    int t = a;
    while (t) ++a_len, t /= 10;
    t = b;
    while (t) ++b_len, t /= 10;
    for (int& x : extra) {
        if (x >= a && x <= b) printf("%d\n", x);
    }
    for (int hf_len = max(a_len / 2 + 1, 2); hf_len <= (b_len + 1) / 2; ++hf_len) {
        int st = pow(10, hf_len - 1), ed = pow(10, hf_len);
        for (int hf = st; hf < ed; ++hf) {
            bool is_odd = hf / st & 1;
            if (!is_odd) {
                hf += st - 1;
                continue;
            }
            int x = hf, t = hf / 10;
            while (t) x = x * 10 + t % 10, t /= 10;
            if (x < a) continue;
            if (x > b) return 0;
            if (is_prime(x)) printf("%d\n", x);
        }
    }

    return 0;
}