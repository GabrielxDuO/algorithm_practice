#include <cstdio>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <set>

#define fi first
#define se second

using namespace std;

typedef pair<int, string> PIS;

const int N = 5010;
int n, c;
string a[N];
priority_queue<PIS> pq;
unordered_map<string, int> cnts;
multiset<int> st;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main() {
    cin >> n >> c;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        int cnt;
        cin >> a[i] >> cnt;
        ans += cnt / c;
        cnts[a[i]] += cnt / c;
        if (cnt % c) pq.push({cnt % c, a[i]});
    }
    while (!pq.empty()) {
        auto u = pq.top(); pq.pop();
        int x = u.fi;
        string s = u.se;
        ++cnts[s];
        if (x >= c) {
            st.insert(0);
            if (x > c) pq.push({x - c, s});
        } else {
            auto it = lower_bound(st.begin(), st.end(), x);
            if (it != st.end()) {
                int k = *it - x;
                st.erase(it);
                st.insert(k);
            } else st.insert(c - x);
        }
    }
    for (int i = 0; i < n; ++i) {
        cout << a[i] << ' ' << cnts[a[i]] << '\n';
    }
    cout << st.size() + ans;

    return 0;
}