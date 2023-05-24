extern "C" int Seniorious(int);

extern "C" int Chtholly(int n, int c) {
    int l = 1, r = n;
    while (l < r) {
        int m = l + r >> 1;
        if (Seniorious(m) >= 0) r = m;
        else l = m + 1;
    }
    return l;
}