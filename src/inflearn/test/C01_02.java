/*설명

대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.


입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.

문자열은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.


예시 입력 1 

StuDY
예시 출력 1

sTUdy
*/
package inflearn.test;

import java.io.*;
import java.util.*;

public class C01_02 {

	public String solution(String word) {
		String answer = "";

		//방법1
		/*
		for (char c : word.toCharArray()) {
			if(Character.isLowerCase(c)) {
				answer += Character.toUpperCase(c);
			}
			else {
				answer += Character.toLowerCase(c);
			}
		}
		*/
		
		//방법2.
		/*
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			if(Character.isLowerCase(c)) {
				answer += Character.toUpperCase(c);
			}
			else if (Character.isUpperCase(c)) {
				answer += Character.toLowerCase(c);
			}
		}
		*/
		
		//방법3. 아스키코드
		//소문자 : 65 ~ 90
		//대문자 : 97 ~ 122
		for(char c : word.toCharArray()) {
			if(c >= 97 && c <= 122) {
				//대문자 - 32 = 소문자
				answer += (char)(c - 32);
			}
			else if (c >= 65 && c <= 90) {
				//소문자 + 32 = 대문자
				answer += (char)(c + 32);
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// 출력 객체 생성
		C01_02 T = new C01_02();
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력된 단어
		String word = br.readLine();
		System.out.println(T.solution(word));
	}

}
