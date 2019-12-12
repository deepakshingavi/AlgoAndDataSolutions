package com.training;

import java.util.*;

class Meal {
    String name;
    List<String> ingredients;

    public Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(name, meal.name) &&
                Objects.equals(ingredients, meal.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients);
    }
}

public class Solution {

    public static int getUniqueMealCount(List<Meal> meals) {


        return (int) meals.stream().map(m -> new HashSet(m.ingredients).hashCode()).distinct().count();
    }

    public static void main(String[] args) {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Basic Burger",Arrays.asList("Lettuce", "Tomato", "Onion", "Patty")));
        meals.add(new Meal("Chief Cheese Burger",Arrays.asList("Cheese", "Tomato", "Patty","Lettuce")));
        meals.add(new Meal("Jay's Burger",Arrays.asList("Lettuce", "Patty", "Onion", "Tomato")));
        meals.add(new Meal("High Water Burger",Arrays.asList("Lettuce", "Tomato", "Onion", "Patty")));
        int dist = getUniqueMealCount(meals);
                System.out.println(dist);
    }
}
