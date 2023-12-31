#include <cstdio>

using namespace std;

char s[110];

int main() {
    scanf("%s", s);
    for (int i = 0; s[i]; ++i) {
        if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u') putchar(s[i]);
    }

    return 0;
}
