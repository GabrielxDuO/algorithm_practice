#include <cstdio>
#include <cmath>

using namespace std;

int x = 1e6;

bool is_prime(int n) {
    if (n <= 1) return false;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) return false;
    }
    return true;
}

int main() {
    while (true) {
        if (is_prime(x)) {
            printf("%d\n", x);
            break;
        }
        ++x;
    }

    return 0;
}