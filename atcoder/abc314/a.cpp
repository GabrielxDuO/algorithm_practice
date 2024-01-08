#include <cstdio>

using namespace std;

const char s[] = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
int n;

int main() {
    scanf("%d", &n);
    printf("3.");
    for (int i = 0; i < n; ++i) putchar(s[i]);

    return 0;
}