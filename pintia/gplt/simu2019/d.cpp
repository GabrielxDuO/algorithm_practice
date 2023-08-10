#include <cstdio>

using namespace std;

char s[5];

int main() {
    int n; scanf("%d", &n);
    while (n--) {
        int a, b; scanf("%s%d%d", s, &a, &b);
        if (a < 15 || a > 20 || b < 50 || b > 70) printf("%s\n", s);
    }

    return 0;
}