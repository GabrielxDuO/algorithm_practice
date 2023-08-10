#include <cstdio>
#include <unordered_map>
#include <queue>

using namespace std;

const int N = 35;
int n;
int pre[N], ino[N];
unordered_map<int, int> mp;
int p;
int tr[N];

struct Node {
    int val;
    Node *l, *r;

    Node(int x) : val(x) {}
};

Node* build(int st, int ed) {
    if (st > ed) return nullptr;
    int pv = pre[p], pi = mp[pv];
    Node* node = new Node(pv);
    ++p;
    node->l = build(st, pi - 1);
    node->r = build(pi + 1, ed);
    return node;
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &ino[i]);
        mp[ino[i]] = i;
    }
    for (int i = 1; i <= n; ++i) scanf("%d", &pre[i]);
    p = 1;
    Node* root = build(1, n);
    queue<Node*> que;
    que.push(root);
    while (!que.empty()) {
        Node* u = que.front(); que.pop();
        if (!u) continue;
        printf("%d", u->val);
        printf(--n ? " " : "\n");
        que.push(u->r);
        que.push(u->l);
    }

    return 0;
}