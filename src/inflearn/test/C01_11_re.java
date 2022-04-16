/*
11. 문자열 압축
설명

알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는

문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.

단 반복횟수가 1인 경우 생략합니다.


입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


출력
첫 줄에 압축된 문자열을 출력한다.


예시 입력 1 
KKHSSSSSSSE

예시 출력 1
K2HS7E


예시 입력 2 
KSTTTSEEKFKKKDJJGG

예시 출력 2
KST3SE2KFK3DJ2G2

 */

//아스키
//특 : 32 ~ 47
//숫 : 48 ~ 57
//특 : 58 ~ 63
//대 : 65 ~ 90
//소 : 97 ~ 122

package inflearn.test;

import java.io.*;

public class C01_11_re {
	
	public String solution(String str) {
		String ans = "";
		
		str += " "; //맨끝까지 가도록 " " 공백추가
		
		char[] arr = str.toCharArray();
		int cnt = 1; //자기자신도 추가이므로
		
		for(int i = 0; i < str.length()-1; i++) {
			if(arr[i] == arr[i+1]) {
				cnt++;
			}
			else {
				ans += arr[i];
				if(cnt > 1) {
					ans += cnt;
					cnt = 1;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		C01_11_re t = new C01_11_re();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.print(t.solution(str));
		
	}

}
