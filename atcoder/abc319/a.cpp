#include <cstdio>
#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<string, int> mp;

int main() {
    mp["tourist"] = 3858;
    mp["ksun48"] = 3679;
    mp["Benq"] = 3658;
    mp["Um_nik"] = 3648;
    mp["apiad"] = 3638;
    mp["Stonefeang"] = 3630;
    mp["ecnerwala"] = 3613;
    mp["mnbvmar"] = 3555;
    mp["newbiedmy"] = 3516;
    mp["semiexp"] = 3481;
    string s; cin >> s;
    cout << mp[s] << '\n';

    return 0;
}