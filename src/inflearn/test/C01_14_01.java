/*
2. 보이는 학생
설명

선생님이 N명의 학생을 일렬로 세웠습니다. 
일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 
맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. 
(앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


입력
첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


출력
선생님이 볼 수 있는 최대학생수를 출력한다.


예시 입력 1 

8
130 135 148 140 145 150 150 153
예시 출력 1

5
 */

//아스키
//특 : 32 ~ 47
//숫 : 48 ~ 57
//특 : 58 ~ 63
//대 : 65 ~ 90
//소 : 97 ~ 122

package inflearn.test;

import java.util.*;
import java.io.*;


//방법1. max최대값 설정 후 비교해 ans++;
public class C01_14_01 {

	public int solution(int num, int[] arr) {
		int ans = 0;
		//제일 큰사람
		int max = 0;
		
		for (int i = 0; i < num; i++) {
			if(arr[i] > max) {
				max = arr[i];
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_14_01 T = new C01_14_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[num];
		
		//String to int[]
		for (int i = 0; i < arr.length; i++) {
			//Integer.parseInt(String)
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(T.solution(num, arr));
	}
}
