#include <bits/stdc++.h>
using namespace std;
 
// 2023 OneWan
 
const int MAXM = 100000 + 5;
int s[MAXM], t[MAXM], p[MAXM], c[MAXM]; // 对应题目输入的各数组
multiset<long long> st[MAXM]; // st[i] 为 物品 i 在所有商店的价格
vector<vector<pair<int, int>>> v(MAXM); // v[i][j] 为 商店 i 出售的 第 j 个物品

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    cin >> n >> m;
    vector<int> time; // 用于离散化 时间
    for (int i = 0 ; i < m ; i++) {
        cin >> s[i] >> t[i] >> p[i] >> c[i];
        time.emplace_back(s[i]);
        time.emplace_back(t[i] + 1); // 打折是闭区间 所以需要+1才是没有打折截止
        for (int j = 0 ; j < c[i] ; j++) {
            int a, b; // 物品编号及原价
            cin >> a >> b;
            v[i].emplace_back(a, b);
        }
    }
    sort(time.begin(), time.end()); // 排序时间
    time.resize(unique(time.begin(), time.end()) - time.begin()); // 离散化时间
    auto get = [&](int t) {
        return lower_bound(time.begin(), time.end(), t) - time.begin();
    }; // 获取离散化后的下标
    int len = time.size();
    vector<vector<pair<int, int>>> startD(len), endD(len);
    // startD[i] 为 第 i 天 开始打折的物品编号 和 打折后的价格
    // endD[i] 为 第 i 天 结束打折的物品编号 和 打折后的价格
    for (int i = 0 ; i < m ; i++) {
        int starts = get(s[i]), ends = get(t[i] + 1); // 获取打折开始与结束时间离散化后的下标
        for (auto& [x, y] : v[i]) {
            int t = 1LL * y * p[i] / 100; // 打折后的价格
            st[x].insert(y); // 把物品原价放入
            startD[starts].emplace_back(x, t);
            endD[ends].emplace_back(x, t);
        }
    }
    long long temp = 0; // 用于存每天购买所有物品所用的价格
    for (int i = 1 ; i <= n ; i++) temp += *st[i].begin(); // 计算不进行打折时购买所有物品所用的价格
    long long ans = temp;
    for (int i = 0 ; i < len ; i++) {
        long long k = 0; // 打折与不打折对价格的贡献
        for (auto& [x, y] : startD[i]) { // 遍历当天所有开始打折的物品 打折前价格最小值为a, 打折后价格最小值为b, 贡献为b - a
            k -= *st[x].begin();
            st[x].insert(y);
            k += *st[x].begin();
        }
        for (auto& [x, y] : endD[i]) { // 遍历当天所有结束打折的物品 打折前价格最小值为a, 打折后价格最小值为b, 贡献为b - a
            k -= *st[x].begin();
            // int t = st[x].count(y);
            st[x].erase(st[x].find(y));
            // st[x].erase(y);
            // for (int j = 1 ; j < t ; j++) st[x].insert(y);
            k += *st[x].begin();
        }
        temp += k; // 加上贡献, 由前一段转移到后一段
        ans = min(ans, temp); // 找花费最小
    }
    cout << ans;
    return 0;
}