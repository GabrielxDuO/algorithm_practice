#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1010;
int n;
struct Node {
    int val;
    Node *l, *r;

    Node() {}
    Node(int val) : val(val) {}
};
int cnts[N];
int dep = 0;

void ins(Node *u, int x, int d) {
    if (x <= u->val) {
        if (u->l) ins(u->l, x, d + 1);
        else {
            u->l = new Node(x);
            ++cnts[d + 1];
        }
    } else {
        if (u->r) ins(u->r, x, d + 1);
        else {
            u->r = new Node(x);
            ++cnts[d + 1];
        }
    }
    dep = max(d + 1, dep);
}

int main() {
    scanf("%d", &n);
    Node* root = new Node();
    scanf("%d", &root->val);
    cnts[0] = 1;
    while (--n) {
        int x; scanf("%d", &x);
        ins(root, x, 0);
    }
    printf("%d\n", cnts[dep] + cnts[dep - 1]);

    return 0;
}