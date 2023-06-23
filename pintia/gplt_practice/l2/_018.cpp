#include <cstdio>
#include <vector>
#include <cstring>

using namespace std;

vector<double> a, b, res;
int n, amx, bmx;

void calc() {
    for (int i = amx; i >= bmx; --i) {
        int e = i - bmx;
        double c = a[i] / b[bmx];
        res[e] = c;
        for (int j = bmx - 1; j >= 0; --j) {
            a[j + e] -= c * b[j];
        }
    }
}

bool check(char s[]) {
    return strcmp(s, "0.0") && strcmp(s, "-0.0");
}

void print(vector<double>& p, int mx) {
    int len = 0;
    char c[20];
    for (int i = mx; i >= 0; --i) {
        sprintf(c, "%.1lf", p[i]);
        if (check(c)) ++len;
    }
    printf("%d ", len);
    if (!len) {
        puts("0 0.0");
        return;
    }
    for (int i = mx; i >= 0; --i) {
        sprintf(c, "%.1lf", p[i]);
        if (check(c)) {
            printf("%d %s", i, c);
            if (--len) printf(" ");
        }
    }
    puts("");
}

int main() {
    scanf("%d", &n);
    int e, c;
    for (int i = 0; i < n; ++i) {
        scanf("%d%d", &e, &c);
        if (!i) {
            a.assign(e + 1, 0);
            amx = e;
        }
        a[e] = c;
    }
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d%d", &e, &c);
        if (!i) {
            b.assign(e + 1, 0);
            bmx = e;
        }
        b[e] = c;
    }
    if (bmx > amx) {
        print(b, -1);
        print(a, amx);
        return 0;
    }
    res.assign(max(amx - bmx + 1, 1), 0);
    calc();
    print(res, res.size() - 1);
    print(a, bmx - 1);

    return 0;
}