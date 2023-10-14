#include <cstdio>

using namespace std;

int n;

int main() {
    scanf("%d", &n);
    int prev = -1;
    while (n) {
        if (n % 10 <= prev) {
            puts("No");
            return 0;
        }
        prev = n % 10;
        n /= 10;
    }
    puts("Yes");

    return 0;
}