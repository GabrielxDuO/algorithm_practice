#include <bits/stdc++.h>
using namespace std;
using LL = long long;
 
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    LL p;
    cin >> n >> m >> p;
    vector<LL> a(n), b(m);
    vector<LL> sumb(m);
    for (auto& i : a)
        cin >> i;
    for (auto& i : b)
        cin >> i;
    sort(b.begin(), b.end());
    for (auto& x : b) printf("%d ", x);
        puts("");
    partial_sum(b.begin(), b.end(), sumb.begin());
    LL ans = 0;
    for (auto& i : a) {
        LL r = p - i;
        auto cnt = lower_bound(b.begin(), b.end(), r) - b.begin();
        ans += 1ll * i * cnt + (cnt ? sumb[cnt - 1] : 0) + 1ll * p * (m - cnt);
        cout << cnt << "\n";
    }
    cout << ans << '\n';
 
    return 0;
}
 