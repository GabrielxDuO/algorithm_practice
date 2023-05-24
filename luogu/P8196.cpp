#include <iostream>
#include <algorithm>

using namespace std;

const int N = 110;
int t, n;
int a[N];

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &n);
        for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                for (int k = j; k < n; ++k) {
                    if (a[i] + a[j] == a[k]) ++cnt;
                }
            }
        }
        printf("%d\n", cnt);
    }

    return 0;
}