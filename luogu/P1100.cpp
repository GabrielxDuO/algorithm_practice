#include <cstdio>

using namespace std;

unsigned int x;

int main() {
    scanf("%u", &x);
    printf("%u\n", (x << 16) | (x >> 16));

    return 0;
}