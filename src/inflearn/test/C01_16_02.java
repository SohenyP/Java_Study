/*
4. 피보나치 수열
설명

1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력
첫 줄에 피보나치 수열을 출력합니다.


예시 입력 1 

10
예시 출력 1

1 1 2 3 5 8 13 21 34 55
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
//피보나치 수열 : 주어진 두 수 1, 1/ 두 수의 합이 다음 숫자
//122ms
//방법2. int[] 없이
public class C01_16_02 {
	public String solution(int num) {
		String ans = "";
		StringBuilder sb = new StringBuilder();
		int a = 1;
		int b = 1;
		int c = 0;
		sb.append(a + " " + b +  " "); 
		
		for (int i = 2; i < num; i++) {
			c = a + b;
			sb.append(c);
			if(i != num-1) {
				sb.append(" ");
			}
			a = b;
			b = c;
		}
		ans = sb.toString();
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_16_02 T = new C01_16_02();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(T.solution(num));
	}
}
