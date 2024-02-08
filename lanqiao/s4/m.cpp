#include <cstdio>

using namespace std;

const int N = 2e5 + 10;
int n;
int a_idx[N], b[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int x; scanf("%d", &x);
        a_idx[x] = i;
    }
    

    return 0;
}