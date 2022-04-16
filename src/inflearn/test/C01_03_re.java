/*설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
문장속의 각 단어는 공백으로 구분됩니다.

입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 가장 긴 단어를 출력한다. 
******먼저 나온 단어가 채택되어야 하므로 >= max아닌 >max로!!!! 
가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
단어를 답으로 합니다.


예시 입력 1 
it is time to study

예시 출력 1
study

*/
package inflearn.test;

import java.io.*;

public class C01_03_re {
	
	public String solution(String str) {
		String ans = "";
		int max = 0;
		
		String[] arr = str.split(" ");
		
		for(String s : arr) {
			if(s.length() > max) {
				max = s.length();
				ans = s;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		C01_03_re t = new C01_03_re();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		System.out.print(t.solution(str));
	}
}
