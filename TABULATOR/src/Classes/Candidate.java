/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Candidate {
    private int candidate_id;
    private String title, department, name;

    // Constructors
    public Candidate() {
        this.candidate_id = 0;
        this.title = " ";
        this.department = " ";
        this.name = " ";
    }

    public Candidate(int candidate_id, String title, String department, String name) {
        this.candidate_id = candidate_id;
        this.title = title;
        this.department = department;
        this.name = name;
    }

    // Setters
    public void setCandidateId(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public int getCandidateId() {
        return this.candidate_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Candidate{" + "candidate_id=" + candidate_id +
                ", title=" + title +
                ", department=" + department +
                ", name=" + name + '}';
    }
}

