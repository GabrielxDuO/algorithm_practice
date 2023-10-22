#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

const int N = 2010;
int B;
char a[N], b[N], c[N];

int conv(const char& c) {
    return c >= '0' && c <= '9' ? c - '0' : c - 'A' + 10;
}

char conv(const int& x) {
    return x < 10 ? x + '0' : x - 10 + 'A';
}

int main() {
    scanf("%d%s%s", &B, a, b);
    int n = strlen(a), m = strlen(b);
    int remain = 0;
    int i = n - 1, j = m - 1, k = 0;
    for (; i >= 0 && j >= 0; --i, --j, ++k) {
        int da = conv(a[i]), db = conv(b[j]);
        remain += da + db;
        c[k] = conv(remain % B);
        remain /= B;
    }
    while (i >= 0) {
        remain += conv(a[i]);
        c[k++] = conv(remain % B);
        remain /= B;
        --i;
    }
    while (j >= 0) {
        remain += conv(b[j]);
        c[k++] = conv(remain % B);
        remain /= B;
        --j;
    }
    if (remain) c[k++] = conv(remain);
    while (k--) putchar(c[k]);

    return 0;
}