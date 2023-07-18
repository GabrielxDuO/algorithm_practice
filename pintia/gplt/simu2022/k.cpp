#include <cstdio>
#include <queue>
#include <vector>

using namespace std;

const int N = 30;
int n;
int ino[N], post[N];
int pi;
struct Node {
    int val;
    Node *l, *r;

    Node(int x): val(x) {}
};
queue<Node*> que;
vector<vector<int>> levels;

Node* dfs(int st, int ed) {
    if (st > ed) return nullptr;
    int pv = post[pi], idx = 0;
    for (int i = st; i <= ed; ++i) {
        if (ino[i] == pv) {
            idx = i;
            break;
        }
    }
    --pi;
    Node* p = new Node(pv);
    p->r = dfs(idx + 1, ed);
    p->l = dfs(st, idx - 1);
    return p;
}

int main() {
    scanf("%d", &n);
    pi = n;
    for (int i = 1; i <= n; ++i) scanf("%d", &ino[i]);
    for (int i = 1; i <= n; ++i) scanf("%d", &post[i]);
    Node* root = dfs(1, n);
    que.push(root);
    int step = 0;
    while (!que.empty()) {
        int sz = que.size();
        levels.resize(step + 1);
        while (sz--) {
            Node* u = que.front(); que.pop();
            levels[step].push_back(u->val);
            if (u->l) que.push(u->l);
            if (u->r) que.push(u->r);
        }
        ++step;
    }
    printf("R:");
    for (auto level : levels) printf(" %d", level.back());
    puts("");
    printf("L:");
    for (auto level : levels) printf(" %d", level.front());
    puts("");

    return 0;
}