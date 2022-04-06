/*
2. 공통원소 구하기
설명

A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

각 집합의 원소는 1,000,000,000이하의 자연수입니다.


출력
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


예시 입력 1 

5
1 3 9 5 2
5
3 2 5 7 8
예시 출력 1

2 3 5
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_26_01 {

	public ArrayList<Integer> solution(int n1, int n2, int[] a, int[] b) {

		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					ans.add(a[i]);
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_26_01 T = new C01_26_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n1 = Integer.parseInt(br.readLine()); // 1번 배열
		st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n1];
		for (int i = 0; i < n1; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int n2 = Integer.parseInt(br.readLine()); // 2번 배열
		st = new StringTokenizer(br.readLine(), " ");
		int[] b = new int[n2];
		for (int i = 0; i < n2; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		for (Integer i : T.solution(n1, n2, a, b)) {
			System.out.print(i + " ");
		}
	}

}
