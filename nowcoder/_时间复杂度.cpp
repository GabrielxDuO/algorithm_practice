#include <iostream>

using namespace std;

int t, l;

int main() {
    scanf("%d", &t);
    while (t--) {
        char tb;
        int te = 1;
        scanf("%d O(%c", &l, &tb);
        if (tb == 'n') scanf("^%d)", te);
        else scanf(")");
        printf("%c^%d\n", tb, te);
        while (l--) {
            char op;
            scanf("\n%c", &op);
            if (op == 'F') {
                char i, x, y;
                scanf(" %c %c %c", &i, &x, &y);
                printf("for (int %c = %c; %c <= %c; ++%c) {\n", i, x, i, y, i);
            } else puts("}");
        }
    }

    return 0;
}