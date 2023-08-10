#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    int a, b;
    scanf("%d%d", &a, &b);
    int c = a * b;
    string s = to_string(c);
    reverse(s.begin(), s.end());
    printf("%d\n", stoi(s));

    return 0;
}