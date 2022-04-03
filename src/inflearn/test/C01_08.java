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

public class C01_08 {
	
	public String solution(String str) {
		String ans = "";
		str = str.toLowerCase();
		
		char[] c = str.toCharArray();
		
		//109ms
		//방법1. new StringBuilder(ans).reverse().toString();
		for (char d : c) {
			if(d >= 65 && d <= 122) {
				ans += d;
			}
		}
		
		String rev = new StringBuilder(ans).reverse().toString();
		if(rev.equals(ans)) {
			ans = "YES";
		}
		else {
			ans = "NO";
		}
		
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_08 T = new C01_08();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.print(T.solution(str));
	}

}
