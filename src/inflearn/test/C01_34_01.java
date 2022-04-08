/*
4. 모든 아나그램 찾기
설명

S문자열에서 T문자열과 아나그램이 되는 
S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

아나그램 판별시 대소문자가 구분됩니다. 
부분문자열은 연속된 문자열이어야 합니다.


입력
첫 줄에 첫 번째 S문자열이 입력되고, 
두 번째 줄에 T문자열이 입력됩니다.

S문자열의 길이는 10,000을 넘지 않으며, 
T문자열은 S문자열보다 길이가 작거나 같습니다.


출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


예시 입력 1 

bacaAacba
abc
예시 출력 1

3
힌트

출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 */

package inflearn.test;
//Hash로 풀기!!! 
import java.io.*;
import java.util.*;

public class C01_34_01 {
	public int solution(String a, String b) {
		int ans = 0; //값 출력
		Map<Character, Integer> bm = new HashMap<>(); // key=종류, value=갯수
		Map<Character, Integer> am = new HashMap<>();
		for(char key : b.toCharArray()) { //b map 생성
			bm.put(key, bm.getOrDefault(key, 0)+1);
		}
		int L = b.length()-1;
		for(int i = 0; i < L; i++) { //a map은 b.length()-1만큼 생성
			am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
		}
		int lt = 0;
		for(int rt = L; rt < a.length(); rt++) { //am 이후 모두
			am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
			if(am.equals(bm)) { //am.equals(bm)같으면 
				ans++; //갯수추가
			}
			am.put(a.charAt(lt), am.get(a.charAt(lt))-1); //lt위치 값 1개 제거

			if(am.get(a.charAt(lt)) == 0) { //제거 후 0이면
				am.remove(a.charAt(lt)); //아예 key삭제
			}
			lt++; //lt 다음으로 이동
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_34_01 T = new C01_34_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		
		System.out.println(T.solution(a, b));
	}

}
