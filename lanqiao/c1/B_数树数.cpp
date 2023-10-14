#include <cstdio>

using namespace std;


const int N = 25;
int n, q;
char s[N];

int main() {
    scanf("%d%d", &n, &q);
    while (q--) {
        scanf("%s", s);
        int x = 1;
        for (int i = 0; s[i]; ++i) {
            x <<= 1;
            if (s[i] == 'L') --x;
        }
        printf("%d\n", x);
    }

    return 0;
}