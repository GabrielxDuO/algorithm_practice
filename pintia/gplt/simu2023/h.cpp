#include <cstdio>

using namespace std;

int n;
int a[15];
char s[10];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    for (int i = 0; ; ++i) {
        int cnt = a[i % n];
        while (cnt-- && ~scanf("%s", s) && s[0] != 'E') {
            if (s[0] == 'C') puts("Bu");
            else if (s[0] == 'J') puts("ChuiZi");
            else puts("JianDao");
        }
        if (s[0] == 'E') break;
        scanf("%s", s);
        if (s[0] == 'E') break;
        if (s[0] == 'C') puts("JianDao");
        else if (s[0] == 'J') puts("Bu");
        else puts("ChuiZi");
    }

    return 0;
}