class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        tmp_stack = []
        dict = {"]":"[", "}":"{", ")":"("}
        for item in s:
            if item in dict.values():
                tmp_stack.append(item)
            elif item in dict.keys():
                if tmp_stack == [] or dict[item] != tmp_stack.pop():
                    return False
            else:
                return False
        return tmp_stack == []

    def test(self):
        input1 = '()'
        input2 = '(){}[]'
        input3 = '(]'
        input4 = '([)]'

        print input1 + ': ' + str(self.isValid(input1))
        print input2 + ': ' + str(self.isValid(input2))
        print input3 + ': ' + str(self.isValid(input3))
        print input4 + ': ' + str(self.isValid(input4))