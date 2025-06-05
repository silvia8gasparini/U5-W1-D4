package it.epicode.U5W1D4practice.bean;

import it.epicode.U5W1D4practice.enumeration.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@NoArgsConstructor
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private State state;

    private int numCoperti;

    private LocalTime oraAcquisizione;

    @ManyToMany
    private List<Pizza> orderedPizzas = new ArrayList<>();

    @ManyToMany
    private List<Drink> orderedDrinks = new ArrayList<>();

    @ManyToOne
    private Tavolo tavolo;

    public Ordine(int numCoperti, Tavolo tavolo) {
        if (tavolo.getNumMaxCoperti() <= numCoperti)
            throw new RuntimeException("Numero coperti maggiore di numero massimo posti sul tavolo!");
        this.state = State.IN_CORSO;
        this.numCoperti = numCoperti;
        this.oraAcquisizione = LocalTime.now();
        this.tavolo = tavolo;
    }

    public void addPizza(Pizza pizza) {
        this.orderedPizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        this.orderedDrinks.add(drink);
    }

    public double getTotal() {
        double total = 0;
        total += orderedPizzas.stream().mapToDouble(Pizza::getPrice).sum();
        total += orderedDrinks.stream().mapToDouble(Drink::getPrice).sum();
        total += tavolo.getCostoCoperto() * numCoperti;
        return total;
    }

    public void print() {
        System.out.println("id ordine--> " + id);
        System.out.println("stato--> " + state);
        System.out.println("numero coperti--> " + numCoperti);
        System.out.println("ora acquisizione--> " + oraAcquisizione);
        System.out.println("numero tavolo--> " + tavolo.getNumTable());

        System.out.println("Pizze ordinate:");
        orderedPizzas.forEach(System.out::println);

        System.out.println("Bevande ordinate:");
        orderedDrinks.forEach(System.out::println);

        System.out.println("Totale: €" + getTotal());
    }
}
