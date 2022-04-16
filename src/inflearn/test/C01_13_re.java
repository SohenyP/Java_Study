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

import java.io.*;
import java.util.*;

public class C01_13_re {

	public ArrayList<Integer> solution(int[] arr){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		ans.add(arr[0]); //첫수는 무조건 추가
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				ans.add(arr[i]);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		C01_13_re t = new C01_13_re();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i : t.solution(arr)) {
			System.out.print(i + " ");
		}
		
	}
}
