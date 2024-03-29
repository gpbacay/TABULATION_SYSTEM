/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Category {
    private int category_id;
    private double weight, total_score;
    private String name, description;

    // Constructors
    public Category() {
        this.category_id = 0;
        this.weight = 0.0;
        this.total_score = 0.0;
        this.name = " ";
        this.description = " ";
    }

    public Category(int category_id, double weight, double total_score, 
            String name, String description) {
        this.category_id = category_id;
        this.weight = weight;
        this.total_score = total_score;
        this.name = name;
        this.description = description;
    }

    // Setters
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters
    public int getCategory_id() {
        return category_id;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotal_score() {
        return total_score;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{" + "category_id=" + category_id +
                ", weight=" + weight +
                ", total_score=" + total_score +
                ", name=" + name +
                ", description=" + description + '}';
    }
}
