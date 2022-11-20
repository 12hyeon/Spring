package jpabook.orignal_jpashop.web;

import jpabook.orignal_jpashop.domain.Member;
import jpabook.orignal_jpashop.domain.Order;
import jpabook.orignal_jpashop.domain.OrderSearch;
import jpabook.orignal_jpashop.domain.item.Item;
import jpabook.orignal_jpashop.service.ItemService;
import jpabook.orignal_jpashop.service.MemberService;
import jpabook.orignal_jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping(value = "/order")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();
        model.addAttribute("members", members);
        model.addAttribute("items", items);
        return "order/orderForm";
    }

    @PostMapping(value = "/order")
    public String order(@RequestParam("member") String member,
                        @RequestParam("item") String item,
                        @RequestParam("count") int count,
                        @RequestParam("email") String email) {
        orderService.order(member, item, count, email);
        return "redirect:/orders";
    }

    @PostMapping(value = "/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }

    /*
    @GetMapping(value = "/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }
     */
}