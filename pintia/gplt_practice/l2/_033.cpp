#include <cstdio>

using namespace std;

const int N = 1e3 + 10;
int n;
int s1[N], t1, t2;
char s2[N];
char s[N];

int calc(int a, int b, char op) {
    if (op == '+') return a + b;
    if (op == '-') return a - b;
    if (op == '*') return a * b;
    if (op == '/') return a / b;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &s1[++t1]);
    for (int i = 0; i < n - 1; ++i) {
        scanf("%s", s);
        s2[++t2] = s[0];
    }
    while (t1 > 1) {
        int n1 = s1[t1--], n2 = s1[t1--];
        char op = s2[t2--];
        if (op == '/' && n1 == 0) {
            printf("ERROR: %d/0\n", n2, n1);
            return 0;
        }
        s1[++t1] = calc(n2, n1, op);
    }
    printf("%d\n", s1[t1--]);

    return 0;
}