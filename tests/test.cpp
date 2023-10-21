#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cstring>
#include<cmath>
#include<queue>
using namespace std;
const int N=2e5;
struct segment
{
    int l,r;
    segment() {}
    bool operator < (const segment &x) const {return l==x.l?r<x.r:l<x.l;}
}a[N+10];
int c1[N*2+10],c2[N*2+10],n,m,t[N*2+10];
void modify(int *c,int x,int d) {for(;x<=m;x+=x&-x) c[x]+=d;}
int query(int *c,int x)
{
    int ans=0;
    for(;x;x-=x&-x) ans+=c[x];
    return ans;
}
int main()
{
    int T;
    scanf("%d",&T);
    while(T--)
    {
        int n;
        scanf("%d",&n);
        for(int i=1;i<=n;i++)
        {
            scanf("%d %d",&a[i].l,&a[i].r);
            t[i*2-1]=a[i].l;
            t[i*2]=a[i].r;
        }
        sort(a+1,a+n+1);
        sort(t+1,t+n*2+1);
        m=unique(t+1,t+n*2+1)-t-1;
        for(int i=0;i<=m;i++)
        {
            c1[i]=0;
            c2[i]=0;
        }
        for(int i=1;i<=n;i++)
        {
            a[i].l=lower_bound(t+1,t+m+1,a[i].l)-t;
            a[i].r=lower_bound(t+1,t+m+1,a[i].r)-t;
        }
        int ans=0;
        for(int i=1;i<=n;i++) modify(c2,a[i].l,1);
        for(int i=1;i<=n;i++)
        {
            if (i == n) {
                printf("%d - %d\n", query(c1,m), query(c1,a[i].l-1));
            }
            int lc = query(c1,m)-query(c1,a[i].l-1);
            int rc = query(c2,a[i].r)-query(c2,a[i].l-1);
            printf("%d %d\n", lc, rc);
            ans=max(ans,lc+rc);
            modify(c2,a[i].l,-1);
            modify(c1,a[i].r,1);
        }
        printf("%d\n",n-ans);
    }
    return 0;
}