///交通信号
#include<bits/stdc++.h>
#include<bits/extc++.h>
#define ll long long
#ifndef LOCAL
    #define errmsg
#endif // LOCAL
using namespace std;

const int N=1e6+5;

struct pll{
    long long dis;
    int id;
    pll(){}
}t_pll;

bool operator <(const pll &A,const pll &B){
    return A.dis==B.dis?A.id>B.id:A.dis>B.dis;
}

typedef __gnu_pbds::priority_queue<pll> heap;


int to[N],red[N],green[N],len[N],rev[N];

long long dis[N];
heap::point_iterator its[N];
int out[N];
vector<vector<int>>G;
heap Q;

//debug
//int from[N];
//int eid[N];

long long dij(int s,int t){
    memset(dis,0x7f,sizeof(dis));
    memset(out,0,sizeof(out));
    Q.clear();

    dis[s]=0;
    t_pll.dis=0; t_pll.id=s;
    Q.push(t_pll);
    out[s]=1;

//    from[s]=0;

    while(!Q.empty()){
        pll tmp=Q.top(); Q.pop();
        int u=tmp.id;
        printf("%d\n", u);
        out[u]=2;
        if(u==t)break;
        for(auto&e:G[u]){
            if(out[to[e]]==2)continue;
            long long ds=dis[u]+len[e];
            long long md=dis[u]%(red[e]+green[e]+len[e]*2ll);
            if(rev[e])md=(dis[u]-red[e]-len[e])%(red[e]+green[e]+len[e]*2ll);
            if(md<0)ds+=-md;
            if(md>=green[e])ds+=(red[e]+green[e]+len[e]*2ll)-md;
            if(dis[to[e]]>ds){
                dis[to[e]]=ds;
                t_pll.dis=ds; t_pll.id=to[e];
                if(!out[to[e]]){
                    its[to[e]]=Q.push(t_pll);
                } else if(out[to[e]]==1) {
                    Q.modify(its[to[e]],t_pll);
                }
//                from[to[e]]=u;
//                eid[to[e]]=e;
            }
            out[to[e]]=1;
        }
    }
    if(dis[t]<1e18){
/*
        errmsg("*****\n");
        int len=0;
        for(int i=t;i;i=from[i]){
            errmsg("%d %d\n",i,eid[i]);
            ++len;
        }
        errmsg("*****\n");
        errmsg("length:%d\n",len);
        errmsg("*****\n");
*/

        return dis[t];
    }
    return -1;
}

int main(){
    // 标准输入流重定向
    freopen("g.in", "r", stdin);
    freopen("g.out1", "w", stdout);

    int n,m,s,t;
    scanf("%d%d%d%d",&n,&m,&s,&t);
    // if (n == 100000) {
    //     return 0;
    // }
    assert(n<=1e5); assert(m<=2e5);
    assert(s>=1&&s<=n);
    assert(t>=1&&t<=n);

    {
        vector<vector<int>>tmp(n+3);
        swap(tmp,G);
    }

    for(int i=1,a,b,c,d,e;i<=m;++i){
        scanf("%d%d%d%d%d",&a,&b,&c,&d,&e);

        assert(a>=1&&a<=n);
        assert(b>=1&&b<=n);
        assert(c>=1&&c<=1e9);
        assert(d>=1&&d<=1e9);
        assert(e>=1&&e<=1e9);

        to[i]=b; green[i]=c; red[i]=d; len[i]=e; rev[i]=0;
        to[i+m]=a; green[i+m]=d; red[i+m]=c; len[i+m]=e; rev[i+m]=1;
        G[a].push_back(i); G[b].push_back(i+m);
    }

    printf("%lld\n",dij(s,t));

    return 0;
}
