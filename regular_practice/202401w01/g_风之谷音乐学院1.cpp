#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10, M = 1e3 + 10, T = 110;
char s[N];
char p[T][M];
int t;

int main() {
    scanf("%s%d", s, &t);
    vector<char*> mxs;
    int mx_cnt = 0;
    for (int i = 0; i < t; ++i) {
        scanf("%s", p[i]);
        int cnt = 0;
        char* pt = s;
        while (pt = strstr(pt, p[i])) ++cnt, ++pt;
        if (cnt < mx_cnt) continue;
        if (cnt > mx_cnt) {
            mx_cnt = cnt;
            mxs.clear();
        }
        mxs.push_back(p[i]);
    }
    printf("%d\n", mx_cnt);
    sort(mxs.begin(), mxs.end(), [](const char* s1, const char* s2) { return strcmp(s1, s2) < 0; });
    char* prev = s;
    for (char* p : mxs) {
        if (strcmp(prev, p)) puts(p);
        prev = p;
    }

    return 0;
}