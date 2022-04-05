/*
8. 등수구하기
설명

N명의 학생의 국어점수가 입력되면 
각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

같은 점수가 입력될 경우 
높은 등수로 동일 처리한다.

즉 가장 높은 점수가 92점인데 
92점이 3명 존재하면 
1등이 3명이고 
그 다음 학생은 4등이 된다.


입력
첫 줄에 N(3<=N<=100)이 입력되고, 
두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


출력
입력된 순서대로 등수를 출력한다.


예시 입력 1 

5
87 89 92 100 76
예시 출력 1

4 3 2 1 5
예시 입력2

5
87 92 92 100 76
예시 출력 2

4 2 2 1 5
 */

package inflearn.test;

import java.util.*;
import java.io.*;

//등수계산 : SQL의 RANK같은 역할 (555다음 6등 아닌 8등)
//
//방법1. 
public class C01_20_01 {
	
	public String solution(int num, int[] arr) {
		String ans = "";
		//초기등수 1등 설정
		int grade = 1;
		
		//5
		//87 89 92 100 76
		for (int i = 0; i < num; i++) {
			for (int j : arr) {
				//자기보다 크면 등수 하나씩 올리기
				if(arr[i] < j) {
					grade++;
				}
			}
			ans += grade;
			grade = 1;
			if(i < num-1) {
				ans += " ";
			}
		}
		
		
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_20_01 T = new C01_20_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} 
		System.out.print(T.solution(num, arr));
		
	}
}
