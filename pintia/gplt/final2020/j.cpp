#include <cstdio>
#include <iostream>
#include <cctype>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int d, p, t, s;
struct Info {
    string name, id, time;
    int cond, order;

    bool operator<(const Info& o) const {
        if (time != o.time) return time < o.time;
        return order < o.order;
    }

    friend ostream& operator<<(ostream& out, const Info& o) {
        out << o.name << " " << o.id;
        return out;
    }
};
vector<Info> infos;
unordered_map<string, int> last;
unordered_set<string> ills_vis;
vector<Info> ills;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

bool check_date(const string& id) {
    if (id.size() != 18) return false;
    for (const char& c : id) {
        if (!isdigit(c)) return false;
    }
    return true;
}

bool check_last(const string& id, const int& day) {
    return last.find(id) == last.end() || day >= last[id] + p + 1;
}

int main() {
    cin >> d >> p;
    for (int k = 1; k <= d; ++k) {
        cin >> t >> s;
        infos.clear();
        for (int i = 0; i < t; ++i) {
            Info info;
            cin >> info.name >> info.id >> info.cond >> info.time;
            if (!check_date(info.id)) continue;
            if (info.cond && ills_vis.find(info.id) == ills_vis.end()) {
                ills_vis.insert(info.id);
                ills.push_back(info);
            }
            info.order = i;
            infos.push_back(info);
        }
        sort(infos.begin(), infos.end());
        int j = 0;
        for (auto info : infos) {
            if (check_last(info.id, k)) {
                if (j++ >= s) break;
                cout << info << '\n';
                last[info.id] = k;   
            }
        }
    }
    for (auto info : ills) cout << info << '\n';

    return 0;
}