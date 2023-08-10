#include <cstdio>

using namespace std;

int main() {
    int hh, mm;
    scanf("%d:%d", &hh, &mm);
    int x = hh + (bool) mm;
    if (x <= 12) printf("Only %02d:%02d.  Too early to Dang.", hh, mm);
    else {
        x -= 12;
        while (x--) printf("Dang");
    }

    return 0;
}