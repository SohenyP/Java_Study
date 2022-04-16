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

package inflearn.test;

import java.io.*;
import java.util.*;

public class C01_10_re {
	
	public int[] solution(String s, char t) {
		int[] ans = new int[s.length()];
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < s.length(); j++) {
				if(i != j && s.charAt(j) == t) {
					list.add(Math.abs(j-i));
				}
				else if(i == j &&  s.charAt(j) == t) {
					list.add(0);
				}
			}
			Collections.sort(list);
			ans[i] = list.get(0);
			list.removeAll(list);
		}
		
		return ans;
	}
	public static void main(String[] args) throws IOException {
		C01_10_re T = new C01_10_re();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String s = st.nextToken();
		char t = st.nextToken().charAt(0);
		
		for(int i : T.solution(s, t)) {
			System.out.print(i + " ");
		}
		
	}
	
}
