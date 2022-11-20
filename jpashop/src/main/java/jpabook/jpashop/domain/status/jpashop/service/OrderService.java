package jpabook.orignal_jpashop.domain.status.jpashop.service;

import jpabook.jpashop.domain.status.jpashop.domain.*;
import jpabook.jpashop.domain.status.jpashop.domain.item.Item;
import jpabook.jpashop.domain.status.jpashop.domain.status.DeliveryStatus;
import jpabook.orignal_jpashop.domain.status.jpashop.repository.DeliveryRepository;
import jpabook.orignal_jpashop.domain.status.jpashop.repository.ItemRepository;
import jpabook.orignal_jpashop.domain.status.jpashop.repository.MemberRepository;
import jpabook.orignal_jpashop.domain.status.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final DeliveryRepository deliveryRepository;

    /** 주문 */
    @Transactional
    public Long order(String memberEmail, String itemName, int count, String email) { // 받는 사람 이메일 받기
        //엔티티 조회
        Member member = memberRepository.findByEmail(memberEmail).get(0);
        Item item = itemRepository.findByName(itemName).get(0);

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, count);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setReceiver(email);
        delivery.setStatus(DeliveryStatus.READY);

        //주문 생성
        Member member2 = memberRepository.findByEmail(email).get(0);
        Order order = Order.createOrder(member, delivery, member2, orderItem);

        //주문 저장
        return orderRepository.save(order);
    }


    /** 주문 취소 */
    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소
        order.cancel();

        Delivery delivery = order.getDelivery();
        deliveryRepository.remove(delivery);
    }

    /** 주문 검색 */
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByString(orderSearch); // jpql 상태
    }
}