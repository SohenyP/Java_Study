/*
1. 큰 수 출력하기
설명

N개의 정수를 입력받아, 
자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)

입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.


예시 입력 1 

6
7 3 9 5 6 12
예시 출력 1

7 9 6 12
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

//114ms
//방법2. int[] 로 숫자 받기
public class C01_13_02 {

	public String solution(int num, int[] arr) {
		String ans = "";
		//첫째수 무조건 출력
		ans += arr[0] + " ";
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				ans += arr[i];
				if(i != arr.length-1) {
					ans += " ";
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_13_02 T = new C01_13_02();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[num];
		
		//String to int[]
		for (int i = 0; i < arr.length; i++) {
			//Integer.parseInt(String)
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(T.solution(num, arr));
	}
}
