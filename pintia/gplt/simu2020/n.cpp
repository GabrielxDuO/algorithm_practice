#include <cstdio>
#include <iostream>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int ptr, space = 2, mark, tp, cnt, use, temp;
string s;

void trim() {
    while (s[ptr] == ' ') ++ptr;
}

void indent() {
    for (int i = 0; i < space; ++i) cout << ' ';
}

int judge() {
    if (s.substr(ptr, 2) == "if" && (s[ptr + 2] == '(' || s[ptr + 2] == ' ')) return 2;
    if (s.substr(ptr, 3) == "for" && (s[ptr + 3] == '(' || s[ptr + 3] == ' ')) return 3;
    if (s.substr(ptr, 4) == "else" && (s[ptr + 4] == '(' || s[ptr + 4] == ' ')) return 4;
    if (s.substr(ptr, 5) == "while" && (s[ptr + 5] == '(' || s[ptr + 5] == ' ')) return 5;
    return 0;
}

void end() {
    trim();
    if (judge() == 4) return;
    while (mark) {
        space -= 2;
        indent();
        cout << "}\n";
        --mark;
    }
}

int main() {
    getline(cin, s);
    trim();
    for (int i = ptr; s[i] != ')'; i++) cout << s[i];
    cout << ")\n{\n";
    ptr = s.find('{') + 1;
    while (1) {
        trim();
        temp = judge();
        if (s[ptr] == '{') {
            indent();
            cout << "{\n";
            space += 2;
            ptr++;
        } else if (s[ptr] == '}') {
            space -= 2;
            indent();
            cout << "}\n";
            if (space == 0) return 0;
            end();
            ptr++;
        } else if (temp) {
            indent();
            cout << s.substr(ptr, temp);
            ptr += temp;
            if (temp != 4) {
                trim();
                tp = ptr;
                cnt = 0;
                while(tp < s.size()) {
                    if (s[tp] == '(') cnt++;
                    else if (s[tp] == ')') cnt--;
                    tp++;
                    if (cnt == 0) break;
                }
                cout << ' ' << s.substr(ptr, tp - ptr);
                ptr = tp;
            }
            cout <<  " {\n";
            space += 2;
            trim();
            if (s[ptr] != '{') {
                use = 1;
                mark++;
            } else {
                use = 0;
                ptr++;
            }
        } else {
            indent();
            cnt = s.find(';', ptr);
            cout << s.substr(ptr, cnt - ptr + 1) << '\n';
            ptr = cnt + 1;
            if (use && mark) {
                space -= 2;
                indent();
                cout << "}\n";
                mark--;
                end();
            }
        }
    }
    
    return 0;
}