/*
10. 가장 짧은 문자거리
설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1 

teachermode e
예시 출력 1

1 0 1 2 1 0 1 2 2 1 0
 */

//int to char : Character.forDigit(대상숫자, 진수)
package inflearn.test;

import java.util.*;
import java.io.*;

//113ms
//방법1. 거리 값 리스트에서 최소값 뽑기
//Collections.min(배열) : 배열 최소값
//Collections.max(배열) : 배열 최대값
public class C01_10_01 {
	
	public String solution(String str, char c) {
		String ans = "";
		
		//문자열 char배열화
		char[] arr = str.toCharArray();
		//문자 간 거리값 담을 리스트
		ArrayList<Integer> iarr = new ArrayList<Integer>();
		//최소 거리 값
		int min = 0;
		
		//인덱스별 문자 선택
		for (int i = 0; i < arr.length; i++) {
			//선택된 문자 - 체크할 문자간 거리 체크
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == c) {
					min = j-i;
					//방향 없이 가까운 순서이므로 양수화
					if(min < 0) {
						min *= -1;
					}
					//양수화 된 최소값 리스트 담기
					iarr.add(min);
				}
			}
			//배열 내 최소값 선택 및 결과에 담기
			min = Collections.min(iarr);
			ans += min+" ";
			//값 저장 후 배열 비우기
			iarr.clear();
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_10_01 T = new C01_10_01();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] getStr = br.readLine().split(" ");
		String str = getStr[0];
		char c = getStr[1].charAt(0);
		System.out.print(T.solution(str, c));
		
	}
}
