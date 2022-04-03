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

import java.util.*;
import java.io.*;

public class C01_03 {
	
	public String solution(String str) {
		String ans = "";
		int max = 0;
		// -2^32 
		//int max1 = Integer.MIN_VALUE;
		
		//방법1. split()
		/*
		
		String[] arr = str.split(" ");
		for(String a : arr) {
	
			if(a.length() > max) {
				max = a.length();
				ans = a;
			}
		}
		*/
		
		//방법2. indexOf(), SubString()
		int pos;
		//str에서 ' '발견 못할시 -1
		while((pos = str.indexOf(' ')) != -1) {
			//str의 시작부터 ' '발견 전까지
			String str1 = str.substring(0, pos);
			int leng = str1.length();
			if(leng > max) {
				max = leng;
				ans = str1;
			}
			
			//str1의 위치를 이미 체크한 곳 제외시키기
			str = str.substring(pos+1);
		}
		
		//마지막 단어는 그 뒤에 공백 없기 때문에 while로직 해당 안되므로 처리
		if(str.length() > max) {
			ans = str;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_03 T = new C01_03();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.print(T.solution(str));

	}

}
