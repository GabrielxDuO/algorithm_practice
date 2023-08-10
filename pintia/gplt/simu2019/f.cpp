#include <cstdio>

using namespace std;

char s[5];

int main() {
    int n; scanf("%d", &n);
    while (n--) {
        for (int i = 0; i < 4; ++i) {
            scanf("%s", s);
            if (s[2] == 'T') printf("%d", s[0] - 'A' + 1);
        }
    }

    return 0;
}