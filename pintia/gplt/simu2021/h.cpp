#include <cstdio>

using namespace std;

const int N = 1010;
int n;
int tots[N];

int main() {
    scanf("%d", &n);
    int id, score;
    int mx = -1, mx_id = -1;
    while (n--) {
        scanf("%d-%*d %d", &id, &score);
        if ((tots[id] += score) > mx) mx = tots[id], mx_id = id;
    }
    printf("%d %d\n", mx_id, mx);

    return 0;
}