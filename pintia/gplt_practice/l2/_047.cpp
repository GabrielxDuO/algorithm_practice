#include <cstdio>
#include <algorithm>

using namespace std;

const int K = 20, N = 1 << K;
int k;
int ans[N], prevs[N];

int main() {
    scanf("%d", &k);
    for (int i = k - 1; i >= 0; --i) {
        int mask = 1 << k - i - 1;
        for (int j = 0; j < 1 << i; ++j) {
            int x; scanf("%d", &x);
            int l = j << 1, r = j << 1 | 1;
            if (x < prevs[l] && x < prevs[r]) {
                puts("No Solution");
                return 0;
            } else if (x < prevs[l]) {
                for (int idx = r * mask; idx < (j + 1 << 1) * mask; ++idx) {
                    if (ans[idx] == 0) {
                        ans[idx] = x;
                        break;
                    }
                }
            } else {
                for (int idx = l * mask; idx < r * mask; ++idx) {
                    if (ans[idx] == 0) {
                        ans[idx] = x;
                        break;
                    }
                }
            }
            prevs[j] = max(x, max(prevs[l], prevs[r]));
        }
    }
    int winner; scanf("%d", &winner);
    if (prevs[0] < winner) {
        for (int i = 0; i < 1 << k; ++i) {
            if (i) printf(" ");
            printf("%d", !ans[i] ? winner : ans[i]);
        }
        puts("");
    } else puts("No Solution");

    return 0;
}