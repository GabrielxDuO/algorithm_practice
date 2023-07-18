#include <cstdio>

using namespace std;

const int STDD[][2] = {{129, 25}, {130, 27}};
int n;
int s, h, w;

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%d%d%d", &s, &h, &w);
        bool flag = false;
        if (h < STDD[s][0]) printf("duo chi yu! ");
        else if (h > STDD[s][0]) printf("ni li hai! ");
        else printf("wan mei! ");
        if (w < STDD[s][1]) printf("duo chi rou!\n");
        else if (w > STDD[s][1]) printf("shao chi rou!\n");
        else printf("wan mei!\n");
    }

    return 0;
}