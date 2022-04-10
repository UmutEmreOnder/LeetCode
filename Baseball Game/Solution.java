class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> myStack = new Stack<>();

        for(int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                /**
                 * Since in cases D, C, and + it is guaranteed that there are enough scores to perform them
                 * We don`t need to check whether the stack is empty or the stack has 2 elements etc.
                 */
                case "D":
                    myStack.push(myStack.peek() * 2);
                    break;
                case "C":
                    myStack.pop();
                    break;
                case "+":
                    plus(myStack);
                    break;
                default:
                    myStack.push(Integer.valueOf(ops[i]));
            }
        }

        int result = 0;
        while(!myStack.isEmpty()) {
            result += myStack.pop();
        }
        return result;
    }

    /**
     * Since we using stack structure, we cannot access the second last element without popping the last element.
     * Also, we still need the second last element in our stack so we store it in a dummy variable (num)
     * After adding last + (last - 1) elements, we push it back
     */
    public void plus(Stack<Integer> myStack) {
        int num = myStack.pop();
        int newNum = num + myStack.peek();
        myStack.push(num);
        myStack.push(newNum);
    }
}