/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Gianne Bacay
 */
public class HTPopulator {
    //Database File Path
    private static final String MR_CANDIDATES_FILE_PATH = "src\\Databases\\mr_candidates_db.csv";
    private static final String MS_CANDIDATES_FILE_PATH = "src\\Databases\\ms_candidates_db.csv";
    private static final String JUDGES_FILE_PATH = "src\\Databases\\judges_db.csv";
    
    //Hash Table
    private static final Hashtable<Integer, Candidate> MRCHashtable = new Hashtable<>();
    private static final Hashtable<Integer, Candidate> MSCHashtable = new Hashtable<>();
    private static final Hashtable<Integer, Judge> judgesHashtable = new Hashtable<>();


    //Getters
    public static Hashtable<Integer, Candidate> getMRCHashtable() {
        return MRCHashtable;
    }
    public static Hashtable<Integer, Candidate> getMSCHashtable() {
        return MSCHashtable;
    }
    public static Hashtable<Integer, Judge> getJudgesHashtable() {
        return judgesHashtable;
    }

    //Populators
    // Method to populate MR Candidates Hashtable
    public static Hashtable<Integer, Candidate> populateMRCHashtable(Hashtable<Integer, Candidate> hashtable) {
        hashtable.clear();
        File mrCandidatesFile = new File(MR_CANDIDATES_FILE_PATH);

        try (Scanner input = new Scanner(mrCandidatesFile)) {
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(",");
                int candidateId = Integer.parseInt(line[0].trim());
                String title = line[1].trim();
                String department = line[2].trim();
                String name = line[3].trim();

                Candidate mrCandidate = new Candidate(candidateId, title, department, name);

                MRCHashtable.put(candidateId, mrCandidate);
            }
            System.out.println("MR Candidates Hashtable has been populated with data from the CSV file.");
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer: " + e.getMessage());
        }
        return MRCHashtable;
    }
    
    // Method to populate MS Candidates Hashtable
    public static Hashtable<Integer, Candidate> populateMSCHashtable(Hashtable<Integer, Candidate> hashtable) {
        hashtable.clear();
        File msCandidatesFile = new File(MS_CANDIDATES_FILE_PATH);

        try (Scanner input = new Scanner(msCandidatesFile)) {
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(",");
                int candidateId = Integer.parseInt(line[0].trim());
                String title = line[1].trim();
                String department = line[2].trim();
                String name = line[3].trim();

                Candidate msCandidate = new Candidate(candidateId, title, department, name);

                MSCHashtable.put(candidateId, msCandidate);
            }
            System.out.println("MS Candidates Hashtable has been populated with data from the CSV file.");
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer: " + e.getMessage());
        }
        return MSCHashtable;
    }
    
    // Method to populate Judges Hashtable
    public static void populateJudgesHashtable(Hashtable<Integer, Judge> hashtable) {
        hashtable.clear();
        File judgesFile = new File(JUDGES_FILE_PATH);

        try (Scanner input = new Scanner(judgesFile)) {
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(",");
                int judgeId = Integer.parseInt(line[0].trim());
                String name = line[1].trim();
                String affiliation = line[2].trim();

                Judge judge = new Judge(judgeId, name, affiliation);
                judgesHashtable.put(judgeId, judge);
            }
            System.out.println("Judges Hashtable has been populated with data from the CSV file.");
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer: " + e.getMessage());
        }
    }
}
