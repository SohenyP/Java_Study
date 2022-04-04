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

import java.util.*;
import java.io.*;

//
//방법1. 
public class C01_11_01 {

	public String solution(String str) {
		String ans = "";
		//맨 뒤에 공백 하나 추가하기
		str = str + " ";
		//갯수는 1부터 시작
		int cnt = 1;
		
		//인덱스 0부터 공백 전까지
		for (int i = 0; i < str.length()-1; i++) {
			//i번째 글자와 다음 글자가 같으면 cnt+
			if(str.charAt(i) == str.charAt(i+1)) {
				cnt++;
			}
			//다르면
			else {
				//i번째 글자만 삽입
				ans += str.charAt(i);
				//만약 현재 cnt가 1보다 크다면 cnt도 삽입
				if(cnt > 1) {
					ans += String.valueOf(cnt);
				}
				cnt = 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_11_01 T = new C01_11_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(T.solution(str));
	}
}
