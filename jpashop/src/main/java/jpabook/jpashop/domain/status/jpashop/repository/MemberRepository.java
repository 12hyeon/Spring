package jpabook.orignal_jpashop.domain.status.jpashop.repository;

import jpabook.jpashop.domain.status.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); // 결과를 모두 가져오기
    }


    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }


    public List<Member> findBySchool(String school) {
        return em.createQuery("select m from Member m where m.school = :school", Member.class)
                .setParameter("school", school)
                .getResultList();
    }
/*
    public List<Member> findBySchool(String school) {
        return em.createQuery("select m from Member m where m.school = :school", Member.class)
                .setParameter("school", school)
                .getResultList();
    }

    public List<Member> findByStation(String station) {
        return em.createQuery("select m from Member m where m.station = :station", Member.class)
                .setParameter("station", station)
                .getResultList();
    }
    */
}