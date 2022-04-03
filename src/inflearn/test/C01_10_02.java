/*
10. 가장 짧은 문자거리
설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1 

teachermode e
예시 출력 1

1 0 1 2 1 0 1 2 2 1 0
 */

//int to char : Character.forDigit(대상숫자, 진수)
package inflearn.test;

import java.util.*;
import java.io.*;

//118ms
//방법2. 오른쪽 방향 거리체크, 왼쪽 방향 거리체크 크기 비교후 저장
public class C01_10_02 {
	
	public int[] solution(String str, char c) {
		int[] ans = new int[str.length()];
		
		int p = 1000;
		//오른쪽 방향 거리체크
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				p = 0;
				ans[i] = p;
			}
			else {
				p++;
				ans[i] = p;
			}
		}
		//왼쪽방향 거리 체크
		p = 1000;
		for (int i = str.length()-1; i > -1; i--) {
			if(str.charAt(i) == c) {
				p = 0;
			}
			else {
				p++;
				//Math.min(숫자1,숫자2) : 숫자1, 숫자2 중에 작은 숫자
				ans[i] = Math.min(ans[i], p);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_10_02 T = new C01_10_02();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String str = st.nextToken();
		char c = st.nextToken().charAt(0);
		
		for (int x : T.solution(str, c)) {
			System.out.print(x + " ");
		}
	}
}
