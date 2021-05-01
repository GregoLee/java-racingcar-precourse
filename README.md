# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 1. 요구사항 정의
### 1.1. 과제 진행 요구사항
|상세|구현 방법|비고|
|:---|---|---|
|•미션은 https://github.com/next-step/java-baseball-precourse 저장소를 fork/clone해 시작한다.|- fork <br> - clone||
|•기능을 구현하기 전에 java-baseball/README.md 파일에 구현할 기능 목록을 정리해 추가한다. |- 요구사항 최초 정리||
|•git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.<br>&nbsp;&nbsp;&nbsp;&nbsp;•AngularJS Commit Message Conventions 참고해 commit log를 남긴다.|- AngularJS Commit<br>&nbsp;&nbsp;&nbsp;&nbsp;Message Conventions 참고||
|•과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.|- 과제 제출 문서 참고<br>- 과제 제출|•2021년<br>&nbsp;5월 4일(화)<br>&nbsp;23시 59분까지 <br>&nbsp;GitHub을 통한<br>&nbsp;**미션 제출**과 **메일** 완료|

### 1.2. 프로그래밍 요구사항
|구분|상세|구현 방법|비고|
|:---:|:---|---|---|
|메소드 분리|• 자바 코드 컨벤션을 지키면서 프로그래밍한다.<br>&nbsp;&nbsp;• https://naver.github.io/hackday-conventions-java/|- gradle-editorconfig 적용<br>- gradle-checkstyle 적용<br>- IntelliJ 적용<br>- Github 적용||
| |• indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.<br>&nbsp;&nbsp;• 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.<br>&nbsp;&nbsp;• **힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리**하면 된다.|- < 2depth 규칙||
| |• 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.|- stream api 사용하지 말 것||
| |• else 예약어를 쓰지 않는다.<br>&nbsp;&nbsp;• 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.<br>&nbsp;&nbsp;• else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.|- else 예약어 금지||
| |• 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.<br>&nbsp;&nbsp;• 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.|- 함수(또는 메서드) 10라인 이하||
|단위 테스트|• 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외 <br>&nbsp;&nbsp;• 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.|- 핵심 로직 단위테스트||
| |• JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf"<br>&nbsp;&nbsp;문서를 참고해 사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.|- 사용법 학습||
|일급콜렉션|• 일급콜렉션을 활용해 구현한다. [참고문서](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/) |- 사용법 학습 | |
|패키징|• 모든 원시값과 문자열을 포장한다. [참고문서](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4) |- 사용법 학습 | | 

### 1.3. 기능 요구사항
|상세|구현 방법|비고|
|:---|---|---|
|• 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.|[ ] 전진, 멈춤 Enum<br>[ ] 자동차들 일급콜렉션||
|• 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.|[ ] 자동차 클래스<br>[ ] 자동차 - 이름, 전진거리 필드<br>[ ] '자동차 이름 : 전진거리'출력||
|• 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.|[ ] 이름은 5자 이하 true, false|[ ] 6자 이상인 경우<br> 다시 입력 요청 |
|• 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.|[ ] 숫자 이외 입력 예외처리|[ ] 숫자 범위 체크 (0 ~ ?)|
|• 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후<br>random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.|[ ] random 구하기(0 ~ 9)<br>[ ] 4 이상 : 전진, 3 이하 :멈춤||
|• 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.|[ ] 우승자 찾기<br>[ ] 우승자 출력|일급콜렉션 내 메소드로 구현?|

#### 1.3.1. 프로그램 실행 결과
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
...
```

## 2. 분석 및 설계
### 2.1. 이번 미션 핵심 목표
>TDD (Test-Driven Developmet) : production code보다 test code를 먼저 작성한다.
>>Cycle : Test Fail ---> Test Passes ---> Refactor ---> Test Fail ---> ... 

### 2.2. Todo List
- [x] 0.기본 세팅
  - [x] 0-1. git fork/clone
  - [x] 0-2. 요구사항 정리
  - [x] 0-3. AngularJS Commit Message Conventions 참고
- [x] 1.자바 코드 컨벤션을 위한 세팅
  - [x] 1-1.gradle-editorconfig 적용
  - [x] 1-2.gradle-checkstyle 적용
  - [x] 1-3.IntelliJ 적용
  - [x] 1-4.Github 적용
- [ ] 2.학습
  - [x] 2-1.일급콜렉션
  - [x] 2-2.패키징:모든 원시값과 문자열을 포장한다.
  - [x] 2-3.TDD 동영상 학습
  - [ ] 2-4.DDD(도메인 주도 설계) 찾아보기
- [ ] 3.분석 및 설계(DDD, Domain-Driven Design)
  - [ ] 3-1.Domain 구분
  - [ ] 3-2.Domain에서 TDD가 용이한 부분, 용이하지 않은 부분 발라내기
- [ ] 4.구현
  - [ ] 4-1.자동차 클래스
  - [ ] 4-2.자동차들 일급컬렉션
  - [ ] 4-3.IO
  - [ ] 4-4.UI
- [ ] 5.테스트
  - [ ] 5-1.Gradle build Success 확인
  - [ ] 5-2.checkstyle 문제없는지 확인
  - [ ] 5-3.요구사항 조건들 충족했는지 확인
    - [ ] 5-3-1.< 2 Depth 규칙
    - [ ] 5-3-2.Stream api 사용 금지
    - [ ] 5-3-3.else 예약어 금지
    - [ ] 5-3-4.함수(또는 메서드) 10라인 이하
    - [ ] 5-3-5.핵심 로직 단위테스트
- [ ] 6.인수인계
  - [ ] 6-1.과제 제출 문서 참고
  - [ ] 6-2.과제 제출 (2021년 5월 4일(화) 23:59까지, Github 제출 + 메일전송)
  
### 2.3. DDD(Domain-Driven Design) 구성도
- 하향식의 설계보다 상향식의 설계도 해보자!
