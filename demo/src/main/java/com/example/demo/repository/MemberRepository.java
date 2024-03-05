package com.example.demo.repository;

import java.util.Optional;
import java.util.List;
import com.example.demo.domain.*;

public interface MemberRepository {
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
  
}
