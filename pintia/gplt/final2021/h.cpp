#include <cstdio>
#include <vector>

using namespace std;

int a1, a2, n;
vector<int> a, t;

int main() {
    scanf("%d%d%d", &a1, &a2, &n);
    a.push_back(a1);
    a.push_back(a2);
    for (int i = 0; a.size () < n; ++i) {
        int x = a[i] * a[i + 1];
        if (!x) {
            a.push_back(0);
            continue;
        }
        t.clear();
        while (x) {
            t.push_back(x % 10);
            x /= 10;
        }
        for (auto it = t.rbegin(); it != t.rend() && a.size() < n; ++it)
            a.push_back(*it);
    }
    bool is_first = true;
    for (int i = 0; i < n; ++i) {
        if (is_first) is_first = false;
        else printf(" ");
        printf("%d", a[i]);
    }

    return 0;
}