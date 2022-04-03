/*중복문자제거
설명

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.

중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.


예시 입력 1 

ksekkset
예시 출력 1

kset*/

package inflearn.test;

import java.util.*;
import java.io.*;

public class C01_06_02 {
	
	public String solution(String str) {
		String ans = "";
		
		char[] c = str.toCharArray();
		
		for (char d : c) {
			//ans안에 d에 해당하는 글자가 없다면,
			if(ans.indexOf(d) == -1) {
				//해당 글자 추가
				ans += d;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_06_02 T = new C01_06_02();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.print(T.solution(str));
		//System.out.print(str);
	}

}
