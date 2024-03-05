package repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.demo.repository.*;
import com.example.demo.domain.*;
class MemoryRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("Spring1");
		repository.save(member1);
		
		Member result = repository.findByName("Spring1").get();
		System.out.println(member1.equals(result));
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("ABC");
		repository.save(member1);
		
		Member m1 = new Member();
		m1.setName("ABCD");
		repository.save(m1);

		Member m2 = new Member();
		m2.setName("ABCD");
		repository.save(m2);
		
		repository.findAll();
		
		List<Member> result1 = repository.findAll();
		System.out.println(result1.size());
	}
} 
