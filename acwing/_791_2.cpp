#include <algorithm>
#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

const int N = 1e5 + 10;
char s1[N], s2[N];

struct BigNum {
    int x[N] = {0}, len = 0;

    BigNum() : len(1) {}

    BigNum(int num) {
        while (num) x[len++] = num % 10, num /= 10;
    }

    BigNum(const char* s) {
        len = strlen(s);
        for (int i = 0; i < len; ++i) x[i] = s[len - i - 1] - '0';
    }

    void print() {
        for (int i = len - 1; i >= 0; --i) putchar(x[i] + '0');
    }

    BigNum& operator+=(const BigNum& b) {
        len = max(len, b.len);
        for (int i = 0; i < len; ++i) {
            x[i] += b.x[i];
            if (x[i] >= 10) ++x[i + 1], x[i] -= 10;
        }
        if (x[len]) ++len;
        return *this;
    }

    friend BigNum operator+(const BigNum& a, const BigNum& b) {
        BigNum c = a;
        return c += b;
    }
};

int main() {
    cin.getline(s1, N), cin.getline(s2, N);
    BigNum a(s1), b(s2);
    (a + b).print();

    return 0;
}