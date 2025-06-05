package it.epicode.U5W1D4practice.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@Component
public class Menu {
    private List<Pizza> pizzaList;
    private List<Drink> drinkList;
    private List<Topping> toppingList;

    public void printMenu() {
        System.out.println("******* Menu *******");
        System.out.println("PIZZAS");
        pizzaList.forEach(System.out::println);
        System.out.println("TOPPINGS");
        toppingList.forEach(System.out::println);
        System.out.println("DRINKS");
        drinkList.forEach(System.out::println);
    }
}
