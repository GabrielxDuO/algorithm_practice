#include <cstdio>
#include <stack>
#include <algorithm>

using namespace std;

int n;
stack<int> b;
int cnt = 0, h = 0, mx = 0;

int main() {
    scanf("%d", &n);
    int a = 1e9;
    while (n--) {
        int c; scanf("%d", &c);
        if (c < a) {
            a = c;
            ++h;
        } else {
            if (b.empty() || c > b.top()) b.push(c);
            else {
                mx = max(mx, h);
                ++cnt;
                h = 0;
                while (!b.empty() && b.top() > c) {
                    ++h;
                    b.pop();
                }
                a = c;
                ++h;
            }
        }
    }
    if (h) ++cnt;
    if (b.size()) ++cnt;
    mx = max(mx, max(h, (int) b.size()));
    printf("%d %d\n", cnt, mx);

    return 0;
}