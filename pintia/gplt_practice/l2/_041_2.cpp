#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>

#define fi first
#define se second

using namespace std;

typedef pair<string, string> PSS;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int n;
string ign;
vector<PSS> segs;

int main() {
    cin >> n;
    segs.resize(n);
    for (int i = 0; i < n; ++i) {
        cin >> segs[i].fi >> ign >> segs[i].se;
    }
    sort(segs.begin(), segs.end());
    string curr = "00:00:00", ed = "23:59:59";
    for (const PSS& seg : segs) {
        string l = seg.fi, r = seg.se;
        if (curr < l) {
            cout << curr << " - " << l << '\n';
        }
        curr = r;
    }
    if (curr < ed) {
        cout << curr << " - " << ed << '\n';
    }

    return 0;
}