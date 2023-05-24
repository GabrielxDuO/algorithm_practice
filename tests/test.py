
 
n,m,s,t=map(int,input().split())
from queue import PriorityQueue
class line():
    def __init__(self,v,g,r,d,vis,ne):
        self.v=v
        self.r = r
        self.g = g
        self.d = d
        self.z=vis
        self.ne=ne
class pair():
    def __init__(self,v,w):
 
        self.v=v
        self.w = w
 
    def __lt__(self, other):
        return self.w<other.w
 
 
 
h=[0 for i in range(n+1)]
l=[0,0]
cnt=2
 
for i in range(m):  #链式前向星存图
 
    u, v, g, r, d =map(int,input().split())
 
 
    l.append(line(v,g,r,d,1,h[u]))
    h[u] = cnt
    cnt += 1
 
    l.append(line(u,g,r,d,-1,h[v]))
    h[v] = cnt
    cnt += 1
 
"""print(l[-1].d)"""
def diji(s):
    global dis
    que=PriorityQueue()
    dis=[float("inf") for i in range(n+1)]
    vis=[True for i in range(n+1)]
    dis[s]=0
    que.put(pair(s,0))
    while que.qsize():
        mid=que.get()
        u=mid.v
        if (vis[u]==False):continue
        vis[u] = False
        """if (mid.w!=dis[u]):continue"""
        ind=h[u]
        while ind!=0:
            #print(u,ind)
            mid=l[ind]
            if (mid.z==1): #先看一看这个边是红灯通行（z=-1）还是绿灯通行（z=1）
                #print(dis[u])
                c= dis[u] % (mid.r + mid.g + mid.d * 2)  #再算一下处于哪个信号的时间段（模一下信号周期）
 
                if (c>=0 and c<mid.g):  #算等待时间
                    c=0
                else :
                    c=(mid.r + mid.g + mid.d * 2)-c
                if (dis[mid.v]>=dis[u]+c+mid.d): #维护最小值
                    dis[mid.v] = dis[u] + c + mid.d
                    que.put(pair(mid.v,dis[mid.v]))
            if (mid.z==-1):  #同上
                c= dis[u] % (mid.r + mid.g + mid.d * 2)
                if (c>=(mid.g+mid.d) and c<(mid.g+mid.d+mid.r)):
                    c=0
                elif(c>=0 and  c< (mid.g+mid.d)):
                    c=((mid.g+mid.d))-c
                else:
                    c=(mid.r + mid.g*2 + mid.d * 3)-c
                if (dis[mid.v]>=dis[u]+c+mid.d):
                    dis[mid.v] = dis[u] + c + mid.d
                    que.put(pair(mid.v,dis[mid.v]))
            ind=l[ind].ne
 
 
diji(s)
if (dis[t]==float("inf")):
    print(-1)
else:
    print(dis[t])
 
 
"""a=pair(0,1)
b=pair(0,2)
l=PriorityQueue()
l.put(a)
l.put(b)
a=l.get()
b=l.get()
print(a.w,b.w)"""
 
 
 
