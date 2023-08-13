#include <cstdio>

using namespace std;

const int H[] = {129, 130}, W[] = {25, 27};
int n, gend, h, w;

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d%d%d", &gend, &h, &w);
        if (h < H[gend]) printf("duo chi yu! ");
        else if (h == H[gend]) printf("wan mei! ");
        else printf("ni li hai! ");
        if (w < W[gend]) puts("duo chi rou!");
        else if (w == W[gend]) puts("wan mei!");
        else puts("shao chi rou!");
    }

    return 0;
}