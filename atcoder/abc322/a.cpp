#include <cstdio>

using namespace std;

const int N = 110;
int n;
char s[N];

int main() {
    scanf("%d%s", &n, s);
    for (int i = 0; i + 2 < n; ++i) {
        if (s[i] == 'A' && s[i + 1] == 'B' && s[i + 2] == 'C') {
            printf("%d\n", i + 1);
            return 0;
        }
    }
    puts("-1");

    return 0;
}