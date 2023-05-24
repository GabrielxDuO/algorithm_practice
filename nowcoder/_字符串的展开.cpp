#include <iostream>
#include <cstring>

using namespace std;

const int N = 110;
int p1, p2, p3;
char s[N];
int n;

int main() {
    scanf("%d%d%d\n", &p1, &p2, &p3);
    cin.getline(s, N);
    n = strlen(s);
    for (int i = 0; i < n; ++i) {
        if (s[i] == '-' && i - 1 >= 0 && i + 1 < n) {
            if (islower(s[i - 1]) && islower(s[i + 1]) || isdigit(s[i - 1]) && isdigit(s[i + 1])) {
                if (s[i - 1] >= s[i + 1]) printf("-");
                else {
                    if (s[i - 1] + 1 == s[i + 1]) continue;
                    char st = s[i - 1] + 1, ed = s[i + 1] - 1;
                    int vari = 1;
                    if (p3 == 2) {
                        swap(st, ed);
                        vari = -1;
                    }
                    for (char i = st; ; i += vari) {
                        for (int j = 0; j < p2; ++j) {
                            char c = i;
                            if (p1 == 2) c = toupper(c);
                            else if (p1 == 3) c = '*';
                            printf("%c", c);
                        }
                        if (i == ed) break;
                    }
                }
            } else printf("-");
        } else printf("%c", s[i]);
    }

    return 0;
}