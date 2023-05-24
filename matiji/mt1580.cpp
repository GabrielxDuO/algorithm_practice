#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    int cnt = 0;
    while (n--) {
        int score;
        scanf("%*s%*d%*s%*d%d", &score);
        if (score < 60) ++cnt;
    }
    printf("%d", cnt);

    return 0;
}