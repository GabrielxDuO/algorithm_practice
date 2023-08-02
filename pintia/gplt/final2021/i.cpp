#include <cstdio>
#include <queue>
#include <stack>

using namespace std;

const int N = 110;
int n, m, s;
queue<char> tracks[N];
stack<char> stk;

void exec(int x) {
    if (x) {
        if (!tracks[x].empty()) {
            if (stk.size() == s) exec(0);
            stk.push(tracks[x].front());
            tracks[x].pop(); 
        }
    } else {
        if (!stk.empty()) {
            printf("%c", stk.top());
            stk.pop();
        }
    }
}

int main() {
    scanf("%d%d%d", &n, &m, &s);
    for (int i = 1; i <= n; ++i) {
        scanf("\n");
        int c;
        for (int j = 0; j < m; ++j) {
            scanf("%c", &c);
            tracks[i].push(c);
        }
    }
    int op;
    while (~scanf("%d", &op) && ~op) exec(op);

    return 0;
}