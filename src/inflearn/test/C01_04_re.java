/*4. 단어 뒤집기
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


예시 입력 1 
3
good
Time
Big

예시 출력 1
doog
emiT
giB
*/
package inflearn.test;

import java.io.*;

public class C01_04_re {
	public String solution(String str) {
		String ans = "";
		
		char[] arr = str.toCharArray();
		
		for(int i = 0; i < arr.length/2; i++) {
			char tmp = arr[i];
			arr[i] = arr[arr.length-1-i]; //맨 끝은 length-1
			arr[arr.length-1-i] = tmp;
		}
		
		for(char c : arr) {
			ans += c;
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		C01_04_re t = new C01_04_re();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		
		for(String str : arr) {
			System.out.println(t.solution(str));
		}
	}
}
