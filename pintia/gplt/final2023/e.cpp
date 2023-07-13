#include <cstdio>

using namespace std;

const int N = 110;
int n, k, x;
int a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    scanf("%d", &k);
    while (k--) {
        bool flag = true, has = false;
        for (int i = 0; i < n; ++i) {
            scanf("%d", &x);
            if (x) {
                has = true;
                if (x != a[i]) flag = false;
            }
        }
        puts(has && flag ? "Da Jiang!!!" : "Ai Ya");
    }

    return 0;
}