#include <cstdio>
#include <cstring>

using namespace std;

int cnts[10];
int cnt;

void calc(int x) {
    while (x) {
        if (x % 10 && ++cnts[x % 10] == 1) ++cnt;
        x /= 10;
    }
}

int main() {
    for (int a = 123; a * 3 < 1000; ++a) {
        int b = a * 2, c = a * 3;
        int t = a;
        cnt = 0;
        memset(cnts, 0, sizeof(cnts));
        calc(a), calc(b), calc(c);
        if (cnt == 9) printf("%d %d %d\n", a, b, c);
    }

    return 0;
}