#include <cstdio>
#include <cstdlib>
#include <ctime>

using namespace std;

int M[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

bool is_leap(int yy) {
    return yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0;
}

int main() {
    srand(time(NULL));
    int yy = rand() % 9999 + 1;
    int mm = rand() % 12 + 1;
    if (mm == 2 && is_leap(yy)) ++M[2];
    int dd = rand() % M[mm] + 1;
    printf("%04d%02d%02d\n", yy, mm, dd);

    return 0;
}