#include<bits/stdc++.h>
#define ll long long
using namespace std;
const unsigned mod=1e9+7;
ll ksm(ll x,ll y){ll ret=1;while(y){if(y&1ll)ret=ret*x%mod;y>>=1ll;x=x*x%mod;}return ret;}//快速幂模板
ll n,m,k,a[200010],cnt[200010],fac[200010],inv[200010];
ll C(ll n,ll m){if(m>n||m<0)return 0;return fac[n]*inv[m]%mod*inv[n-m]%mod;}//组合数模板
int main() 
{
    ios::sync_with_stdio(0);
    cin.tie(0),cout.tie(0);//关闭流同步
    fac[0]=inv[0]=1;
    for(int i=1;i<=200000;i++) fac[i]=fac[i-1]*i%mod;
    for(int i=1;i<=200000;i++) inv[i]=ksm(fac[i],mod-2);//预处理组合数
    int T;cin>>T;
    while(T--)
    {
        cin>>n>>m>>k;
        for(int i=1;i<=n;i++) cin>>a[i],cnt[a[i]]++;
        for(int i=1;i<=n;i++) cnt[i]+=cnt[i-1];//前缀和
        sort(a+1,a+n+1);//排序
        ll ans=0;
        for(int i=n;i>=1;i--)
        {
            if (a[i]>k) ans+=C(i-cnt[a[i]-k-1]-1,m-1),ans%=mod;//组合数计算
            else ans+=C(i-1,m-1),ans%=mod;//为避免负下标RE而进行的特判
        }
        cout<<ans<<'\n';
        for(int i=1;i<=n;i++) cnt[i]=0;//多测记得要清零，不建议用memset
    }
    return 0;
}