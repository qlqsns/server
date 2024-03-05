package service;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.demo.domain.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
public class MemberServiceTest {

	MemberService ms;
	MemoryMemberRepository mmr;
	
	@BeforeEach
	public void beforeEach() {
		mmr = new MemoryMemberRepository();
		ms = new MemberService(mmr);
	}
	
	
	
	
	@AfterEach
	public void afterEach() {
		mmr.clearStore();
	}
	
	
	@Test
	void 회원가입() {
		//given 주어진 것을
		
		Member member = new Member();
		member.setName("hello");
		
		//when 실행시키면
		
		Long saveId = ms.join(member);
		
		
		//then 이렇게 결과가 나온다.
		
		Member findMember = ms.findOne(saveId).get();
		System.out.println(findMember.getName());
		System.out.println(member.getName());
	}
	
	@Test
	public void 중복회원예외() {
		//given
		Member m1 = new Member();
		m1.setName("spring");
		Member m2 = new Member();
		m2.setName("spring");
		//when
		ms.join(m1);
		try {
			ms.join(m2);
			System.out.println("성공");
		}catch(Exception e) {
			System.out.println("예외 대상");
			
		}
		
		
		
		//then
		
		
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
