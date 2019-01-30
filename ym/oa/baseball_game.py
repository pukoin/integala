class Solution(object):
    def calculatePoints(self, operators):
        errMsg = 'Invalid Input'
        number_stack = []
        for operator in operators:
            if operator == '+':
                if len(number_stack) < 2:
                    return errMsg
                number_stack.append(number_stack[-1] + number_stack[-2])
            elif operator == 'C':
                if len(number_stack) < 1:
                    return errMsg
                number_stack.pop()
            elif operator == 'D':
                if len(number_stack) < 1:
                    return errMsg
                number_stack.append(2 * number_stack[-1])
            else:
                try:
                    number_stack.append(int(operator))
                except:
                    return errMsg

        return sum(number_stack)

    def test(self):
        input1 = ["5","2","C","D","+"]
        input2 = ["5","-2","4","C","D","9","+","+"]


        print input1, self.calculatePoints(input1)
        print input2, self.calculatePoints(input2)

        for idx, val in enumerate(input2):
            print idx, val, self.calculatePoints(input2[:idx + 1])