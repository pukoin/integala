class Solution {
public:
    static bool isnum(string s) {
        return (s[s.find(' ') + 1] <= '9' && s[s.find(' ') + 1] >= '0');
    }
    
    static bool cmp(const string& s1, const string& s2) {
        return s1.substr(s1.find(' ')) < s2.substr(s2.find(' '));
    }
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> vnum, vletter;
        for (auto i : logs) {
            if (isnum(i)) {
                vnum.push_back(i);
            }
            else 
                vletter.push_back(i);
        }
        
        sort(vletter.begin(), vletter.end(), cmp);
        vletter.insert(vletter.end(), vnum.begin(), vnum.end());
        return vletter;
        
        
    }
};