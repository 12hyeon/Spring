package jpabook.orignal_jpashop.repository;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository {

    private final EntityManager em;

    // 배달 시작
    public Long save(Delivery delivery) {
        em.persist(delivery);
        return delivery.getId();
/*        if (delivery.getId() == null) {
            em.persist(delivery);
        } else {
            em.merge(delivery); //  detached 된 상태 -> persist 상태
        }*/
    }

    public Delivery findOne(Long id) {
        return em.find(Delivery.class, id);
    }

    public void remove(Delivery delivery) {
        em.remove(delivery);
    }
}