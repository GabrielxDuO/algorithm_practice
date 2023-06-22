#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <set>

using namespace std;

int n, m;
unordered_set<string> subs;
unordered_map<string, int> mp;
set<string> ans;

int main() {
    scanf("%d", &n);
    while (n--) {
        string s; cin >> s;
        subs.insert(s);
    }
    scanf("%d", &m);
    int sum = 0;
    for (int i = 0; i < m; ++i) {
        string s;
        int x;
        cin >> s >> x;
        mp[s] += x;
        sum += x;
    }
    double avg = sum * 1.0 / m;
    for (auto pr : mp) {
        string id = pr.first;
        int cnt = pr.second;
        if (subs.find(id) != subs.end()) continue;
        if (cnt > avg) ans.insert(id);
    }
    if (ans.empty()) puts("Bing Mei You");
    else {
        for (string s : ans) printf("%s\n", s.c_str());
    }

    return 0;
}