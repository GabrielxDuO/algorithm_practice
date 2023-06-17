#include <cstdio>
#include <cstring>

using namespace std;

const int N = 2e6 + 10;
int t;
char s[N];

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%s", s);
        int n = strlen(s);
        for (int i = 0; i < n - 1; ++i) {
            if (s[i] == 'a' && s[i + 1] != 'A') {
                puts("N");
                goto out;
            }
            if (s[i] == 'Z' && s[i + 1] != 'z') {
                puts("N");
                goto out;
            }
            if (s[i] >= 'A' && s[i] <= 'Y' && s[i + 1] != s[i] + 32 && s[i + 1] != s[i] + 1) {
                puts("N");
                goto out;
            }
            if (s[i] >= 'b' && s[i] <= 'z' && s[i + 1] != s[i] - 32 && s[i + 1] != s[i] - 1) {
                puts("N");
                goto out;
            }
        }
        puts("Y");
        out:;
    }

    return 0;
}