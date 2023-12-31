#include <cstdio>
#include <algorithm>

using namespace std;

const int M = 110;
int m;
int s[M];

int main() {
    scanf("%d", &m);
    for (int i = 1; i <= m; ++i) {
        scanf("%d", &s[i]);
        s[i] += s[i - 1];
    }
    int hf = s[m] / 2 + 1, i;
    int* pos = lower_bound(s + 1, s + m + 1, hf);
    if (pos == s + m + 1) --pos;
    printf("%d %d\n", pos - s, hf - *(pos - 1));

    return 0;
}