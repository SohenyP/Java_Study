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

public class C01_09_02 {
	
	public int solution(String str) {
		int ans = 0;
		//방법2. 아스키코드
		//대문 : 97 ~ 122
		//소문 : 65 ~ 90
		//숫자 : 48 ~ 57 (0~9) 
		//특문 : 32 ~ 47 / 58 ~ 63
		for (char c : str.toCharArray()) {
			
			//숫자일때!
			if(c >= 48 && c <= 57) {
				//c는 char이기 때문에 아스키코드로 계산됨 따라서 48 or '0'을 빼서 정수로 만들기
				ans = ans*10+(c-'0');
				/*
				 ans = 0으로 시작
				 따라서 첫 숫자 발생시 ans = 첫숫자
				 두번째 발생 시, 첫숫자*10+(두번째) 이므로 첫숫자가 10의자리가 됨 
				 세번째 발생시, 첫숫자둘숫자*10+(세번째)이므로, 첫숫자는 100의 자리, 둘숫자는 10의 자리, 셋숫자는 1의자리가 됨!
				 */
			}
		}
	
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_09_02 T = new C01_09_02();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.print(T.solution(str));
	}
}
