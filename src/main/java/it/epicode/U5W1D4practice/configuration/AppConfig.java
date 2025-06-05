package it.epicode.U5W1D4practice.configuration;

import it.epicode.U5W1D4practice.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean(name = "toppings_tomato")
    public Topping toppingTomatoBean() {
        return new Topping("Tomato", 0, 0);
    }

    @Bean(name = "toppings_mozzarella")
    public Topping toppingMozzarellaBean() {
        return new Topping("Mozzarella", 92, 0.69);
    }

    @Bean(name = "toppings_mushrooms")
    public Topping toppingMushroomsBean() {
        return new Topping("Mushrooms", 20, 0.99);
    }

    @Bean(name = "toppings_basil")
    public Topping toppingBasilBean() {
        return new Topping("Basil", 0, 0.10);
    }

    @Bean(name = "toppings_anchovies")
    public Topping toppingAnchoviesBean() {
        return new Topping("Anchovies", 86, 1.50);
    }


    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargheritaBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingMozzarellaBean());
        tList.add(toppingBasilBean());
        return new Pizza("Pizza Margherita", tList, false);
    }

    @Bean(name = "super_mario_pizza")
    public Pizza pizzaSuperMarioBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingMozzarellaBean());
        tList.add(toppingMushroomsBean());
        return new Pizza("Super Mario Pizza", tList, false);
    }

    @Bean(name = "marinara_pizza")
    public Pizza pizzaMarinaraBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingAnchoviesBean());
        return new Pizza("Marinara Pizza", tList, false);
    }

    @Bean(name = "super_mario_pizza_xl")
    public Pizza pizzaSuperMarioXlBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingMozzarellaBean());
        tList.add(toppingMushroomsBean());
        return new Pizza("Super Mario Pizza XL", tList, true);
    }

    @Bean(name = "lemonade")
    public Drink lemonadeBean() {
        return new Drink("Lemonade", 128, 1.29);
    }

    @Bean(name = "water")
    public Drink waterBean() {
        return new Drink("Water", 0, 1.29);
    }

    @Bean(name = "beer")
    public Drink beerBean() {
        return new Drink("beer", 200, 7.49);
    }

    @Bean("pizzas")
    List<Pizza> pizzaList() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pizzaMargheritaBean());
        pizzas.add(pizzaSuperMarioBean());
        pizzas.add(pizzaSuperMarioXlBean());
        return pizzas;
    }

    @Bean("drinks")
    List<Drink> drinksList() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(lemonadeBean());
        drinks.add(waterBean());
        drinks.add(beerBean());
        return drinks;
    }

    @Bean("toppings")
    List<Topping> toppingsList() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingTomatoBean());
        toppings.add(toppingMozzarellaBean());
        toppings.add(toppingAnchoviesBean());
        toppings.add(toppingMushroomsBean());
        toppings.add(toppingBasilBean());
        return toppings;
    }


    @Bean("Tavolo1")
    Tavolo getTable1(@Value("${seat.price:2.00}") double seatPrice) {
        return new Tavolo(1, 5, true, seatPrice);
    }

    @Bean("Tavolo2")
    Tavolo getTable2(@Value("${seat.price:2.00}") double seatPrice) {
        return new Tavolo(2, 4, true, seatPrice);
    }

    @Bean("Tavolo3")
    Tavolo getTable3(@Value("${seat.price:2.00}") double seatPrice) {
        return new Tavolo(3, 8, true, seatPrice);
    }
}
