#include <bits/stdc++.h>

using namespace std;

const int DAYS[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

int main() {
    int m1, d1, m2, d2;
    scanf("%d%d%d%d", &m1, &d1, &m2, &d2);
    int date1 = DAYS[m1 - 1] + d1;
    int date2 = DAYS[m2 - 1] + d2;
    printf("%d\n", date2 - date1);

    return 0;
}