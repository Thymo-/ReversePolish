/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Stack<Integer> s = new Stack<Integer>();

    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (EmptyStackException e) {
            System.out.println("Stack Underflow");
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] operands;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                s.push(Integer.parseInt(c + ""));
            } else if (c == '-') {
                operands = fetch();
                s.push(operands[0] - operands[1]);
            } else if (c == '+') {
                operands = fetch();
                s.push(operands[0] + operands[1]);
            } else if (c == '*') {
                operands = fetch();
                s.push(operands[0] * operands[1]);
            } else if (c == '/') {
                operands = fetch();
                s.push(operands[0] / operands[1]);
            } else if (c == '^') {
                operands = fetch();
                s.push((int)Math.pow((double) operands[0], (double) operands[1]));
            } else if (c == 'r') {
                s.push((int)Math.sqrt(s.pop()));
            } else if (c == '%') {
                operands = fetch();
                s.push(operands[0] % operands[1]);
            }
        }

        System.out.println(s.pop() + "");
    }

    private int[] fetch() {
        int[] arr = new int[2];

        arr[1] = s.pop();
        arr[0] = s.pop();

        return arr;
    }
}
