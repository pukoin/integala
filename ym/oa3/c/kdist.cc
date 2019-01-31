#include<vector>
#include<stdlib>
#include<iostream>
using namespace std;
bool is_unique(const string&s)
{
        unordered_set<char> m;
        for (char c : s)
        {
                if (m.count(c)) {
                        return false;
                }
                m.insert(c);
        }
        return true;
}

vector<string> k_distinct(const string &s, int k)
{
        vector<string> ans;
        for (int i = 0; i < s.size() - k +1; ++i)
        {
                if (is_unique(s.substr(i, k)))
                {
                        ans.push_back(s.substr(i, k));
                }
        }
        
        return ans;
}
vector<string> k_distinct_2(const string &s, int k)
{
        vector<string> ans;
        unordered_map<char, int> m;
        if (s.size() < k) return ans;

        for (int i = 0; i < k; ++i)
        {
                m[s[i]]++;
        }

        if (m.size() == k) {
                ans.push_back(s.substr(0, k));
        }

        for (int i = k; i < s.size(); ++i)
        {
                int j = i - k;
                m[s[i]]++;
                m[s[j]]--;
                if (m[s[j]] == 0) {
                        m.erase(s[j]);
                }
                if (m.size() == k)
                {
                        ans.push_back(s.substr(i - k + 1, k));
                }
        }

        return ans;
}

void printv(vector<string> &v)
{
        for (auto x : v)
        {
                cout << x << ",";
        }
        cout << endl;
}
void test_k_distinct()
{
        //to find substr of size k with all chars distinct.
        cout << "=====================" << endl;
        cout << "test k distinct using two method" << endl;
        vector<string> ans;
        ans = k_distinct("abcdefgfgedcba", 3);
        cout << "abcdefgfgedcba 3" << endl;
        printv(ans);

        ans = k_distinct_2("abcdefgfgedcba", 3);
        printv(ans);
        ans = k_distinct("bbceffeakkdefcc", 3);
        cout << "bbceffeakkdefcc 3" << endl;
        printv(ans);

        ans = k_distinct_2("bbceffeakkdefcc", 3);
        printv(ans);

        ans = k_distinct("eeggjuuikdkiae", 3);
        cout << "eeggjuuikdkiae 3" << endl;
        printv(ans);

        ans = k_distinct_2("eeggjuuikdkiae", 3);
        printv(ans);
}


//===============================================================
