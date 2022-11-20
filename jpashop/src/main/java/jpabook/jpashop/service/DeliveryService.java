package jpabook.orignal_jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.status.DeliveryStatus;
import jpabook.orignal_jpashop.repository.DeliveryRepository;
import jpabook.orignal_jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryService {

    private final MemberRepository memberRepository;
    private final DeliveryRepository deliveryRepository;

    /** 배달 시작 */
    @Transactional
    public Delivery startDelivery(Long memberId, Long deliveryId) {
        Member member = memberRepository.findOne(memberId);
        Delivery delivery = deliveryRepository.findOne(deliveryId);

        if (delivery.getReceiver() == member.getEmail()) {
            delivery.setAddress(member.getAddress());
            delivery.setStatus(DeliveryStatus.COMP);
        }
        else {
            throw new IllegalStateException("잘못된 상품의 선물의 전달을 신청하셨습니다.");
        }
        return delivery;
    }

    public Delivery find(Long id) {
        return deliveryRepository.findOne(id);
    }
}

