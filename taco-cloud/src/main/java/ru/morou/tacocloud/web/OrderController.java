package ru.morou.tacocloud.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.morou.tacocloud.Order;
import ru.morou.tacocloud.data.OrderRepository;

/**
 * @RequestMapping указывает, что любые методы обработки запросов в этом контроллере будут обрабатывать запросы,
 * путь которых начинается с / orders. В сочетании с уровнем метода @GetMapping он указывает, что метод orderForm ()
 * будет обрабатывать HTTP-запросы GET для / orders / current.
 */

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    /**
     * processOrder() -processOrder () вызывается для обработки отправленного заказа, ему присваивается объект Order,
     * свойства которого привязаны к отправленным полям формы.
     * @param order
     * @param errors
     * @return
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}