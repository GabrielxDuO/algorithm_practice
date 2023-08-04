#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

int n;
char s[100];

int main() {
    scanf("%d\n", &n);
    while (n--) {
        cin.getline(s, 100);
        if (strlen(s) < 6) {
            puts("Your password is tai duan le.");
            continue;
        }
        bool has_inv = false, has_alp = false, has_num = false;
        for (int i = 0; i < strlen(s); ++i) {
            if (isalpha(s[i])) has_alp = true;
            else if (isdigit(s[i])) has_num = true;
            else if (s[i] != '.') has_inv = true;
        }
        if (has_inv) puts("Your password is tai luan le.");
        else if (!has_num) puts("Your password needs shu zi.");
        else if (!has_alp) puts("Your password needs zi mu.");
        else puts("Your password is wan mei.");
    }

    return 0;
}