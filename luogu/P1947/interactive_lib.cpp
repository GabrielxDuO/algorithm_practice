#include <cstdio>
#include <iostream>

int k, cnt;

extern "C" {
  extern int Chtholly(int n, int c);
    
  extern int Seniorious(int x) {
    const int lim = 3000000;
    if(++cnt > lim) cnt = lim;
    return (k < x) ? 1 : ((k == x) ? 0 : -1);
  }
  
}
int main() {
  int n, c;
  std::cin >> n >> c >> k;
  int OvO = Chtholly(n, c);
  std::cout << OvO << ' ' << cnt << std::endl;
  return 0;
}