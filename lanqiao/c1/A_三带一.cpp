#include <cstdio>
#include <cstring>

using namespace std;

int t;
int cnts[128];

int main() {
    scanf("%d", &t);
    while (t--) {
        getchar();
        memset(cnts, 0, sizeof(cnts));
        bool flag = false;
        for (int i = 0; i < 4; ++i) {
            char c = getchar();
            ++cnts[c];
            if (cnts[c] == 3) flag = true;
            else if (cnts[c] == 4) flag = false;
        }
        puts(flag ? "Yes" : "No");
    }

    return 0;
}