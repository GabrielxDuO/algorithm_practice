#include <cstdio>
#include <cstring>

using namespace std;

const int N = 2e6 + 10;
int n;
char s[N];

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%s", s);
        int len = strlen(s);
        for (int i = 0; i < len - 1; ++i) {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                if (s[i] == 'Z' && s[i + 1] != s[i] + 32 || s[i + 1] != s[i] + 1 && s[i + 1] != s[i] + 32) {
                    puts("N");
                    goto out;
                }
            } else if (s[i] >= 'a' && s[i] <= 'z') {
                if (s[i] == 'a' && s[i + 1] != s[i] - 32 || s[i + 1] != s[i] - 1 && s[i + 1] != s[i] - 32) {
                    puts("N");
                    goto out;
                }
            }
        }
        puts("Y");
        out:;
    }

    return 0;
}