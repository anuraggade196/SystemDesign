#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cout << "Enter number of nodes: ";
    cin >> n;

    vector<int> tree(n);

    cout << "Enter node values (level order):\n";
    for (int i = 0; i < n; i++) {
        cin >> tree[i];
    }

    cout << "\nBinary Tree (Array Representation)\n";
    for (int i = 0; i < n; i++) {
        cout << "Node: " << tree[i] << " at index " << i;

        if (2 * i + 1 < n)
            cout << " | Left Child: " << tree[2 * i + 1];
        else
            cout << " | Left Child: NULL";

        if (2 * i + 2 < n)
            cout << " | Right Child: " << tree[2 * i + 2];
        else
            cout << " | Right Child: NULL";

        cout << endl;
    }

    return 0;
}
