#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

char s[1010];

int main() {
    cin.getline(s, 1010);
    int n = strlen(s);
    for (int i = 0; i < n; ++i) {
        if (s[i] != '6') printf("%c", s[i]);
        else {
            int cnt = 1;
            while (s[i + 1] == '6' && i + 1 < n) ++i, ++cnt;
            if (cnt <= 3) {
                while (cnt--) printf("6");
            } else if (cnt <= 9) printf("9");
            else printf("27");
        }
    }
    

    return 0;
}