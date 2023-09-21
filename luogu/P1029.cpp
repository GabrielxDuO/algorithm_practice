#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int x, y;
bool vis[N];

int gcd(int a, int b) {
    return b ? gcd(b, a % b) : a;
}

int lcm(int a, int b) {
    return a / gcd(a, b) * b;
}

int main() {
    scanf("%d%d", &x, &y);
    int cnt = 0;
    for (int a = x; a <= y; ++a) {
        int b = x * y / a;
        if (a * b != x * y) continue;
        if (gcd(a, b) == x && lcm(a, b) == y) ++cnt;
    }
    printf("%d\n", cnt);

    return 0;
}