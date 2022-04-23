/*
2. 괄호문자제거
설명
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 
남은 문자만 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
남은 문자만 출력한다.

예시 입력 1 
(A(BC)D)EF(G(H)(IJ)K)LM(N)

예시 출력 1
EFLM
 */

package inflearn.test;

//STACK(컵)으로 풀기!!! 
import java.io.*;
import java.util.*;

public class C01_37_re {
	public String solution(String str) {
		String ans = "";
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c == ')') {
				while(stack.pop() != '('); //stack에 축적하되, )를 만나면 (가 나오기 전까지 모든 것들 다 pop해버리기
			}
			else { //)를 만나기 전이라면 '(', 알파벳 모두 push
				stack.push(c);
			}
		}
		
		for(Character c : stack) {
			ans += c;
		}
		
		return ans;
	}

		public static void main(String[] args) throws IOException {
			C01_37_re T = new C01_37_re();
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
	
			System.out.println(T.solution(str));
		}
}
