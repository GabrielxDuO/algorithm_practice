#include <iostream>
#include <unordered_set>
#include <set>

using namespace std;

int n, m;
unordered_set<string> gone, bs;
set<string> ms, ns;
string s;
int x;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main() {
    cin >> n;
    while (n--) {
        cin >> s;
        gone.insert(s);
    }
    cin >> m;
    while (m--) {
        cin >> s;
        if (gone.find(s) != gone.end()) bs.insert(s);
        else ns.insert(s);
    }
    for (string ss : gone) {
        if (bs.find(ss) == bs.end()) ms.insert(ss);
    }
    if (!ms.size()) cout << "All Back" << '\n';
    else {
        cout << "Missing: " << ms.size() << '\n';
        for (string ss : ms) cout << ss << '\n';
    }
    if (!ns.size()) cout << "All Known" << '\n';
    else {
        cout << "New: " << ns.size() << '\n';
        for (string ss : ns) cout << ss << '\n';
    }

    return 0;
}