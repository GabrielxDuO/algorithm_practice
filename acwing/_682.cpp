#include <iostream>

using namespace std;

const int N = 1e5 + 10;
const double eps = 1e-4;
int n, M, a[N];

bool check(double m) {
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
        cnt += (int) (a[i] / m);
        if (cnt >= M) return true;
    }
    return cnt >= M;
}

int main() {
    scanf("%d%d", &n, &M);
    double l = 0.0, r = 0.0;
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        r = max(r, x * 1.0);
        a[i] = x;
    }
    while (r - l > eps) {
        double m = (l + r) / 2;
        if (check(m)) l = m;
        else r = m;
    }
    printf("%.2lf\n", l);
    
    return 0;
}