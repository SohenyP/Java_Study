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

public class C01_37_01 {
	public String solution(String str) {
		String ans = ""; // 값 없음 -1이므로 기본값 설정
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()) {
			if(c == ')') { 
				//while 조건만으로도 가능
				while(stack.pop() != '('); //stack.pop() == 꺼낸 값 출력
			}
			else {
				stack.push(c); //)아니면 전부 (or알파벳 stack.push()
			}
		}
		for (int i = 0; i < stack.size(); i++) {
			ans += stack.get(i);
		}
		return ans;
	}

		public static void main(String[] args) throws IOException {
			C01_37_01 T = new C01_37_01();
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
	
			System.out.println(T.solution(str));
		}
}
