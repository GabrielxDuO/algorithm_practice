#include <bits/stdc++.h>

using namespace std;

const int DAYS[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

int main() {
    int month, day;
    scanf("%d%d", &month, &day);
    int date = DAYS[month - 1] + day;
    printf("%d", (date + 3) % 7 + 1);

    return 0;
}