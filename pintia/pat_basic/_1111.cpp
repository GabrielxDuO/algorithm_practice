#include <iostream>
#include <unordered_map>
#include <cstring>
#include <algorithm>

using namespace std;

unordered_map<string, int> M;
int n;
char dt[20], dt_rev[20];

void init() {
    M["Jan"] = 1;
    M["Feb"] = 2;
    M["Mar"] = 3;
    M["Apr"] = 4;
    M["May"] = 5;
    M["Jun"] = 6;
    M["Jul"] = 7;
    M["Aug"] = 8;
    M["Sep"] = 9;
    M["Oct"] = 10;
    M["Nov"] = 11;
    M["Dec"] = 12;
}

int main() {
    cin >> n;
    init();
    string sm, ign;
    int d, y;
    while (n--) {
        cin >> sm >> d >> ign >> y;
        int m = M[sm];
        sprintf(dt, "%04d%02d%02d", y, m, d);
        strcpy(dt_rev, dt);
        int len = strlen(dt);
        reverse(dt_rev, dt_rev + len);
        printf(strcmp(dt, dt_rev) ? "N" : "Y");
        printf(" %s\n", dt);
    }

    return 0;
}