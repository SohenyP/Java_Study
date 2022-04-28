/*
3. 삽입 정렬
설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 삽입정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 
각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1 
6
11 7 5 6 10 9

예시 출력 1
5 6 7 9 10 11
 */

package inflearn.test;

//삽입정렬 : 인덱스1부터 시작해서 자기 앞과 비교해서 위치 조정

import java.io.*;
import java.util.*;

public class C01_46_re {
	public int[] solution(int n, int[] arr) {
		int[] ans = new int[n];
		
		for(int i = 1; i < n; i++) { //삽입정렬은 [1]부터 시작, 앞과 비교해야함
			int j = 0; //for문 밖에서 j값 사용위함
			
			for(j = i-1; j >= 0; j--) { //자기 앞과 비교이므로 시작이 i-1임!
				if(arr[j] > arr[i]) { //arr[i]랑 arr[j(=i-1)] 크기 비교
					arr[j+1] = arr[j]; //i-1이 더 크면, i자리에 i-1값 넣기
				}
				else {
					break;
				}
			}
			arr[j+1] = arr[i];
		}
		ans = arr;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_46_re T = new C01_46_re();

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
