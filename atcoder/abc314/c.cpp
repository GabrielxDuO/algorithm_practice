#include <cstdio>
#include <utility>

using namespace std;

const int N = 2e5 + 10;
int n, m;
char s[N];
int c[N];
char prevs[N];

int main() {
    scanf("%d%d%s", &n, &m, s);
    for (int i = 0; i < n; ++i) scanf("%d", &c[i]);
    for (int i = 0; i < n; ++i) {
        if (prevs[c[i]]) swap(s[i], prevs[c[i]]);
        else prevs[c[i]] = s[i];
    }
    for (int i = 0; i < n; ++i) {
        if (prevs[c[i]]) s[i] = prevs[c[i]], prevs[c[i]] = '\0';
    }
    puts(s);

    return 0;
}