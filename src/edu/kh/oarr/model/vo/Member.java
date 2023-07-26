package edu.kh.oarr.model.vo;

public class Member {
	
	// 1. 필드 (== 멤버변수)
	private String memeberId;
	private String memeberPw;
	private String memeberName;
	private int memeberAge;
	private String region; // 서울 / 경기 / 충북...
	
	// 2. 생성자
	// 기본생성자, 매개변수생성자
	// 1. 생성자 이름은 클래스명과 같다.
	// 2. 반환형이 없다.
	// 3. 기본생성자는 컴파일러가 자동으로 생성해주는데, 
	//		생성자가 하나라도 있으면 자동생성 안해줌. -> 기본생성자도 직접 만들어줘야함
	
	// 기본 생성자
	public Member() {}
	
	// 모든 필드 초기화하는 매개변수 생성자
	// 오버로딩적용 -> 매개변수의 타입, 순서, 갯수가 달라야한다
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memeberId = memberId;
		this.memeberPw = memberPw;
		this.memeberName = memberName;
		this.memeberAge = memberAge;
		this.region = region;
		// this 참조변수
		
	}
	
	// 3. 메서드(getter/setter)
	
	// 다 접근 가능하도록 public / String 자료형으로 반환하는
	public String getMemeberId() {
		return memeberId; // ()안에 같은 매개변수가 없어서 중복된 이름의 memberId가 없으므로 this 사용하지않음
	}
	
	// 무엇을 셋팅할지 전달받아온 아이가 매개변수다.
	// 반환값이 없어 void 
	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
		// 모든 메서드는 종료 시 호출한 곳으로 돌아가는
		// return 구문이 작성되어야하지만
		// 단, void 일 경우 생략 가능 -> 생략 시 컴파일러가 자동 추가해준다.
		// return;이 숨겨져 있는 것이다.
	}

	public String getMemeberPw() {
		return memeberPw;
	}

	public void setMemeberPw(String memeberPw) {
		this.memeberPw = memeberPw;
	}

	public String getMemeberName() {
		return memeberName;
	}

	public void setMemeberName(String memeberName) {
		this.memeberName = memeberName;
	}

	public int getMemeberAge() {
		return memeberAge;
	}

	public void setMemeberAge(int memeberAge) {
		this.memeberAge = memeberAge;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
}
