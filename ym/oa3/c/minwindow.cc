#include "stdHeader.h"
using namespace std;

. From 1point 3acres bbsbool cover(unordered_map<string, int>& sm, unordered_map<string, int>& tm)
{
        for (auto x : tm)
        {
                if (!sm.count(x.first) || sm[x.first]<x.second)
                        return false;
        }
        return true;
}

vector<int> minWindow(vector<string> s, vector<string> t) {
        unordered_map<string, int> tm;
        unordered_map<string, int> sm;

        for (auto c : t)
        {
                tm[c]++;
        }

        int start = 0;
        int j = 0;
        int len = INT_MAX;

        for (int i = 0; i<s.size(); ++i)
        {
                string c = s[i];
                sm[c]++;
                while (j <= i && cover(sm, tm))
                {
                        if (i - j + 1<len) {. From 1point 3acres bbs
                                len = i - j + 1;
                                start = j;
                        }
                        sm[s[j]]--;
                        ++j;
                }
        }

        vector<int> ans;
        ans.push_back(start);
        ans.push_back(start + len - 1);

        if (len == INT_MAX)
        {
                vector<int> tmp;
                tmp.push_back(0);
                return tmp;
        }
        else
        {
                return ans;
        }
}

void test_minWindow()
{
        //LeetCode 76 minimum subsequence window
        cout << "=====================" << endl;
        cout << "test min tag" << endl;
        vector<string> desired = { "made", "in", "spain" };
        vector<string> available = { "made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays" };
        vector<int> p = minWindow(available, desired);

        for (int x : p)
        {
                cout << x << " ";
        }
        cout << endl;
}