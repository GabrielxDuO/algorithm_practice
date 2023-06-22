#include <cstdio>

using namespace std;

const int N = 1e4 + 10;
int n;
char s[5], a[N];


int main() {
    scanf("%d %s %s", &n, s, a);
    char prev = s[0];
    printf("%c", prev);
    for (int i = 0; i < n; ++i) {
        int curr = a[i] - '0';
        if (curr) {
            if (prev == 'a' || prev == 'Z') continue;
            if (prev >= 'a' && prev <= 'z') --prev;
            else ++prev;
        } else {
            if (prev >= 'a' && prev <= 'z') prev -= 32;
            else prev += 32;
        }
        printf("%c", prev);
    }

    return 0;
}