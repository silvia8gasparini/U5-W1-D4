package it.epicode.U5W1D4practice;

import it.epicode.U5W1D4practice.bean.*;
import it.epicode.U5W1D4practice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersRunner implements CommandLineRunner {

    @Autowired private ApplicationContext ctx;
    @Autowired private PizzaRepository pizzaRepo;
    @Autowired private DrinkRepository drinkRepo;
    @Autowired private ToppingRepository toppingRepo;
    @Autowired private TavoloRepository tableRepo;
    @Autowired private OrdineRepository orderRepo;

    @Override
    public void run(String... args) {

        // Recupera i bean
        List<Pizza> pizzas = ctx.getBean("pizzas", List.class);
        List<Drink> drinks = ctx.getBean("drinks", List.class);
        List<Topping> toppings = ctx.getBean("toppings", List.class);

        Tavolo t1 = ctx.getBean("Tavolo1", Tavolo.class);
        Tavolo t2 = ctx.getBean("Tavolo2", Tavolo.class);
        Tavolo t3 = ctx.getBean("Tavolo3", Tavolo.class);

        pizzaRepo.saveAll(pizzas);
        drinkRepo.saveAll(drinks);
        toppingRepo.saveAll(toppings);
        tableRepo.saveAll(List.of(t1, t2, t3));

        Ordine o1 = new Ordine(4, t1);
        o1.addPizza(ctx.getBean("pizza_margherita", Pizza.class));
        o1.addPizza(ctx.getBean("super_mario_pizza", Pizza.class));
        o1.addPizza(ctx.getBean("super_mario_pizza_xl", Pizza.class));
        o1.addDrink(ctx.getBean("lemonade", Drink.class));
        o1.addDrink(ctx.getBean("lemonade", Drink.class));
        o1.addDrink(ctx.getBean("beer", Drink.class));


        orderRepo.save(o1);

        System.out.println("DETTAGLI ORDINE SALVATO:");
        o1.print();

        System.out.println("TOTALE: €" + o1.getTotal());
    }
}
