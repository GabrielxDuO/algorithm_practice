#include <cstdio>
#include <iostream>
#include <unordered_set>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
unordered_set<string> st;

int main() {
    scanf("%d\n", &n);
    while (n--) {
        string s;
        getline(cin, s);
        st.insert(s);
    }
    scanf("%d\n", &m);
    while (m--) {
        string s;
        getline(cin, s);
        auto it = st.find(s);
        if (it != st.end()) st.erase(it);
    }
    vector<string> vec;
    for (auto s : st) vec.push_back(s);
    sort(vec.begin(), vec.end(), [](const string& a, const string& b) { return a > b; });
    for (auto& s : vec) printf("%s\n", s.c_str());
    
    return 0;
}