#include <cstdio>
#include <iostream>
#include <queue>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int K = 1e5 + 10;
int n, k;
queue<int> que;
struct Order {
    string name;
    int type, dt;

    bool operator<(const Order& o) const {
        if (dt != o.dt) return dt < o.dt;
        if (type != o.type) return type < o.type;
        return name < o.name;
    }

    friend ostream& operator<<(ostream& out, const Order& o) {
        out << o.name << " " << o.type << " " << o.dt;
        return out;
    }
} orders[K];
unordered_map<string, int> mp;
queue<Order> wt_que;
unordered_map<string, bool> waiting;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main() {
    cin >> n >> k;
    for (int i = 1; i <= n; ++i) que.push(i);
    for (int i = 0; i < k; ++i) {
        cin >> orders[i].name >> orders[i].type >> orders[i].dt;
    }
    sort(orders, orders + k);
    for (int i = 0; i < k; ++i) {
        const Order& u = orders[i];
        // cout << u << "\n";
        if (u.type) {
            if (!que.empty()) {
                mp[u.name] = que.front();
                cout << u.name << " - " << que.front() << '\n';
                que.pop();
            } else {
                wt_que.push(u);
                waiting[u.name] = true;
            }
        } else {
            if (mp.find(u.name) != mp.end()) {
                while (!wt_que.empty() && !waiting[wt_que.front().name]) wt_que.pop();
                if (!wt_que.empty()) {
                    const Order& v = wt_que.front(); wt_que.pop();
                    mp[v.name] = mp[u.name];
                    cout << v.name << " - " << mp[u.name] << '\n';
                } else que.push(mp[u.name]);
                mp.erase(u.name);
            } else {
                cout << u.name << " - NONE\n";
                waiting[u.name] = false;
            }
        }
    }
    while (!que.empty()) {
        cout << que.front(); que.pop();
        cout << (que.empty() ? "\n" : " ");
    }

    return 0;
}