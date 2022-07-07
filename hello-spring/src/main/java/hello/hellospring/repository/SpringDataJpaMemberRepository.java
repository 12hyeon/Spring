package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository; // findAll, findById 등을 제공

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // spring data jpa가 JpaRepository를 받고 있으면, 구현체를 자동으로 만듬
    @Override
    // JPQL : select m from Member m where m.name = ? 형식으로 만들어줌
    Optional<Member> findByName(String name);
}
