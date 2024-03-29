package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import com.example.demo.domain.*;
import com.example.demo.repository.*;
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository mr) {	
		this.memberRepository = mr;
	}
	
	
	public Long join(Member member) {
		// 같은 이름이 있는 경우 가입 X
		
	memberRepository.findByName(member.getName())
		.ifPresent(m-> {throw new IllegalStateException("이미 존재하는 회원입니다");}
		);
		
		
		memberRepository.save(member);
		return member.getId();
	}
	
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long MemberId) {
		return memberRepository.findById(MemberId);
		
	}
}
