#include <iostream>

using namespace std;

int a, b, c;
bool used[10];
int nums[4];
bool has_soln;

void dfs(int u, int idx) {
    if (u == idx * 3) {
        if (idx < 3) dfs(u, idx + 1);
        else if (a * nums[2] == b * nums[1] && b * nums[3] == c * nums[2]) {
            printf("%d %d %d\n", nums[1], nums[2], nums[3]);
            has_soln = true;
        }
        return;
    }
    for (int x = 1; x <= 9; ++x) {
        if (!used[x]) {
            used[x] = true;
            nums[idx] = nums[idx] * 10 + x;
            dfs(u + 1, idx);
            nums[idx] /= 10;
            used[x] = false;
        }
    }
}

int main() {
    scanf("%d%d%d", &a, &b, &c);
    dfs(0, 1);
    if (!has_soln) puts("No!!!");

    return 0;
}