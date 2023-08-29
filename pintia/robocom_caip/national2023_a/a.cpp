#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

const int N = 110;
int n, len;
char s[N];

void trans(char s[]) {
    for (int i = 0; i < len; ++i) {
        if (s[i] == 'Z') s[i] = 'A';
        else if (s[i] == 'a') s[i] = 'z';
        else if (s[i] >= 'A' && s[i] < 'Z') ++s[i];
        else if (s[i] > 'a' && s[i] <= 'z') --s[i];
    }
    for (int i = 0; i < len; ++i) {
        if (s[i] >= 'A' && s[i] <= 'Z') {
            int j = i;
            while (i + 1 < len && s[i + 1] >= 'A' && s[i + 1] <= 'Z') ++i;
            if (i - j + 1 >= 3) {
                for (; j <= i; ++j) s[j] += 32;
            } else i = j;
        } else if (s[i] >= 'a' && s[i] < 'z') {
            int j = i;
            while (i + 1 < len && s[i + 1] >= 'a' && s[i + 1] <= 'z') ++i;
            if (i - j + 1 >= 3) {
                for (; j <= i; ++j) s[j] -= 32;
            } else i = j;
        }
    }
}

int main() {
    scanf("%d\n", &n);
    cin.getline(s, N);
    if (!strcmp(s, "yourname")) {
        memset(s, '\0', sizeof(s));
        s[0] = 'x';
    }
    len = strlen(s);
    puts(s);
    while (n--) trans(s);
    puts(s);

    return 0;
}