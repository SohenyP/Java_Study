/*7. 회문 문자열
설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.

문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


예시 입력 1 

gooG
예시 출력 1

YES*/

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_08_02 {
	
	public String solution(String str) {
		String ans = "YES";
		String w = "";
		str = str.toLowerCase();
		
		char[] c = str.toCharArray();
		
		//
		//방법2. length()/2 와 charAt(i) != charAt(length()-i-1)
		for (char d : c) {
			if(d >= 65 && d <= 122) {
				w += d;
			}
		}

		int n = ans.length();
		
		for (int i = 0; i < w.length()/2; i++) {
			if(w.charAt(i) != w.charAt(w.length()-i-1)) {
				ans = "NO";
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_08_02 T = new C01_08_02();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.print(T.solution(str));
	}
}
