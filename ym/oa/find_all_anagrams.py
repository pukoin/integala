class Solution(object):
    def findAnagrams(self, s, p):

        result = []
        length_s = len(s)
        length_p = len(p)
        if length_s < length_p:
            return result

        p_hash = [0] * 123
        s_hash = [0] * 123

        for each in p:
            p_hash[ord(each)] += 1

        for each in s[:length_p-1]:
            s_hash[ord(each)] += 1

        for each in range(length_p-1, length_s):
            s_hash[ord(s[each])] += 1
            if each-length_p >= 0:
                s_hash[ord(s[each-length_p])] -= 1
            if s_hash == p_hash:
                result.append(each - length_p + 1)
        return result

    def test(self):
        s1 = 'cbaebabacd'
        p1 = 'abc'
        s2 = 'abab'
        p2 = 'ab'
        print s1 + ' ' + p1 + ' ' + str(self.findAnagrams(s1, p1))
        print s2 + ' ' + p2 + ' ' + str(self.findAnagrams(s2, p2))
