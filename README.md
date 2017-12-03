# 백준 온라인 저지란?
[![](https://d2gd6pc034wcta.cloudfront.net/images/logo.png)](https://www.acmicpc.net)

**백준 온라인 저지**는 프로그래밍 문제를 풀고 온라인으로 채점받을 수 있는 곳입니다.
> **특징:**
> - **2010년 03월 19일**부터 운영을 시작한 온라인 저지입니다.
> - 사용 가능한 프로그래밍 언어는 총 **59**가지입니다.
> - 현재까지 **14270**개 이상의 문제 보유하고 있습니다.

# 채점 환경
백준 온라인 저지의 **Java 채점 환경**은 아래와 같습니다.
> **Java:**
> - 컴파일 실행 옵션 : **javac -J-Xms128m -J-Xmx512m -encoding UTF-8 Main.java**
> - 버젼 : **java version "1.8.0_91"**
> - 시간제한 : **+5초**
> - 메모리제한 : **+512MB**

# 채점 결과
백준 온라인 저지의 **채점 결과**는 아래와 같습니다.
>
<ul>
  <li><span style="color: #95a5a6">기다리는 중</span> : 채점이 밀려서 아직 채점이 되지 않은 상태입니다. 조금만 기다려 보세요.</li>
  <li><span style="color: #95a5a6">재채점을 기다리는 중</span> : 재채점을 기다리는 중입니다.</li>
  <li><span style="color: #e67e22">컴파일 하는 중</span> : 컴파일 하는 중입니다.</li>
  <li><span style="color: #e67e22">채점중</span> : 채점을 하는 중입니다.</li>
  <li><strong><span style="color: #009F6B">맞았습니다!!</span></strong> : 제출한 프로그램이 모든 테스트 케이스를 통과했을 때 입니다. 즉, 정답입니다!</li>
  <li><span style="color: #e74c3c">출력 형식이 잘못되었습니다</span> : 출력 결과는 정답과 유사하나, 공백, 빈 줄과 같은 문제로 인해서 출력 결과가 일치하지 않은 경우 입니다.</li>
  <li><span style="color: #e74c3c">틀렸습니다</span> : 출력 결과가 정답과 다른 경우 입니다.</li>
  <li><span style="color: #e74c3c">시간 초과</span> : 프로그램이 제한된 시간이내에 끝나지 않은 경우입니다. 이런 경우에는 채점을 중간에 중단하므로, 정답이 맞는지 아닌지는 알 수가 없습니다.</li>
  <li><span style="color: #e74c3c">메모리 초과</span> : 프로그램이 허용된 메모리보다 많은 메모리를 사용했을 경우입니다.</li>
  <li><span style="color: #e74c3c">출력 초과</span> : 너무 많은 출력이 발생하는 경우입니다. 주로 프로그램이 무한 루프에 빠졌을 때 발생합니다. 출력 제한은 1MB 입니다.</li>
  <li><span style="color: #004488">런타임 에러</span> : 실행 도중에 'segmentation fault', 'floating point exception', 'used forbidden functions', 'tried to access forbidden memories' 등의 에러가 발생하여서 프로그램이 종료된 경우 입니다.</li>
  <li><span style="color: #004488">컴파일 에러</span> : 컴파일 하지 못한 경우입니다. Warning Message는 에러 메시지가 아닙니다. 채점 결과를 클릭하면 컴파일 에러 메시지를 볼 수 있습니다.</li>
</ul>
      
# 1000번 예제 소스
Java를 이용한 **1000번 문제 풀이**는 아래와 같습니다.
```java
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a + b);
	}
}
```

# BOJ-PSJ 구성
**BOJ-PSJ**는 다음과 같이 구성되어 있습니다. 코드를 보시려면 **src > boj_문제번호 > Main.java**를 보시면 됩니다.
```text
BOJ-PSJ
├── .classpath (클래스패스 파일)
├── .git (git 디렉토리)
├── .project (프로젝트 파일)
├── .settings (설정 디렉토리)
├── LICENSE (프로젝트 라이센스 파일)
├── README.md (프로젝트 설명서 파일)
├── bin (컴파일 된 소스코드 디렉토리)
├── src (소스코드 디렉토리)
│   ├── boj_10156 (boj_문제번호 패키지)
│   │   ├── Main.java (소스코드 Java 파일)
...
```

# BOJ SUBMITTER 이용하기
**BOJ SUBMITTER**는 매번 백준 온라인 저지에 정답 코드를 복사 및 붙여넣기를 반복하는 당신께 다음과 같은 편리한 기능을 제공합니다. 코드를 보시려면 **src > boj_submitter > Main.java**를 보시면 됩니다.
> **사용방법:**
> - 1. 정답 코드를 작성합니다. (반드시 **src > boj_문제번호 > Main.java** 형태로 저장해주세요.)
> - 2. BOJ SUBMITTER를 실행해주세요. (**src > boj_submitter > Main.java**를 실행해주세요.)
> - 3. 아래 그림과 같이 제출하려는 문제 번호, 백준 온라인 저지 아이디 및 비밀번호를 입력하시고 **Submit** 버튼을 클릭해주세요.

# 라이센스
본 프로젝트는 Apache 2.0 License를 따릅니다. http://www.apache.org/licenses/LICENSE-2.0

# 문의사항
기타 문의사항이 있으실 경우 아래의 **문의 수단**으로 연락해주세요.
> **문의 수단:**
> - 메일 : **devetude@naver.com** 또는 **devetude@gmail.com**
> - github : **https://github.com/devetude/BOJ-PSJ/issues**
