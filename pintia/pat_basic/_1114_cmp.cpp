#include <cstdio>
#include <cstdlib>

using namespace std;

int main() {
    while (true) {
        system("./_1114_gen.o > _1114.in");
        system("./_1114_1.o < _1114.in > _1114_1.out");
        system("./_1114_2.o < _1114.in > _1114_2.out");
        if (system("diff ./_1114_1.out ./_1114_2.out")) break;
        // else puts("same");
        // getchar();
    }

    return 0;
}