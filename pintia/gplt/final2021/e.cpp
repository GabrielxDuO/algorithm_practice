#include <cstdio>

using namespace std;

int emo[30], x;

int main() {
    for (int i = 0; i < 24; ++i) scanf("%d", &emo[i]);
    while (~scanf("%d", &x) && x >= 0 && x < 24)
        printf(emo[x] > 50 ? "%d Yes\n" : "%d No\n", emo[x]);

    return 0;
}