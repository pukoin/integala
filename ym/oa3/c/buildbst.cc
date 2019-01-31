#include "stdHeader.h"
using namespace std;
struct Node
{
        Node() = default;
        Node(int x) :val(x) { };
        Node* left{ nullptr };
        Node* right{ nullptr };
        int val{ 0 };
};

void inorder(Node* r)
{
        if (!r) return;
        inorder(r->left);
        std::cout << "inorder " << r->val << std::endl;
        inorder(r->right);
}

Node* build_BST(const vector<int> &array)
{
        Node* root = nullptr;

        for (int i = 0; i < array.size(); ++i)
        {
                if (!root)
                {
                        root = new Node(array[i]);
                }
                else
                {
. From 1point 3acres bbs                        Node *cpy = root;
                        while (true)
                        {
                                if (array[i] < cpy->val)
                                {
                                        if (cpy->left)
                                                cpy = cpy->left;
                                        else
                                        {
                                                cpy->left = new Node(array[i]);
                                                break;
                                        }
                                }
                                else
                                {
                                        if (cpy->right)
                                                cpy = cpy->right;
                                        else
                                        {
                                                cpy->right = new Node(array[i]);
                                                break;
                                        }
                                }
                        }
                }
        }

        return root;
}

int distance(Node* root, int a, int b)
{
        Node* cpy = root;
        unordered_set<Node*> m;

        while (cpy != nullptr)
        {
                m.insert(cpy);
                if (cpy->val > a)
                {
                        cpy = cpy->left;
                }
                else if (cpy->val < a)
                {
                        cpy = cpy->right;
                }
                else
                {
                        break;
                }
        }

        cpy = root;
        while (cpy != nullptr)
        {
                if (m.count(cpy))
                {
                        m.erase(cpy);
                }
                else
                {
                        m.insert(cpy);
                }

                if (cpy->val > b)
                {
                        cpy = cpy->left;
                }
                else if (cpy->val < b)
                {
                        cpy = cpy->right;. 1point3acres
                }
                else                {
                        break;
                }
        }

        return m.size();
}

void test_BST()
{        cout << "=====================" << endl;
        cout << endl;
        cout << "test BST" << endl;
        vector<int> array = { 5,2,1,9,8,10,4,12,11,3,6,7 };
        //construct a BST
        Node* r = build_BST(array);
        inorder(r);
        //find distance of two nodes
        int x = distance(r, 1, 3);
        cout << "3->12 " << x << endl;
}