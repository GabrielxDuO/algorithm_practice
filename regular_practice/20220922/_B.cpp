#include <iostream>
#include <queue>
#include <unordered_map>

using namespace std;

string origin, target;
int n;

int bfs() {
    queue<string> que;
    unordered_map<string, int> mp;
    que.push(origin);
    while (!que.empty()) {
        string state = que.front();
        que.pop();
        int step = mp[state];
        if (state == target) return step;
        int pos = state.find('*');
        for (int offset = -3; offset <= 3; ++offset) {
            if (offset == 0) continue;
            int target_pos = pos + offset;
            if (target_pos >= 0 && target_pos < n) {
                swap(state[pos], state[target_pos]);
                if (mp.find(state) == mp.end()) {
                    mp[state] += step + 1;
                    que.push(state);
                }
                swap(state[pos], state[target_pos]);
            }
        }
    }
    return -1;
}

int main() {
    getline(cin, origin);
    getline(cin, target);
    n = origin.size();
    printf("%d\n", bfs());
    return 0;
}