/*
1. 두 배열 합치기
설명

오름차순으로 정렬이 된 두 배열이 주어지면 
두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.

예시 입력 1 
3
1 3 5
5
2 3 6 7 9

예시 출력 1
1 2 3 3 5 6 7 9
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_25_re {

	public ArrayList<Integer> solution(ArrayList<Integer> list) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i : list) {
			ans.add(i);
		}
		Collections.sort(ans);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_25_re T = new C01_25_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); //1배열 크기
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine()); //2배열 크기
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i : T.solution(list)) {
			System.out.print(i + " ");
		}
		
	}

}
