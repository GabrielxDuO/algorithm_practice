#include <iostream>

using namespace std;

int n;

void f(int x) {
    string s;
    for (int i = 20; i >= 0; --i) {
        if ((1 << i) <= x) {
            if (i == 0) printf("2(0)");
            else if (i == 1) printf("2");
            else {
                printf("2(");
                f(i);
                printf(")");
            }
            x -= 1 << i;
            if (x) printf("+");
        }
    }
}

int main() {
    scanf("%d", &n);
    f(n);

    return 0;
}