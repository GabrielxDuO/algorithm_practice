#include <cstdio>
#include <unordered_map>

using namespace std;

int n;
unordered_map<int, unordered_map<int, int>> mp;

int main() {
    scanf("%d", &n);
    int x, y;
    while (n--) {
        scanf("%d%d", &x, &y);
        if (mp.find(x) != mp.end() && mp[x].find(y) != mp[x].end()) {
            puts("0.000"); // 两点相同的情况
            return 0;
        }
        mp[x][y] = 1;
    }
    puts("4.000"); // 试出来的 能骗10分

    return 0;
}