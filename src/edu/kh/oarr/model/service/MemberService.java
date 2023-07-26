package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	Scanner sc = new Scanner(System.in);
	
	// Member 다섯칸짜리 객체배열 선언 및 할당
	private Member[] memberArr = new Member[5];
	// 현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMember = null;
	
	public MemberService() {
		//memberArr 배열 0,1,2배열 인덱스 초기화
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "계보린", 25, "경기");
		memberArr[2] = new Member("user03", "pass03", "고길동", 45, "강원");
	}
	
	// 메뉴 출력용 메서드
	public void displayMenu() {
		// 반환형
		
		int menuNum = 0; // 메뉴 선택용 변수
		
		// 무조건 한번은 반복 -> do  while
		do {
			System.out.println("====회원 정보 관리 프로그램 v.2====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 조회");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거용
			
			switch(menuNum) {
			case 1 : System.out.println(signup()); break;
			case 2 : System.out.println(login()); break;
			case 3 : System.out.println(selectMember()); break;
			case 4 : 
				int result = updateMember();
				if(result == -1) {
					System.out.println("로그인 후 이용해주세요.");
				}else if(result ==0) {
					System.out.println("회원정보 수정 실패(비밀번호 불일치");
				}else {
					System.out.println("회원정보가 수정되었습니다.");
				}
				; break;
			case 5 : searchRegion(); ; break;
			case 0 : System.out.println("프로그램 종료..."); break;
			default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
			
			
		}while(menuNum != 0); // menuNum이 0이면 반복 종료
		
	}
	
	// memberArr에 비어있는 index번호를 반환하는 메서드
	// 단, 비어있는 인덱스가 없다면 -1 반환
	public int emptyIndex() {
		
		for(int i = 0; i < memberArr.length; i++) {
			if(memberArr[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	// 회원가입 메서드
	public String signup() {
		
		System.out.println("\n************회원가입************");
		
		// 객체배열 memberArr에 가입한 회원 정보를 저장
		// -> 새로운 회원정보를 저장할 공간이 있는지 확인
		// 		빈 공간의 인덱스 번호를 얻어오기 -> 새로운 메서드로 작성
		
		int index = emptyIndex(); // memberArr배열에서 비어있는 인덱스 번호를 반환
		
		if(index == -1) { // 비어있는 인덱스 없을 경우 > 회원가입 불가
			return "회원가입이 불가능합니다.(인원 수 초과)";
		}
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();

		System.out.print("지역 : ");
		String region = sc.next();
		
		if(memberPw.equals(memberPw2)) {
			
			// Member 객체 생성해서 할당된 주소를 memberArr의 비어있는 인덱스에 대입
			memberArr[index] = new Member(memberId, memberPw2, memberName, memberAge, region);
		//	memberInfo = memberArr[index];
					
			return "회원가입 성공!!";
			
		}else { // 일치하지 않는 경우
			return "회원가입 실패!! (비밀번호 불일치)";
		}
	}
	
	// 로그인 메서드
	public String login() {
		System.out.println("\n************로그인************");
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		// 1) memberArr배열 내 요소를 순서대로 접근하여 null이 아닌지 확인
		
		for(int i = 0; i < memberArr.length; i++) {
			
			if(memberArr[i] != null) {
				// 2) 회원정보의 아이디, 비밀번호와 입력받은 내용과 일치하는지 확인
				if(memberId.equals(memberArr[i].getMemeberId()) && memberPw.equals(memberArr[i].getMemeberPw())) {
					
					// 3) 로그인 회원정보 객체를 참조하는 변수 loginMember에
					// 현재 접근중인 memberArr[i]요소에 저장된 주소를 얕은 복사
					loginMember = memberArr[i];
					break;
				}
			}		
		}
		
		if(loginMember == null) {
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
		}else {
			return loginMember.getMemeberName() + "님 환영합니다.";
		}
		
		
	}

	// 정보 조회 메서드
	public String selectMember() {
		
		System.out.println("\n*********회원 정보 조회*********");
		
		if(loginMember == null) {
			return "로그인 후 이용해주세요";
		}
		
		String str = "이름 : " + loginMember.getMemeberName();
		str += "\n아이디 : " + loginMember.getMemeberId();
		str += "\n나이 : " + loginMember.getMemeberAge() + "세";
		
		return str;
	}

	// 정보 수정 메서드
	public int updateMember() {
		
		System.out.println("\n**********회원 정보 수정**********");
		
		if(loginMember == null) {
			return -1;
		}
		
		System.out.print("수정할 이름을 입력해주세요 : ");
		String memberName = sc.next();
		System.out.print("수정할 나이를 입력해주세요 : ");
		int memberAge = sc.nextInt();
		System.out.print("비밀번호를 입력해주세요. : ");
		String memberPw = sc.next();
		
		if(memberPw.equals(loginMember.getMemeberPw())) {
			
			loginMember.setMemeberName(memberName);
			loginMember.setMemeberAge(memberAge);
			return 1;
		}else {
			return 0;
		}
	}
	
	// 회원 검색(지역)
	public void searchRegion() {
		
		System.out.println("\n********회원 검색(지역)********");
		
		if(loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
		}else {
			
			System.out.print("지역 입력 : ");
			String inputRegion = sc.next();
			
			boolean flag = true; // 검색결과 신호용 변수
			
			// 1) memberArr 배열의 모든 요소 순차 접근
			for(int i = 0; i < memberArr.length; i++) {
				
				// 2) memberArr[i] 요소가 null이면 반복 종료]
				if(memberArr[i] == null) {
					break;
				}
				
				// 3) memberArr[i] 저장된 지역이 입력받은지역과 같을 경우
				// 회원의 아이디, 이름 출력
				
				if(inputRegion.equals(memberArr[i].getRegion())) {
					
					System.out.printf("아이디 : %s, 이름 : %s\n", memberArr[i].getMemeberId(), memberArr[i].getMemeberName());
					
					flag = false;
				}
				
			}
			
			if(flag) {
				System.out.println("일치하는 검색 결과가 없습니다.");
			}
		}
		
	}
	
}
