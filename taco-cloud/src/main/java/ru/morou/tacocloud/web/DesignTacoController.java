package ru.morou.tacocloud.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.morou.tacocloud.Taco;
import ru.morou.tacocloud.Ingredient;
import ru.morou.tacocloud.Ingredient.Type;

/**
 * @DesignTacoController - класс отвечает за ингридиенты
 * @Slf4j - которая во время выполнения автоматически генерирует в классе регистратор SLF4J (Simple Logging Facade
 * для Java, https: // www .slf4j.org /).
 * @RequestMapping при применении на уровне класса определяет тип запросов, которые обрабатывает этот контроллер.
 * Спецификация класса @RequestMapping уточняется с помощью аннотации @GetMapping, которая добален к методу
 * showDesignForm (). @GetMapping в паре с классом @RequestMapping указывает, что при получении запроса HTTP GET
 * для / design будет вызываться showDesignForm () для обработки запроса.
 *
 * Обычно @RequestMapping используется только на уровне класса, чтобы указать базовый путь. А для каждого из методов
 * обработчика выполняется через @GetMapping, @PostMapping и т. Д.
 *
 * @showDesignForm() будет обрабатывать запрос. В завершение метод showDesignForm () возвращает «дизайн», который
 * представляет собой логическое имя представления, которое будет использоваться для визуализации модели в браузере.
 */

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

//end::head[]

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    //tag::showDesignForm[]
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }

//end::showDesignForm[]

/*
//tag::processDesign[]
  @PostMapping
  public String processDesign(Design design) {
    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);

    return "redirect:/orders/current";
  }

//end::processDesign[]
 */

    //tag::processDesignValidated[]
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

//end::processDesignValidated[]

    //tag::filterByType[]
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
    //end::filterByType[]

// tag::foot[]
}
// end::foot[]

