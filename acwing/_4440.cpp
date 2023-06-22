#include <cstdio>

using namespace std;

const int N = 2e5 + 10;
char s[N];
int n;

// https://www.acwing.com/activity/content/problem/content/8446/

int main() {
    scanf("%d %s", &n, s);
    bool first = true, prev;
    int cnt = 0;
    for (int i = 0; i < n; i += 2) {
        if (s[i] == s[i + 1]) continue;
        bool curr = s[i] - s[i + 1] < 0;
        if (!first && curr ^ prev) ++cnt;
        first = false;
        prev = curr;
    }
    if (prev) ++cnt;
    printf("%d\n", cnt);

    return 0;
}