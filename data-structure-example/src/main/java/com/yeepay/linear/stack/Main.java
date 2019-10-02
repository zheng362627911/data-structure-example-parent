package com.yeepay.linear.stack;

/**
 * Created by zhenghao on 2019/2/13
 * call me 201****397
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack.toString());

        System.out.println(isSymmery("()(){}{}[]"));
        System.out.println(isSymmery("((){}{}[]"));
        System.out.println(isSymmery("){}{}[]"));
        System.out.println(isSymmery("(){}}[]"));
        System.out.println(isSymmery("(){}]"));
        System.out.println(isSymmery(""));
    }

    /**
     * 两两对称
     * (){}{}  -- true
     * {}[)(] -- >false
     *
     * @param str
     * @return
     */
    public static boolean isSymmery(String str) {
        ArrayStack<Character> arrayStack = new ArrayStack(10);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c == '(' || c == '{' || c == '[')) {
                arrayStack.push(c);
                continue;
            }
            if (arrayStack.isEmpty()) {
                return false;
            }
            char top = arrayStack.pop();
            if (top == '(' && c != ')') {
                return false;
            }
            if (top == '[' && c != ']') {
                return false;
            }
            if (top == '{' && c != '}') {
                return false;
            }
        }

        return arrayStack.isEmpty();
    }
}
