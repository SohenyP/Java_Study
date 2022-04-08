/*
1. 올바른 괄호
설명

괄호가 입력되면 올바른 괄호이면 “YES", 
올바르지 않으면 ”NO"를 출력합니다.

(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, 
(()()))은 올바른 괄호가 아니다.


입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 
문자열의 최대 길이는 30이다.


출력
첫 번째 줄에 YES, NO를 출력한다.


예시 입력 1 

(()(()))(()
예시 출력 1

NO
 */

package inflearn.test;
//STACK(컵)으로 풀기!!! 
import java.io.*;
import java.util.*;

public class C01_36_01 {
	public String solution(String str) {
		String ans = "YES"; //값 없음 -1이므로 기본값 설정
		//Stack생성
		Stack<Character> st = new Stack<>();
		for(char c : str.toCharArray()) { //문자열화
			if(c == '(') { //(면
				st.push(c); //stack.push()
			}
			else { //)면
				if(st.isEmpty()) { //비었는지 체크, 빌 수 없음!
					return "NO"; // 따라서 no
				}
				else { //안비어있음
					st.pop(); //(하나 빼기
				}
			}
		}
		if(!st.isEmpty()) { //마지막까지 안비어있다면
			return "NO"; //no
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_36_01 T = new C01_36_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.println(T.solution(str));
	}

}
