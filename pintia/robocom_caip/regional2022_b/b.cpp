#include <cstdio>

using namespace std;

char sex[5], name[20];

int main() {
    scanf("%s %s", sex, name);
    printf("%s %s Nin Hao Ya ~\n", name, sex[0] == 'M' ? "YeYe" : "NaiNai");

    return 0;
}