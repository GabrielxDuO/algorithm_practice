#include <cstdio>
#include <iostream>
#include <unordered_map>

#define fi first
#define se second

using namespace std;

typedef pair<string, bool> PSB;

int n, m;
unordered_map<string, PSB> mp;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

bool check(string a, string b) {
    string bak = b;
    for (int i = 1; !a.empty(); ++i, a = mp[a].fi) {
        b = bak;
        for (int j = 1; !b.empty(); ++j, b = mp[b].fi) {
            if (i >= 5 && j >= 5) return false;
            if (a == b && (i < 5 || j < 5)) return true;
        }
    }
    return false;
}

int main() {
    cin >> n;
    string fn, ln;
    while (n--) {
        cin >> fn >> ln;
        int len = ln.size();
        char& ed = ln.back();
        if (ed == 'm' || ed == 'f') mp[fn].se = (ed == 'm');
        else if (ed == 'n') mp[fn] = {ln.substr(0, len - 4), true};
        else if (ed == 'r') mp[fn] = {ln.substr(0, len - 7), false};
    }
    cin >> m;
    string s1, s2, ign;
    while (m--) {
        cin >> s1 >> ign >> s2 >> ign;
        if (mp.find(s1) == mp.end() || mp.find(s2) == mp.end()) {
            cout << "NA\n";
            continue;
        }
        if (mp[s1].se == mp[s2].se) {
            cout << "Whatever\n";
            continue;
        }
        cout << (check(s1, s2) ? "No\n" : "Yes\n");
    }

    return 0;
}