#include <cstdio>
#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

const int N = 1e5 + 10;
int n;
struct Info {
    string name;
    int cnt;
    double avg = 0.0;

    bool operator<(const Info& o) const {
        if (cnt != o.cnt) return cnt > o.cnt;
        return avg < o.avg;
    }
} infos[N];
unordered_map<int, int> mp;

int main() {
    cin >> n;
    int k, x;
    for (int i = 0; i < n; ++i) {
        cin >> infos[i].name >> k;
        mp.clear();
        while (k--) {
            cin >> x;
            if (++mp[x] == 1) {
                ++infos[i].cnt;
            }
        }
        for (auto [_, s] : mp) infos[i].avg += s;
        infos[i].avg /= mp.size();
    }
    sort(infos, infos + n);
    for (int i = 0; i < min(n, 3); ++i) {
        if (i) cout << ' ';
        cout << infos[i].name;
    }
    for (int i = min(n, 3); i < 3; ++i) {
        if (i) cout << ' ';
        cout << '-';
    }
    puts("");

    return 0;
}