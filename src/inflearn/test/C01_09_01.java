/*
 9. 숫자만 추출
설명

문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.

만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.

추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.


입력
첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.


출력
첫 줄에 자연수를 출력합니다.


예시 입력 1 

g0en2T0s8eSoft
예시 출력 1

208
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_09_01 {
	
	public String solution(String str) {
		String ans = "";
		
		char[] c = str.toCharArray();
		//방법1. 아스키 + replaceFirst("^0+(?!$)", "");
		for (char d : c) {
			if(!(d>=65 && d <=122)) {
				ans += d;
			}
		}
		while(ans.charAt(0) == '0') {
			ans = ans.replaceFirst("^0+(?!$)", "");
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_09_01 T = new C01_09_01();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.print(T.solution(str));
	}
}
