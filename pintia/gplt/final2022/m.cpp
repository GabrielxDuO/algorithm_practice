#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>
#include <queue>

using namespace std;

const int N = 100010;

int n;
unordered_map<string, int> dists;
unordered_map<string, vector<string>> g;

vector<string> get(string str) {
    vector<string> res;
    string word;
    for (auto c : str) {
        if (c == '.') {
            res.push_back(word);
            if (dists.find(word) == dists.end()) dists[word] = 0;
            word = "";
        } else word += c;
    }
    res.push_back(word);
    if (dists.find(word) == dists.end()) dists[word] = 0;
    return res;
}

vector<string> top_sort() {
    priority_queue<string, vector<string>, greater<string>> pq;
    for (auto& [k, v]: dists) {
        if (!v) pq.push(k);
    }
    vector<string> res;
    while (pq.size()) {
        auto t = pq.top();
        pq.pop();
        res.push_back(t);
        for (auto& u : g[t]) {
            if (--dists[u] == 0) pq.push(u);
        }
    }
    return res;
}

int main()
{
    scanf("%d", &n);
    char str[50];
    scanf("%s", str);
    auto last = get(str);

    for (int i = 0; i < n - 1; ++i) {
        scanf("%s", str);
        auto curr = get(str);
        if (last.size() == curr.size()) {
            for (int j = 0; j < curr.size(); ++j) {
                if (last[j] != curr[j]) {
                    g[last[j]].push_back(curr[j]);
                    ++dists[curr[j]];
                    break;
                }
            }
        }
        last = curr;
    }
    auto res = top_sort();
    printf("%s", res[0].c_str());
    for (int i = 1; i < res.size(); ++i) printf(".%s", res[i].c_str());

    return 0;
}