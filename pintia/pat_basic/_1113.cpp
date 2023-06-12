#include <cstdio>
#include <cstring>
#include <cmath>
#include <cctype>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
char a[N], b[N], ans[N];

int conv(char c) {
    if (isdigit(c)) return c - '0';
    else return c - 'a' + 10;
}

char conv(int x) {
    if (x <= 9) return x + '0';
    else return x - 10 + 'a';
}

int main() {
    scanf("%s %s", a, b);
    int n = strlen(a), m = strlen(b);
    int rem = 0;
    int i = n - 1, j = m - 1, k = 0;
    for (; i >= 0 && j >= 0; --i, --j) {
        int x = conv(a[i]), y = conv(b[j]);
        int sum = x + y + rem;
        rem = sum / 30;
        sum %= 30;
        ans[k++] = conv(sum);
    }
    while (i >= 0) {
        int sum = rem + conv(a[i--]);
        rem = sum / 30;
        sum %= 30;
        ans[k++] = conv(sum);
    }
    while (j >= 0) {
        int sum = rem + conv(b[j--]);
        rem = sum / 30;
        sum %= 30;
        ans[k++] = conv(sum);
    }
    if (rem) ans[k++] = conv(rem);
    while (k - 1 >= 0 && ans[k - 1] == '0') --k;
    reverse(ans, ans + k);
    if (!k) ++k;
    ans[k] = '\0';
    printf("%s\n", ans);

    return 0;
}