/*
7. 좌표 정렬
설명

N개의 평면상의 좌표(x, y)가 주어지면 
모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, 
x값이 같을 경우 y값에 의해 정렬합니다.


입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.

예시 입력 1 
5
2 7
1 3
1 2
2 5
3 6

예시 출력 1
1 2
1 3
2 5
2 7
3 6
 */

package inflearn.test;

import java.io.*;
import java.util.*;

public class C01_50_01 {
	public int[][] solution(int n, int[][] arr) {
		String[] tmp = new String[n];
		for(int i = 0; i < arr.length; i++) {
			tmp[i] = ""; //기본값이 null이므로 공백 초기화
			for(int j = 0; j < arr[0].length; j++) {
				tmp[i] += arr[i][j];
			}
		}
		
		Arrays.sort(tmp);

		for(int i = 0; i < tmp[0].length(); i++) {
			for(int j = 0; j < tmp.length; j++) {
				arr[j][i] = tmp[j].charAt(i) - 48;
			}
		}
		
		return arr;
	}

	public static void main(String[] args) throws IOException {
		C01_50_01 T = new C01_50_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 행 수

		int[][] arr = new int[n][2]; // 좌표 배열 만들기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < T.solution(n, arr).length; i++) {
			for(int j = 0; j < T.solution(n, arr)[0].length; j++) {
				System.out.print(T.solution(n, arr)[i][j]);
				if(j == 0) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
