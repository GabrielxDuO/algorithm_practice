#include <iostream>
#include <cstring>
#include <unordered_map>
#include <limits>

using namespace std;

const int N = 10;
int n;
char io[N], po[N];
int lefts[N], rights[N], idx;
unordered_map<char, int> mp;

int build_tree(int st, int ed) {
    if (st > ed) return -1;
    char rv = po[idx];
    int ri = mp[rv];
    --idx;
    rights[ri] = build_tree(ri + 1, ed);
    lefts[ri] = build_tree(st, ri - 1);
    return ri;
}

void preorder(int i) {
    if (!~i) return;
    putchar(io[i]);
    preorder(lefts[i]);
    preorder(rights[i]);
}

int main() {
    scanf("%s\n%s", io, po);
    int n = strlen(io);
    idx = n - 1;
    for (int i = 0; i < n; ++i) mp[io[i]] = i;
    preorder(build_tree(0, n - 1));

    return 0;
}