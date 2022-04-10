/*
5. 중복 확인
설명

현수네 반에는 N명의 학생들이 있습니다.
선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 
각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.

출력
첫 번째 줄에 D 또는 U를 출력한다.

예시 입력 1 
8
20 25 52 30 39 33 43 33

예시 출력 1
D
 */

package inflearn.test;

//삽입정렬

import java.io.*;
import java.util.*;

public class C01_48_01 {
	public String solution(int n, int[] arr) {
		String ans = "U";
		Arrays.sort(arr); //오름차순 정렬
		//내림차순 정렬(Long, Integer, String 가능)
		//Arrays.sort(arr,Collections.reverseOrder()); 
		
		//정렬을 먼저 했기 때문에 이중for문 불필요
		for(int i = 0; i < n-1; i++) {
			if(arr[i] == arr[i+1]) {
				return "D";
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_48_01 T = new C01_48_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 캐시크기

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n]; // 작업순서
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(T.solution(n, arr));
	}
}
