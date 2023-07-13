#include <cstdio>

using namespace std;

int n, a, b, c;

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d%d%d", &a, &b, &c);
        if (c == a * b) puts("Lv Yan");
        else if (c == a + b) puts("Tu Dou");
        else puts("zhe du shi sha ya!");
    }

    return 0;
}