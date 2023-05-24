#include <iostream>
#include <cstring>
#include <limits>
#include <unordered_map>
#include <vector>

using namespace std;

const int N = 60, INF = 0x3f3f3f3f;
unordered_map<char, int> mp;
vector<char> cows;
int p, n, g[N][N], dists[N];
bool vis[N];

int dijkstra(int ori, int dest) {
    memset(dists, 0x3f, sizeof(dists));
    memset(vis, 0, sizeof(vis));
    dists[ori] = 0;
    for (int i = 1; i < n; ++i) {
        int mn = -1;
        for (int j = 1; j <= n; ++j) {
            if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
        }
        vis[mn] = true;
        for (int j = 1; j <= n; ++j) {
            dists[j] = min(dists[j], dists[mn] + g[mn][j]);
        }
    }
    return dists[dest];
}

int main() {
    scanf("%d", &p);
    memset(g, 0x3f, sizeof(g));
    mp['Z'] = ++n;
    while (p--) {
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        char u, v;
        int w;
        scanf("%c %c %d", &u, &v, &w);
        if (mp.find(u) == mp.end()) mp[u] = ++n;
        if (mp.find(v) == mp.end()) mp[v] = ++n;
        int a = mp[u], b = mp[v];
        g[a][b] = g[b][a] = min(g[a][b], w);
        if (u >= 'A' && u < 'Z') cows.push_back(u);
        if (v >= 'A' && v < 'Z') cows.push_back(v);
    }
    char mn_cow;
    int mn_dist = INF;
    for (auto& cow : cows) {
        int dist = dijkstra(mp[cow], 1);
        if (dist < mn_dist) {
            mn_cow = cow;
            mn_dist = dist;
        }
    }
    printf("%c %d\n", mn_cow, mn_dist);
    
    return 0;
}
