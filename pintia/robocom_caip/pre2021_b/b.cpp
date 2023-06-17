#include <cstdio>
#include <cmath>

using namespace std;

int L0, L1, L2, T, l0, l1, l2;

int main() {
    scanf("%d%d%d%d%d%d%d", &L0, &L1, &L2, &T, &l0, &l1, &l2);
    int D0 = L0 - l0, D1 = L1 - l1, D2 = L2 - l2;
    int sum = abs(D0) + abs(D1) + abs(D2);
    printf("Diff = %d, %d, %d\n", D0, D1, D2);
    puts(sum <= T ? "Yes" : "No");

    return 0;
}