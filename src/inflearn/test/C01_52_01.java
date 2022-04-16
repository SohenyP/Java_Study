/*
9. 뮤직비디오(결정알고리즘)
설명

지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
DVD에는 총 N개의 곡이 들어가는데, 
DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.

순서가 바뀌는 것을 가수가 매우 싫어한다. 
즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 
또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.

지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 
이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 
이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.

그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 
꼭 같은 크기로 해야 한다.

입력
첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
다음 줄에는 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.


출력
첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.


예시 입력 1 

9 3
1 2 3 4 5 6 7 8 9
예시 출력 1

17

설명 
: 3개의 DVD용량이 17분짜리이면 
(1, 2, 3, 4, 5) (6, 7), (8, 9) 
이렇게 3개의 DVD로 녹음을 할 수 있다.
 */

package inflearn.test;
//결정알고리즘 : 이분검색(오름차순 정렬 후 lt+rt/2) 이용하기
//결정 알고리즘은 lt(인덱스0), rt(배열길이)사이에 있을 때만 결정알고리즘 사용
import java.io.*;
import java.util.*;

class C01_52_01 {

	public int count(int[] arr, int capacity) {
		int cnt = 1; //dvd갯수(1개로 시작)
		int sum = 0; //1개당 용량
		
		for(int x : arr) { //받은 배열 하나씩 대입
			if(sum + x > capacity) { //배열 합이 m보다 크면 
				cnt++; //디스크 추가
				sum = x; //새로운 디스크에 저장될 시작 노래
			}
			else { //용량보다 작다면
				sum += x; //sum에 합하기
			}
		}
		return cnt;
	}
	public int solution(int n, int m, int[] arr) {
		int ans = 0;
		
		//Arrays.stream(arr).max().getAsInt () : 배열 중 최대값
		//Arrays.stream(arr).min().getAsInt () : 배열 중 최소값
		//Arrays.stream(arr).sum() : 배열 합
		//Arrays.stream(arr).average().getAsDouble() : 배열 평균
		
		int lt = Arrays.stream(arr).max().getAsInt(); //배열 중 최대값
		int rt = Arrays.stream(arr).sum(); //배열의 합
		
		while(lt <= rt) {//lt가 rt보다 크면 종료 - 즉, lt는 하나씩 늘려가고, rt는 하나씩 줄여감
			int mid = (lt+rt)/2; //이분 검색 기준 찾기 - 중간 값
			if(count(arr, mid) <= m) { //count메소드에 배열, 이분기준 보내서 값 수령
				ans = mid;
				rt = mid-1;
			}
			else {
				lt = mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		C01_52_01 T = new C01_52_01();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 배열 길이 - 노래 곡 수
		int m = Integer.parseInt(st.nextToken()); // 찾을 숫자 - DVD 갯수

		int[] arr = new int[n]; // 숫자배열 - 노래별 시간

		st = new StringTokenizer(br.readLine(), " "); //배열화
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//이분검색 조건1. : sort 오름차순 청렬
		Arrays.sort(arr);

		System.out.print(T.solution(n, m, arr));

	}
}
