#include <cstdio>
#include <cstring>

using namespace std;

const int N = 1010;
int n;
int prevs[N];

int main() {
    scanf("%d", &n);
    while (n--) {
        int id, hh, mm;
        char op;
        memset(prevs, -1, sizeof(prevs));
        int cnt = 0, tot = 0;
        while (~scanf("%d %c %d:%d", &id, &op, &hh, &mm) && id) {
            int time = hh * 60 + mm;
            if (op == 'S') {
                // if (~prevs[id]) continue;
                prevs[id] = time;
            } else {
                if (prevs[id] == -1) continue;
                ++cnt;
                tot += time - prevs[id];
                prevs[id] = -1;
            }
        }
        if (cnt == 0) puts("0 0");
        else printf("%d %.0lf\n", cnt, tot * 1.0 / cnt);
    }

    return 0;
}