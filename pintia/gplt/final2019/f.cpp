#include <cstdio>

using namespace std;

int t;

int sum(int n) {
    int s = 0;
    while (n) {
        s += n % 10;
        n /= 10;
    }
    return s;
}

int main() {
    scanf("%d", &t);
    while (t--) {
        int x; scanf("%d", &x);
        int l = x / 1000, r = x % 1000;
        int ls = sum(l), rs = sum(r);
        puts(ls == rs ? "You are lucky!" : "Wish you good luck.");
    }

    return 0;
}