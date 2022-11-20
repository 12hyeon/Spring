package jpabook.orignal_jpashop.web;

import jpabook.orignal_jpashop.domain.item.Card;
import jpabook.orignal_jpashop.domain.item.Item;
import jpabook.orignal_jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new CardForm());
        return "items/createItemForm";
    }

    @PostMapping(value = "/items/new")
    public String create(CardForm form) {
        Card book = new Card();
        book.setName(form.getName()); book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setPlace(form.getPlace());
        book.setRealPrice(form.getRealPrice());
        itemService.saveItem(book);
        return "redirect:/items";
    }

    @GetMapping(value = "/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    /**
     * 상품 수정 폼
     */
    @GetMapping(value = "/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model
            model) {
        Card item = (Card) itemService.findOne(itemId);
        CardForm form = new CardForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setPlace(item.getPlace());
        form.setRealPrice(item.getRealPrice());
        model.addAttribute("form", form);
        return "items/updateItemForm";
    }
    /**
     * 상품 수정
     */
    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") CardForm form) {
        Card book = new Card();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice()); book.setStockQuantity(form.getStockQuantity());
        book.setPlace(form.getPlace());
        book.setRealPrice(form.getRealPrice());
        itemService.saveItem(book);
        return "redirect:/items";
    }

    /*상품 수정, 권장 코드
    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form) {
        itemService.updateItem(form.getId(), form.getName(), form.getPrice());
        return "redirect:/items";
    }
     */
}