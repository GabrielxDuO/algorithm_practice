#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N, C;
    scanf("%d%d", &N, &C);
    int nums[N];
    for (int i = 0; i < N; ++i) scanf("%d", &nums[i]);
    sort(nums, nums + N);
    long long ans = 0;
    for (int i = 0; i < N - 1; ++i) {
        auto pr = equal_range(nums + i, nums + N, nums[i] + C);
        ans += pr.second - pr.first;
    }
    printf("%lld", ans);

    return 0;
}