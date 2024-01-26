#include <cstdio>
#include <cstring>

using namespace std;

typedef unsigned long long ULL;

const int N = 1e4 + 10, M = 1510, P = 13331;
int n;
char s[M];
ULL hs[N];

ULL str_hash(char* s) {
    ULL res = 0LL;
    for (int i = 0; s[i]; ++i) {
        res = res * P + s[i];
    }
    return res;
}

int main() {
    scanf("%d", &n);
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        scanf("%s", s);
        hs[i] = str_hash(s);
        for (int j = 0; j < i; ++j) {
            if (hs[j] == hs[i]) goto out;
        }
        ++ans;
        out:;
    }
    printf("%d\n", ans);

    return 0;
}