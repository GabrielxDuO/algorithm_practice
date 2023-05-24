#include <iostream>
#include <cstring>

using namespace std;

const int N = 300;
char s[N];
int n, k;

int main() {
    scanf("%s\n", &s);
    n = strlen(s);
    scanf("%d", &k);
    int len = n - k;
    string ans;
    int st = 0;
    while (len--) {
        int mn_idx = st;
        for (int i = st; i < n - len; ++i) {
            if (s[i] < s[mn_idx]) mn_idx = i;
        }
        ans += s[mn_idx];
        st = mn_idx + 1;
    }
    len = n - k;
    int idx = 0;
    for (; idx < len; ++idx) {
        if (ans[idx] != '0') break;
    }
    ans = ans.substr(idx);
    if (ans.empty()) ans += '0';
    printf("%s\n", ans.c_str());

    return 0;
}