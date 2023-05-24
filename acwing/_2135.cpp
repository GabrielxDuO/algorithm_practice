#include <iostream>

using namespace std;

const int DICT[][5] = {{0, 3, 2, 3, 2},
                       {3, 2, 1, 2, 3},
                       {2, 1, 4, 3, 2},
                       {3, 2, 3, 2, 3},
                       {2, 3, 2, 3, 4}};
int xp, yp, xs, ys;

int main() {
    scanf("%d%d%d%d", &xp, &yp, &xs, &ys);
    int dx = abs(xp - xs), dy = abs(yp - ys);
    int step = 0;
    while (dx > 4 || dy > 4) {
        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;
        if (dx > dy) {
            dx -= 2;
            --dy;
        } else {
            dy -= 2;
            --dx;
        }
        ++step;
    }
    printf("%d\n", step + DICT[dx][dy]);
    
    return 0;
}