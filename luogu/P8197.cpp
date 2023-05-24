#include <iostream>
#include <unordered_map>

using namespace std;

const int N = 1010;
int t, n;
int a[N], b[N];
unordered_map<int, int> mp;

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &n);
        for (int i = 1; i <= n; ++i) {
            scanf("%d", &a[i]);
            ++mp[a[i]];
        }
        bool flag = false;
        for (int i = 1; i <= n; ++i) {
            scanf("%d", &b[i]);
            if (--mp[b[i]] < 0) flag = true;
        }
        if (flag) {
            puts("NO");
            continue;
        }
        puts("YES");
        for (int i = 1; i <= n; ++i) {
            if (a[i] != b[i]) {
                for (int j = i; j <= n; ++j) {
                    if (a[j] == b[i]) {
                        for (int k = j; k > i; --k) {
                            swap(a[k], a[k - 1]);
                            printf("%d %d\n", k, k - 1);
                        }
                        break;
                    }
                }
            }
        }
        puts("0 0");
    }

    return 0;
}