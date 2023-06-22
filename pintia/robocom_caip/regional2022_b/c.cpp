#include <cstdio>

using namespace std;

int n, t;
char time[50];
int x;

int main() {
    scanf("%d%d", &n, &t);
    while (n--) {
        scanf("%s %d", time, &x);
        if (x < 80 - t || x > 80 + t) printf("%s %d\n", time, x);
    }

    return 0;
}