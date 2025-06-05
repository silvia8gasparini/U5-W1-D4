package it.epicode.U5W1D4practice.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Pizza extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean isXl = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Topping> toppingList;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(1012, 4.3);
        this.name = name;
        this.toppingList = toppingList;
        this.isXl = isXl;
        this.calories = setCalories(toppingList, isXl);
        this.price = setPrice(toppingList, isXl);
    }

    public int setCalories(List<Topping> toppingList, boolean isXl) {
        int tot = 1012;
        if (toppingList != null) {
            for (Topping topping : toppingList) {
                tot += topping.getCalories();
            }
        }
        return isXl ? tot + (tot * 5) / 100 : tot;
    }

    public double setPrice(List<Topping> t, boolean isXl) {
        double tot = 4.30;
        if (t != null) {
            for (Topping topping : t) {
                tot += topping.getPrice();
            }
        }
        return isXl ? tot + (tot * 10) / 100 : tot;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", toppingList=" + toppingList +
                ", isXl=" + isXl +
                '}';
    }
}
