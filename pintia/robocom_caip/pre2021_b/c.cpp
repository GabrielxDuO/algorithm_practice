#include <cstdio>
#include <unordered_map>

using namespace std;

const char M[][30] = {"", "January", "February", "March", "April", "May",
              "June", "July", "August", "September", "October", "November", "December"};
int x;

int main() {
    while (~scanf("%d", &x)) {
        if (x >= 1 && x <= 12) printf("%s\n", M[x]);
        else {
            puts("?");
            return 0;
        }
    }

    return 0;
}