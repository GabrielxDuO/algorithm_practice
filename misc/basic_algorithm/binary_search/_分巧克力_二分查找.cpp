#include <iostream>

using namespace std;

const int MAX_N = 100010;
int N, K;
int chocos[MAX_N][2];

bool check(int n) {
    int cnt = 0;
    for (int i = 0; i < N; ++i) {
        cnt += (chocos[i][0] / n) * (chocos[i][1] / n);
        if (cnt >= K) return true;
    }
    return false;
}

int main() {
    scanf("%d%d", &N, &K);
    int l = 0, r = 0;
    for (int i = 0; i < N; ++i) {
        int H, W;
        scanf("%d%d", &H, &W);
        r = max(r, max(H, W));
        chocos[i][0] = H;
        chocos[i][1] = W;
    }
    while (l < r) {
        int c = l + (r - l + 1 >> 1);
        if (check(c)) l = c;
        else r = c - 1;
    }
    printf("%d", l);

    return 0;
}