#include "stdHeader.h"
using namespace std;

vector<int> charPartition(const vector<char>& v)
{
        vector<int> index;
        for (int i = 0; i < v.size(); ++i)
        {
                unordered_set<char> m;. 1point3acres
                for (int j = 0; j <= i; ++j)
                {
                        m.insert(v[j]);
                }

                bool found = false;
                for (int j = i + 1; j < v.size(); ++j)
                {
                        if (m.count(v[j])) {
                                found = true;
                                break;
                        }
                }

                if (!found)
                {
                        index.push_back(i);
                }
        }

        vector<int> ans;
        ans.push_back(index[0]+1);

        for (int i = 1; i < index.size(); ++i)
        {
                ans.push_back(index[i] - index[i - 1]);
        }

        return ans;
}

void test_char_partition()
{
        //find largest number of partitions such that no substr has overlap chars
        cout << "=====================" << endl;
        cout << "test char partition" << endl;

        string s = "ababcbacadefegdehijhklij";
        vector<char> v(s.begin(), s.end());
        vector<int> ans = charPartition(v);
        algo::printv(ans);

        s = "abcdaefghij";
        vector<char> v2(s.begin(), s.end());
        ans = charPartition(v2);
        algo::printv(ans);
}