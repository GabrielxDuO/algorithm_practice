#include <cstdio>
#include <iostream>
#include <algorithm>

#define fi first
#define se second

using namespace std;

typedef pair<string, int> PSI;

const int N = 1e4 + 10;
int n, g, k;
PSI stus[N];
int tot = 0;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main() {
    cin >> n >> g >> k;
    for (int i = 0; i < n; ++i) {
        cin >> stus[i].fi >> stus[i].se;
        if (stus[i].se >= g) tot += 50;
        else if (stus[i].se>= 60) tot += 20;
    }
    cout << tot << '\n';
    sort(stus, stus + n, [](PSI& a, PSI& b) {
        if (a.se != b.se) return a.se >= b.se;
        return a.fi < b.fi;
    });
    int prev = -1, rk = 0;
    for (int i = 0; i < n; ++i) {
        string& id = stus[i].fi;
        int& s = stus[i].se;
        if (s != prev) {
            rk = i + 1;
            if (rk > k) break;
        }
        cout << rk << ' ' << id << ' ' << s << '\n';
        prev = s;
    }


    return 0;
}