#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n;
char s[N];

int main() {
    scanf("%d%s", &n, s);
    int p0 = -1, p1 = -1;
    int ans0 = 0, ans1 = 0;
    for (int i = 0; i < n; ++i) {
        if (s[i] == '0') {
            ans0 += i - p0 - 1;
            ++p0;
        } else {
            ans1 += i - p1 - 1;
            ++p1;
        }
    }
    printf("%d\n", min(ans0, ans1));

    return 0;
}