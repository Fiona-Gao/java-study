package com.solution.StackQueen;

import java.util.*;

/*
括号匹配：https://leetcode.cn/problems/valid-parentheses/
 */
public class StackTest {
    public boolean isValid(String s){

        Map<Character,Character> kv = new HashMap(){{
            put('{','}');
            put('[',']');
            put('(',')');
            }};

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (kv.get(c) != null){
                stack.push(c);
            }else {
                if (stack.empty()) {return false;}
                Character p = stack.pop();
                if (!c.equals(kv.get(p))){
                    return false;
                }

            }
        }
        if (stack.empty()) return true;

        return false;
    }
/*
逆波兰式求解：https://leetcode.cn/problems/evaluate-reverse-polish-notation/submissions/
 */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int y = stack.pop();
                int x = stack.pop();
                int z = calc(x, y, s);
                stack.push(z);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public int calc(int x, int y, String op) {
        if (op.equals("+")) return x + y;
        if (op.equals("-")) return x - y;
        if (op.equals("*")) return x * y;
        if (op.equals("/")) return x / y;
        return 0;
    }
/*
中序计算 https://leetcode.cn/problems/basic-calculator/submissions/
先改为逆波兰式然后计算
 */
    public int calculate(String s) {
        List<String> token = new ArrayList<>();
        Stack<String> ops = new Stack<>();
        String num = "";
        s += " ";
        boolean addZero = true;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9'){
                num += c;
                addZero = false;
            } else {
                if (num != ""){
                    token.add(num);
                    num = "";
                }
                if (c == ' ') continue;
                if (c == '(') {
                    addZero = true;
                    ops.push(String.valueOf(c));
                    continue;
                }
                if ((c == '+' || c == '-') && addZero){
                    token.add("0");
                }
                if ( !ops.empty() && getLevel(ops.peek()) >= getLevel(String.valueOf(c))){
                    if (c == ')'){
                        addZero = false;
                        while (!ops.peek().equals("(")){
                            token.add(ops.pop());
                        }
                        ops.pop();
                        continue;
                    }
                    token.add(ops.pop());
                    ops.push(String.valueOf(c));
                    addZero = true;
                    continue;
                }
                addZero = true;
                ops.push(String.valueOf(c));
            }
        }
        while (!ops.empty()){
            token.add(ops.pop());
        }

    return evalRPN(token.toArray(new String[token.size()]));
    }

    public int getLevel(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }
}

