package com.shaangroups.practice.codingtests;

import java.util.EmptyStackException;
import java.util.Stack;

// sony techsoft coding round in codility
public class SonyTechSoft {

	public int solution(String S) {
		// write your code in Java SE 8
		Stack<Integer> solStack = new Stack<>();
		String[] operArr = S.split(" ");
		for (int i = 0; i < operArr.length; i++) {
			solStack.forEach(item -> {
				System.out.print(item + " ");
			});
			System.out.println();

			if (operArr[i].equals("DUP")) {
				try {
					int temp = solStack.peek();
					solStack.push(temp);
				} catch (EmptyStackException ese) {
					// no mention of this condition
					// so assuming to continue
					continue;
				}
			} else if (operArr[i].equals("POP")) {
				solStack.pop();
			} else if (operArr[i].equals("+")) {
				try {
				int a = solStack.pop();
				int b = solStack.pop();
				solStack.push(a + b); 
				} catch (EmptyStackException ese) {
					return -1;
				}
			} else if (operArr[i].equals("-")) {
				try {
					int a = solStack.pop();
					int b = solStack.pop();
					
					// subtraction yields negative result
					if ((a - b) < 0) {
						return -1;
					}
					
					solStack.push(a - b);
				} catch (EmptyStackException ese) {
					// return error as subtract operation requires 
					// two 
					return -1;
				}
			} else {
				solStack.push(Integer.parseInt(operArr[i]));
			}
		}

		// after performing all actions stack is empty
		if (solStack.isEmpty()) {
			return -1;
		}
		
		// pop the final result
		return solStack.pop();
	}

	public static void main(String[] args) {
		SonyTechSoft a = new SonyTechSoft();
		System.out.println(a.solution("13 DUP 4 POP 5 DUP + DUP + -"));
		System.out.println(a.solution("5 6 + -"));
		System.out.println(a.solution("DUP 13 13 -"));
		System.out.println(a.solution("4 DUP 5 - -"));
	}
}
