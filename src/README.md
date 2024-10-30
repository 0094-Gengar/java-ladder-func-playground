## 사다리 게임


* Main(domain)
  * Ladder
    * 사다리 한 칸을 생성하는 클래스(List<String>)
  * LadderCollection
    * 사다리들의 모음 클래스(List<List<String>>)
  * Player
    * 플레이어 한 명이 갖는 정보(name, position)를 포함한 플레이어 객체를 생성하는 클래스
  * PlayerCollection
    * 플레이어들의 모음 클래스(List<Player>)
  * PlayerMovingLogic
    * 사다리를 진행하며 플레이어의 position 을 이동시키는 클래스
    * 플레이어 위치 좌우에 연결다리의 유무에 따라 position 값 변경
  * PrizeCollection
    * 사다리의 실행 결과들의 모음 클래스(List<String>)
    * 실행결과(result) 대신 prize 라고 명시
  * RandomGenerator
    * 사다리의 연결 다리 생성(랜덤)을 위한 랜덤 생성 클래스


* View(view)
  * InputView
  * OutputView


* Controller
  * LadderController
  

* Application