/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Criterion {
    private int criterion_id;
    private double score, weight;
    private String name, description;
    
    public Criterion() {
        this.criterion_id=0;
        this.score=0.0;
        this.weight=0.0;
        this.name=" ";
        this.description=" ";
    }
    
    public Criterion(int criterion_id, double score, double weight, String name, String description) {
        this.criterion_id = criterion_id;
        this.score = score;
        this.weight = weight;
        this.name = name;
        this.description = description;
    }

    public int getCriterion_id() {
        return criterion_id;
    }

    public void setCriterion_id(int criterion_id) {
        this.criterion_id = criterion_id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Criterion{" + "criterion_id=" + criterion_id + 
                ", score=" + score + ", weight=" + weight + 
                ", name=" + name + ", description=" + description + '}';
    }
}
