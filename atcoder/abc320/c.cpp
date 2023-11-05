#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 110;
int n;
char s1[N], s2[N], s3[N];

int main() {
    scanf("%d%s%s%s", &n, s1, s2, s3);
    int mn = 2e9;
    for (int i = 0; i < 3 * n; ++i) {
        const char& c1 = s1[i % n];
        for (int j = 0; j < 3 * n; ++j) {
            if (j == i) continue;
            const char& c2 = s2[j % n];
            for (int k = 0; k < 3 * n; ++k) {
                if (k == i || k == j) continue;
                const char& c3 = s3[k % n];
                if (c1 == c2 && c2 == c3) {
                    int mx = max(i, max(j, k));
                    if (mx < mn) {
                        mn = min(mn, mx);
                    }
                }
            }
        }
    }
    if (mn == 2e9) mn = -1;
    printf("%d\n", mn);

    return 0;
}