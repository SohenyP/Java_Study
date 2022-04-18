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

//자기보다 점수 높은 갯수 체크
import java.util.*;
import java.io.*;

public class C01_20_re {

	public int[] solution(int num, int[] arr) {
		int[] ans = new int[num];
		int rank = 1; // 없으면 1등

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					rank++;
				}
			}
			ans[i] = rank;
			rank = 1;
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_20_re T = new C01_20_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i : T.solution(num, arr)) {
			System.out.print(i + " ");
		}

	}
}
