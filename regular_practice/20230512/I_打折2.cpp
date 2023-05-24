#include<bits/stdc++.h>
//#pragma GCC optimize(3)
#define endl "\n"
#define int long long
#define pii pair<int,int>
#define pll pair<long long,long long>
#define fi first
#define sc second
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
const int inf32 = 0x3f3f3f3f;
const ll inf64 = 0x3f3f3f3f3f3f3f3f;
const double pi = acos(-1),eps = 1e-7;
mt19937 rnd(time(0));
const int maxn = 1*1e5+10,maxm = 8*1e7+10,mod = 1e9+7;

int n,m;
int val[maxn];
namespace bit{
    int tr[maxn];
    int lowbit(int x){
        return x&(-x);
    }
    void modify(int x,int d){
        while(x <= n){
            tr[x] += d;
            x += lowbit(x);
        }
    }
    int query(int x){
        int res = 0;
        while(x){
            res += tr[x];
            x -= lowbit(x);
        }
        return res;
    }
}
struct node{
    int t,p,q,id;
};
bool cmp(node &a, node &b){
    return a.t < b.t;
}
vector<node> v;
multiset<int> se[maxn];
int solve(){
    vector<int> tim;
    sort(v.begin(),v.end(),cmp);
    for(int i = 0;i < v.size();i++){
        if(i == 0 || v[i].t != v[i-1].t) tim.push_back(v[i].t);
    }
    for(int i = 1;i <= n;i++){
        val[i] = *se[i].begin();
        bit::modify(i,val[i]);
    }
    int res = bit::query(n);
    int idx = 0;
    for(int t : tim){
        while(idx < v.size() && v[idx].t == t){
            int p = v[idx].p,q = v[idx].q,id = v[idx].id;
            bit::modify(id,-val[id]);
            se[id].erase(se[id].find(p));
            se[id].insert(q);
            val[id] = *se[id].begin();
            bit::modify(id,val[id]);
            idx++;
        }
        res = min(res,bit::query(n));
    }
    return res;
}

signed main(){
    ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    //freopen("in.in","r",stdin);
    //freopen("out.out","w",stdout);
    cin>>n>>m;
    for(int i = 1;i <= m;i++){
        int s,t,p,cnt;
        cin>>s>>t>>p>>cnt;
        for(int j = 1;j <= cnt;j++){
            int a,b;
            cin>>a>>b;
            se[a].insert(b);
            int q = b*p/100;
            v.push_back({s,b,q,a});
            v.push_back({t+1,q,b,a});
        }
    }
    cout<<solve()<<endl;
    return 0;
}