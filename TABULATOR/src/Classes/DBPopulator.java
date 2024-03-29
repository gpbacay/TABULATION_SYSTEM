/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Gianne Bacay
 */
public class DBPopulator {
    
    private static final String MR_CANDIDATES_FILE_PATH = "src\\Databases\\mr_candidates_db.csv";
    private static final String MS_CANDIDATES_FILE_PATH = "src\\Databases\\ms_candidates_db.csv";
    private static final String JUDGES_FILE_PATH = "src\\Databases\\judges_db.csv";
    
    public static void populateMRTableToCSV(JTable table) {
        populateTableToCSV(table, MR_CANDIDATES_FILE_PATH);
    }
    
    public static void populateMSTableToCSV(JTable table) {
        populateTableToCSV(table, MS_CANDIDATES_FILE_PATH);
    }
    
    public static void populateJudgesTableToCSV(JTable table) {
        populateTableToCSV(table, JUDGES_FILE_PATH);
    }
    
    //Database Populators/Updater
    private static void populateTableToCSV(JTable table, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            TableModel model = table.getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            // Write data
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Object value = model.getValueAt(row, col);
                    writer.write(value.toString());
                    if (col < columnCount - 1) {
                        writer.write(",");
                    }
                }
                writer.write(System.lineSeparator());
            }

            JOptionPane.showMessageDialog(null, "Data has been written to CSV file successfully.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing data to CSV file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
