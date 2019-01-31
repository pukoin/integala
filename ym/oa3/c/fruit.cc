#include "stdHeader.h"
using namespace std;
bool buy_fruit(const vector<vector<string>> & codeList,const vector<string>& shoppingCart)
{
        vector<string> all;
        for (const vector<string> & line : codeList)
        {
                for (const string & s : line)
                {
                        all.push_back(s);
                }
        }

        for (int i = 0; i < shoppingCart.size()-all.size() + 1; ++i)-baidu 1point3acres
        {
                int j = 0;
                while (j < all.size())
                {
                        if (shoppingCart[i+j] != all[j] && all[j] != "anything")
                        {
                                break;
                        }
                        ++j;
              }
                if (j == all.size())
                {
                        return true;
                }
        }
        return false;
}

void test_buy_fruit()
{
        cout << "=====================" << endl;
        cout << "test buy fruit" << endl;

        //check if v1+v2 is a subsequence(not necessarily continuous) in cart
        vector<string> v1{"apple","apple"};
        vector<string> v2{"orange","banana","orange" };
        vector<string> cart{ "orange", "apple", "apple", "orange", "banana", "orange" };
        vector<vector<string>> codelist;
        codelist.push_back(v1);
        codelist.push_back(v2);
        cout << buy_fruit(codelist, cart) << endl;

        v1.clear();
        v2.clear();
        cart.clear();
        codelist.clear();

        v1.push_back("orange");
        v1.push_back("banana");
        v1.push_back("orange");
        v2.push_back("apple");
        v2.push_back("apple");
        codelist.push_back(v1);
        codelist.push_back(v2);
        cart.push_back("orange");
        cart.push_back("apple");
        cart.push_back("apple");
        cart.push_back("orange");
        cart.push_back("banana");
        cart.push_back("orange");

        cout << buy_fruit(codelist, cart) << endl;

        v1.clear();
        v2.clear();
        cart.clear();
        codelist.clear();

        v1.push_back("apple");
        v1.push_back("apple");
        v2.push_back("orange");
        v2.push_back("anything");
        v2.push_back("orange");
        codelist.push_back(v1);
        codelist.push_back(v2);
        cart.push_back("orange");
        cart.push_back("apple");
        cart.push_back("apple");
        cart.push_back("orange");
        cart.push_back("mango");
        cart.push_back("orange");

        cout << buy_fruit(codelist, cart) << endl;
}