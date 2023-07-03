#include <cstdio>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int N = 1e4 + 10, M = 2e5;
int n, m;
int fa[M], cnts[M];
int cnt;
unordered_map<string, int> mp;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

void modify(int u, int x) {
    u = fa[u];
    while (u) {
        cnts[u] += x;
        u = fa[u];
    }
}

int main() {
    cin >> n >> m;
    cnt = n;
    string a, b;
    int xa, xb;
    while (m--) {
        cin >> a >> b;
        if (mp.find(b) == mp.end()) xb = mp[b] = ++cnt;
        else xb = mp[b];
        if (a[0] >= '0' && a[0] <= '9') xa = stoi(a);
        else {
            if (mp.find(a) == mp.end()) xa = mp[a] = ++cnt;
            else xa = mp[a];
        }
        fa[xa] = xb;
    }
    for (int u = 1; u <= n; ++u) modify(u, 1);
    char op;
    while ((cin >> op) && op != 'E') {
        if (op == 'Q') {
            cin >> b;
            cout << cnts[mp[b]] << '\n';
        } else {
            cin >> xa >> b;
            modify(xa, -1);
            fa[xa] = mp[b];
            modify(xa, 1);
        }
    }

    return 0;
}