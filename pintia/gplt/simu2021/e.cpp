#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010;
char s[N];

int main() {
    cin.getline(s, N);
    int n = strlen(s);
    for (int i = 0; i < n; ++i) {
        if (s[i] == '6') {
            int cnt = 1;
            while (s[i + 1] == '6' && i + 1 < n) ++i, ++cnt;
            if (cnt > 9) printf("27");
            else if (cnt > 3) printf("9");
            else while (cnt--) printf("6");
        } else printf("%c", s[i]);
    }

    return 0;
}