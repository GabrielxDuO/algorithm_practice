#include <cstdio>
#include <unordered_map>

using namespace std;

const int N = 1e5 + 10;
int n;
int a[N];
unordered_map<int, int> cnts;

int lowbit(int x) {
    return x & -x;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
        int x = a[i];
        while (x) {
            int mask = lowbit(x);
            ++cnts[mask];
            x -= mask;
        }
    }
    int mx = 0, mx_idx = 0;
    for (int i = 0; i < n; ++i) {
        int x = a[i];
        int val = 0;
        while (x) {
            int mask = lowbit(x);
            if (cnts[mask] == 1) val += mask;
            x -= mask;
        }
        if (val > mx) {
            mx = val;
            mx_idx = i;
        }
    }
    printf("%d ", a[mx_idx]);
    for (int i = 0; i < n; ++i) {
        if (mx_idx != i) printf("%d ", a[i]);
    }

    return 0;
}