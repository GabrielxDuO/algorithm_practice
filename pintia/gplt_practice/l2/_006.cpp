#include <cstdio>
#include <queue>

using namespace std;

const int N = 35;
int n;
int in[N], post[N];
int pi;
struct Node {
    int val;
    Node *l, *r;
    
    Node(int x): val(x) {}
};

Node* dfs(int st, int ed) {
    if (st > ed) return nullptr;
    int pv = post[pi], idx = 0;
    for (int i = st; i <= ed; ++i) {
        if (in[i] == pv) {
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
    for (int i = 1; i <= n; ++i) scanf("%d", &post[i]);
    for (int i = 1; i <= n; ++i) scanf("%d", &in[i]);
    Node* root = dfs(1, n);
    queue<Node*> que;
    que.push(root);
    while (!que.empty()) {
        Node* u = que.front(); que.pop();
        if (!u) continue;
        printf("%d", u->val);
        printf(--n ? " " : "\n");
        que.push(u->l);
        que.push(u->r);
    }

    return 0;
}