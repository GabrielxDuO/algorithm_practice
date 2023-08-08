#include <cstdio>
#include <stack>

using namespace std;

int n, x;
char s[2];
stack<int> s1;
stack<char> s2;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &x);
        s1.push(x);
    }
    while (--n) {
        scanf("%s", s);
        s2.push(s[0]);
    }
    while (s1.size() > 1) {
        int n1 = s1.top(); s1.pop();
        int n2 = s1.top(); s1.pop();
        char op = s2.top(); s2.pop();
        int res;
        if (op == '+') res = n2 + n1;
        else if (op == '-') res = n2 - n1;
        else if (op == '*') res = n2 * n1;
        else if (op == '/') {
            if (!n1) {
                printf("ERROR: %d/0\n", n2);
                return 0;
            }
            res = n2 / n1;
        }
        s1.push(res);
    }
    printf("%d\n", s1.top());

    return 0;
}