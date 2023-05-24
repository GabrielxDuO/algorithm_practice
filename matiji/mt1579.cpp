#include <bits/stdc++.h>

using namespace std;

struct Frac {
    int nume, deno;
    
    Frac operator+(const Frac& fr) {
        return {nume * fr.deno + fr.nume * deno, deno * fr.deno};
    }

    Frac operator-(const Frac& fr) {
        Frac tmp = {-fr.nume, fr.deno};
        return *this + tmp;
    }

    Frac operator*(const Frac& fr) {
        return {nume * fr.nume, deno * fr.deno};
    }

    Frac operator/(const Frac& fr) {
        Frac tmp = {fr.deno, fr.nume};
        return *this * tmp;
    }

    void reduct() {
        int gcd = __gcd(nume, deno);
        nume /= gcd;
        deno /= gcd;
        if (deno < 0) {
            nume = -nume;
            deno = -deno;
        }
    }

    void println() {
        reduct();
        if (deno == 1) printf("%d\n", nume);
        else printf("%d/%d\n", nume, deno);
    }
};

int main() {
    Frac a, b;
    scanf("%d %d %d %d", &a.nume, &a.deno, &b.nume, &b.deno);
    (a + b).println();
    (a - b).println();
    (a * b).println();
    (a / b).println();

    return 0;
}