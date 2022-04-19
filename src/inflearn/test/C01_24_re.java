/*
12. 멘토링
설명

현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 
멘토가 멘티의 수학공부를 도와주는 것입니다.

선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, 
A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 
출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 
학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 
3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.


출력
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.


예시 입력 1 
4 3
3 4 1 2
4 3 2 1
3 1 4 2

예시 출력 1
3
 */

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_24_re {

	public int solution(int n, int m, int[][] arr) {
		int ans = 0;
		//경우의 수 = 학생수(멘토) x 학생수(멘티)
		for(int i = 0; i < n; i++) { //멘토번호
			for(int j = 0; j < n; j++) { //멘티번호
				if(i == j) { // '나' 자신은 건너뛰기
					continue;
				}
				
				int cnt = 0; // 가능횟수
				for(int k = 0; k < m; k++) { //테스트 만큼!
					int mento = 0;
					int mentee = 0;
					
					for(int s = 0; s < n; s++) { //등수 확인
						if(arr[k][s] == i) { //k회차 s등이 멘토라면
							mento = s; //멘토 등수 저장
						}
						if(arr[k][s] == j) { //k회차 s등이 멘티라면
							mentee = j; //멘티 등수 저장
						}
					}
					if(mento > mentee) { //멘토가 멘티보다 크면 = 멘토 등수가 멘티 등수보다 크면
						cnt++; //카운트 증가
					}
				}
				if(cnt == m) { //그 횟수가 테스트 수만큼이면 (= 모든 시험 이김)
					ans++; //멘토멘티 인정
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_24_re T = new C01_24_re();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 학생 명수 : 열
		int m = Integer.parseInt(st.nextToken()); // 테스트 수 : 행

		int[][] arr = new int[m][n]; // int[열][행] : 세로는 등수!

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(T.solution(n, m, arr));

	}

}
