#include <iostream>
#include <algorithm>

using namespace std;

const int N = 310;
int n;
struct Stu {
    int y, t, idx;
} stus[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int y, math, eng;
        scanf("%d%d%d", &y, &math, &eng);
        stus[i] = {y, y + math + eng, i};
    }
    sort(stus + 1, stus + n + 1, [](Stu& a, Stu& b) {
        if (a.t != b.t) return a.t > b.t;
        if (a.y != b.y) return a.y > b.y;
        return a.idx < b.idx;
    });
    for (int i = 1; i <= min(5, n); ++i) {
        printf("%d %d\n", stus[i].idx, stus[i].t);
    }

    return 0;
}