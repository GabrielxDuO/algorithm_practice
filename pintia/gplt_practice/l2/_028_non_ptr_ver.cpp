#include <cstdio>
#include <cstdlib>
#include <vector>
#include <set>
#include <unordered_map>

using namespace std;

const int N = 1010, K = 510;
int n, m, k;
char s[10];
double w[N][N];
bool sex[N];
unordered_map<int, vector<int>> mp;
set<int> mxs_A, mxs_B;
int A, B;

int main() {
    scanf("%d%d", &n, &m);
    vector<vector<int>> vecs(m, vector<int>());
    for (int i = 0; i < m; ++i) {
        scanf("%d", &k);
        while (k--) {
            scanf("%s", s);
            int x = abs(atoi(s));
            sex[x] = s[0] != '-';
            vecs[i].push_back(x);
            mp[x].push_back(i);
        }
    }
    scanf("%d%d", &A, &B);
    A = abs(A), B = abs(B);
    for (auto& idx : mp[A]) {
        k = vecs[idx].size();
        for (int x : vecs[idx]) {
            if (A != x && (sex[A] ^ sex[x])) {
                w[A][x] += 1.0 / k;
            }
        }
    }
    for (auto& idx : mp[B]) {
        k = vecs[idx].size();
        for (int x : vecs[idx]) {
            if (B != x && (sex[B] ^ sex[x])) {
                w[B][x] += 1.0 / k;
            }
        }
    }
    double mx = 0.0;
    for (int i = 0; i < n; ++i) {
        if (A != i && (sex[A] ^ sex[i])) mx = max(mx, w[A][i]);
    }
    for (int i = 0; i < n; ++i) {
        if (A != i && (sex[A] ^ sex[i]) && w[A][i] == mx) mxs_A.insert(i);
    }
    mx = 0.0;
   for (int i = 0; i < n; ++i) {
        if (B != i && (sex[B] ^ sex[i])) mx = max(mx, w[B][i]);
    }
    for (int i = 0; i < n; ++i) {
        if (B != i && (sex[B] ^ sex[i]) && w[B][i] == mx) mxs_B.insert(i);
    }
    if (mxs_A.find(B) != mxs_A.end() && mxs_B.find(A) != mxs_B.end()) {
        printf(sex[A] ? "%d -%d\n" : "-%d %d\n", A, B);
        return 0;
    }
    for (auto& x : mxs_A) printf(sex[A] ? "%d -%d\n" : "-%d %d\n", A, x);
    for (auto& x : mxs_B) printf(sex[B] ? "%d -%d\n" : "-%d %d\n", B, x);

    return 0;
}