/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Judge {
    private int judge_id;
    private String name, affiliation;
    
    // Constructors
    public Judge() {
        this.judge_id = 0;
        this.name = " ";
        this.affiliation = " ";
    }

    public Judge(int judge_id, String name, String affiliation) {
        this.judge_id = judge_id;
        this.name = name;
        this.affiliation = affiliation;
    }

    public int getJudge_id() {
        return judge_id;
    }

    public void setJudge_id(int judge_id) {
        this.judge_id = judge_id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public String toString() {
        return "Judge{" + "judge_id=" + judge_id + ", name=" + name + 
                ", affiliation=" + affiliation + '}';
    }
}
