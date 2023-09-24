#include <cstdio>
#include <map>

using namespace std;

int n;
map<int, int> cnts;

int main() {
    scanf("%d", &n);
    while (n--) {
        int x; scanf("%d", &x);
        ++cnts[x];
    }
    for (auto pr : cnts) printf("%d %d\n", pr.first, pr.second);

    return 0;
}