package ru.morou.tacocloud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ru.morou.tacocloud.Order;
import ru.morou.tacocloud.Taco;
import ru.morou.tacocloud.Ingredient;
import ru.morou.tacocloud.Ingredient.Type;
import ru.morou.tacocloud.data.IngredientRepository;
import ru.morou.tacocloud.data.TacoRepository;

/**
 * @class DesignTacoController - класс отвечает за ингридиенты
 * @Slf4j - которая во время выполнения автоматически генерирует в классе регистратор SLF4J (Simple Logging Facade
 * для Java, https: // www .slf4j.org /).
 * @RequestMapping при применении на уровне класса определяет тип запросов, которые обрабатывает этот контроллер.
 * Спецификация класса @RequestMapping уточняется с помощью аннотации @GetMapping, которая добален к методу
 * showDesignForm (). @GetMapping в паре с классом @RequestMapping указывает, что при получении запроса HTTP GET
 * для / design будет вызываться showDesignForm () для обработки запроса.
 * Обычно @RequestMapping используется только на уровне класса, чтобы указать базовый путь. А для каждого из методов
 * обработчика выполняется через @GetMapping, @PostMapping и т. Д.
 * @PostMapping для обработки запросов POST.
 */

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository tacoRepo;


    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }


    /**
     * showDesignForm() (HTTP-запросы GET) - будет обрабатывать запрос. В завершение метод showDesignForm ()
     * возвращает «дизайн», который представляет собой логическое имя представления, которое будет использоваться
     * для визуализации модели в браузере.
     * @param model - модель с ингридиентами из @method addIngredientsToModel()
     * @return "design" - это логическое имя представления, которое будет использоваться для визуализации моделив браузере.
     */
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    /**
     * processDesign() (POST requests) - метод отвечает за обработку заявок на проектирование тако
     * Когда форма отправляется, поля формы связываются со свойствами объекта Taco (class Taco), который передается
     * в качестве параметра в processDesign ()
     * Аннотация @Valid указывает Spring MVC выполнить проверку отправленного объекта Taco после его привязки к
     * отправленным данным формы и до вызова метода processDesign ().
     * @param errors -
     * @return "redirect:/orders/current" - префикс «redirect:», указывает на то, что это представление с
     *              перенаправлением. Более конкретно, это указывает, что после завершения processDesign () браузер
     *              пользователя должен быть перенаправлен на относительный путь / порядок / текущий. Идея заключается
     *              в том, что после создания тако пользователь будет перенаправлен на форму заказа, из
     *              которой он может разместить заказ на доставку своих созданий тако.
     */
    @PostMapping
    public String processDesign(
            @Valid Taco taco, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = tacoRepo.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}

