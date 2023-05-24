#include "testlib.h"
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char ** argv){
    registerInteraction(argc, argv);
    int n = inf.readInt();  // chosen integer
    cout.flush();   // to make sure output doesn't stuck in some buffer
    int left = 50;
    bool found = false;
    while(left > 0 && !found){
        left --;
        int a = ouf.readInt(1, 1000000000); // the number you tell me
        if(a < n)
            cout << -1 << endl;
        else if(a > n)
            cout << 1 << endl;
        else
            cout << 0 << endl, found = true;
        cout.flush();
    }
    if(!found)
        quitf(_wa, "couldn't guess the number with 50 questions");
    quitf(_ok, "guessed the number with %d questions!", 50 - left);

}