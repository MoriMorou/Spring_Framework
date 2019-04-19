package ru.morou.tacocloud.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
//end::baseClass[]
import org.springframework.web.bind.annotation.PostMapping;
//tag::baseClass[]
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import ru.morou.tacocloud.Order;

/**
 * @RequestMapping указывает, что любые методы обработки запросов в этом контроллере будут обрабатывать запросы,
 * путь которых начинается с / orders. В сочетании с уровнем метода @GetMapping он указывает, что метод orderForm ()
 * будет обрабатывать HTTP-запросы GET для / orders / current.
 */


@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    //end::baseClass[]
    //tag::orderForm[]

    /**
     * orderForm() - метод отвечает за обработку запросов
     * @param model
     * @return "orderForm" - возвращает только логическое имя представления orderForm
     */
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order ());
        return "orderForm";
    }
    //end::orderForm[]

/*
//tag::handlePost[]
  @PostMapping
  public String processOrder(Order order) {
    log.info("Order submitted: " + order);
    return "redirect:/";
  }
//end::handlePost[]
*/

    //tag::handlePostWithValidation[]

    /**
     * processOrder() -processOrder () вызывается для обработки отправленного заказа, ему присваивается объект Order,
     * свойства которого привязаны к отправленным полям формы.
     * @param order
     * @param errors
     * @return
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
//end::handlePostWithValidation[]

//tag::baseClass[]

}
//end::baseClass[]