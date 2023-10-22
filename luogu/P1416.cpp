#include <cstdio>
#include <algorithm>

using namespace std;

int n;

int main() {
    scanf("%d", &n);
    printf("%d\n", max(0, n - 2));

    return 0;
}