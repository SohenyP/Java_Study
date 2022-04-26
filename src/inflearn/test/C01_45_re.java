/*
2. 버블 정렬
설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 
각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1 
6
13 5 11 7 23 15

예시 출력 1
5 7 11 13 15 23
 */

package inflearn.test;

//버블정렬 : 인접값 비교 후 위치변경

import java.io.*;
import java.util.*;

public class C01_45_re {
	public int[] solution(int n, int[] arr) {
		int[] ans = new int[n];
		
		for(int i = 0; i < n-1; i++) { //버블 횟수
			for(int j = 0; j < n-1-i; j++) { //교체 (n-1-i인 이유는, 버블회차마다 맨 뒤부터 최댓값이 채워지기 때문(?))
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}				
			}
		}
		ans = arr;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_45_re T = new C01_45_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int a : T.solution(n, arr)) {
			System.out.print(a + " ");
		}
	}
}
