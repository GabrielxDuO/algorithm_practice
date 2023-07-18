#include <cstdio>

using namespace std;

int n, x;

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d", &x);
        int y = -1;
        bool flag = true;
        for (int i = 2; i <= 9; ++i) {
            int t = x * i, sum = 0;
            while (t) {
                sum += t % 10;
                t /= 10;
            }
            if (y == -1) y = sum;
            else if (sum != y) {
                puts("NO");
                flag = false;
                break;
            }
        }
        if (flag) printf("%d\n", y);
    }

    return 0;
}