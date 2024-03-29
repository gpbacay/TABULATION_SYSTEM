/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Classes.Candidate;
import static Classes.DBPopulator.populateJudgesTableToCSV;
import static Classes.HTPopulator.getMRCHashtable;
import static Classes.HTPopulator.getMSCHashtable;
import static Classes.HTPopulator.populateMRCHashtable;
import static Classes.HTPopulator.populateMSCHashtable;
import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import static Classes.DBPopulator.populateMRTableToCSV;
import static Classes.DBPopulator.populateMSTableToCSV;
import static Classes.HTPopulator.getJudgesHashtable;
import static Classes.HTPopulator.populateJudgesHashtable;
import Classes.Judge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 *
 * @author Gianne Bacay
 */
public class tabulationSystem extends javax.swing.JFrame {
    
    public static Thread updateSidebarBtns;
    public static Thread updateSelectedRow;
    
    public tabulationSystem() {
        initComponents();
        
        //Initialize Tables
        populateMRCHashtable(getMRCHashtable());
        populateMSCHashtable(getMSCHashtable());
        populateJudgesHashtable(getJudgesHashtable());
        
        
        //Add Filter and Searchbox
        filterTable(jTextField2,jComboBox8,jTable2);
        filterTable(jTextField3,jComboBox9,jTable3);
        filterTable(jTextField4,jComboBox10,jTable4);
        
        //Landing Page:
        L1_LandingPage.setVisible(true);
        L2_Homepage.setVisible(false);
        
        //HomePage Pages:
        sidebar_toggler_btn.setSelected(false);
        dashboard_btn.setSelected(true);
        categories_btn.setSelected(false);
        candidates_btn.setSelected(false);
        judges_btn.setSelected(false);
        about_btn.setSelected(false);
        exit_btn.setSelected(false);
        
        //Threads:
        
        updateSidebarBtns = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(tabulationSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Dashboard
                    if(dashboard_btn.isSelected()){
                        dashboard_btn.setForeground(new Color(255,186,0));
                        dashboard_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\dashboard_hover.png"));
                    }
                    else {
                        dashboard_btn.setForeground(new Color(255,255,255));
                        dashboard_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\dashboard.png"));
                    }
                    
                    //Categories
                    if(categories_btn.isSelected()){
                        categories_btn.setForeground(new Color(255,186,0));
                        categories_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\categories_hover.png"));
                    }
                    else {
                        categories_btn.setForeground(new Color(255,255,255));
                        categories_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\categories.png"));
                    }
                    
            
                    //Candidates
                    if(candidates_btn.isSelected()){
                        candidates_btn.setForeground(new Color(255,186,0));
                        candidates_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\candidates_hover.png"));
                    }
                    else {
                        candidates_btn.setForeground(new Color(255,255,255));
                        candidates_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\candidates.png"));
                    }

                    //Judges
                    if(judges_btn.isSelected()){
                        judges_btn.setForeground(new Color(255,186,0));
                        judges_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\judges_hover.png"));
                    }
                    else {
                        judges_btn.setForeground(new Color(255,255,255));
                        judges_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\judges.png"));
                    }

                    //About
                    if(about_btn.isSelected()){
                        about_btn.setForeground(new Color(255,186,0));
                        about_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\about_hover.png"));
                    }
                    else {
                        about_btn.setForeground(new Color(255,255,255));
                        about_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\about.png"));
                    }
                }
            }
        );
        updateSidebarBtns.start();
        
        L2_P1_Dashboard.setVisible(true);
        L2_P2_Categories.setVisible(false);
        L2_P3_Candidates.setVisible(false);
        L2_P4_Judges.setVisible(false);
        
        //Dashboard
            
        //Categories
            
        //Candidates
        //MR Candidates
        populateCandidatesTable(jTable2,getMRCHashtable());
        jTable2.setRowSelectionInterval(0, 0);
        
        String candidateId = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String candidateName = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
        String candidateDepartment = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();
        
        candidateNum.setText(candidateId);
        candidateName3.setText(candidateName);
        jLabel12.setText(candidateDepartment);
        
        
        //MS Candidates
        populateCandidatesTable(jTable3,getMSCHashtable());
        jTable3.setRowSelectionInterval(0, 0);

        String candidateId1 = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
        String candidateName1 = jTable3.getValueAt(jTable3.getSelectedRow(), 3).toString();
        String candidateDepartment1 = jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString();
        
        candidateNum1.setText(candidateId1);
        candidateName4.setText(candidateName1);
        jLabel14.setText(candidateDepartment1);
            
        //Judges
        populateJudgesTable(jTable4, getJudgesHashtable());
        jTable4.setRowSelectionInterval(0, 0);
        
        String judgeId = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
        String judgeName = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();
        String judgeAffiliation = jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString();
        
        judgeNumber1.setText(judgeId);
        judgeName1.setText(judgeName);
        jLabel13.setText(judgeAffiliation);
        
            
        //About
            
        //Exit
            
    
    }
    
    public static void centerTableItems(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public static void setComboBoxNames(JTable table, JComboBox comboBox) {
        // Clear existing items
        comboBox.removeAllItems();
        
        // Get the column count
        int columnCount = table.getColumnCount();
        
        // Get the table column model
        TableColumnModel columnModel = table.getColumnModel();
        
        // Iterate over each column header and add it to the combo box
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            Object headerValue = columnModel.getColumn(columnIndex).getHeaderValue();
            comboBox.addItem(headerValue.toString());
        }
    }
    
    // Method to sort the table's ID column in ascending order
//    public static void sortTableByIdAscending(JTable table) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        int selectedRow = table.getSelectedRow(); // Store the index of the selected row
//
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
//
//        // Set the comparator to compare integers
//        Comparator<Integer> comparator = Comparator.comparingInt(id -> id);
//        sorter.setComparator(0, comparator); // Assuming ID is in the first column
//
//        // Apply the row sorter to the table
//        table.setRowSorter(sorter);
//
//        // Sort the table
//        sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
//        sorter.sort();
//
//        // Restore selection
//        if (selectedRow != -1) {
//            int modelIndex = table.convertRowIndexToModel(selectedRow);
//            table.setRowSelectionInterval(modelIndex, modelIndex);
//        }
//    }
    
    // Method to sort the table based on the selected item in the JComboBox and search text in the JTextField
    public static void filterTable(JTextField searchBar, JComboBox<String> filterComboBox, JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        
        //Rename jComboBox items
        setComboBoxNames(jTable,filterComboBox);

        searchBar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }

            private void filter() {
                String text = searchBar.getText();
                int columnIndex = filterComboBox.getSelectedIndex();
                if (text.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
                }
                jTable.setRowSelectionInterval(0, 0);
            }
        });
    }

    
    // Populate Tables
    public static void populateCandidatesTable(JTable table, Hashtable<Integer, Candidate> candidateHashtable) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Clear the tables before populating to prevent duplicates
        model.setRowCount(0);

        // Create a list to store entries of the hashtable
        ArrayList<Map.Entry<Integer, Candidate>> entryList = new ArrayList<>(candidateHashtable.entrySet());

        // Sort the list in reverse order
        Collections.reverse(entryList);

        // Populate the table with Candidates
        for (Map.Entry<Integer, Candidate> entry : entryList) {
            Candidate value = entry.getValue();
            model.addRow(new Object[]{
                value.getCandidateId(), value.getTitle(), value.getDepartment(),
                value.getName()
            });
        }

        // Center the items per column
        centerTableItems(table);
    }
    
    public static void populateJudgesTable(JTable table, Hashtable<Integer, Judge> candidateHashtable) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Clear the tables before populating to prevent duplicates
        model.setRowCount(0);

        // Create a list to store entries of the hashtable
        ArrayList<Map.Entry<Integer, Judge>> entryList = new ArrayList<>(candidateHashtable.entrySet());

        // Sort the list in reverse order
        Collections.reverse(entryList);

        // Populate the table with Candidates
        for (Map.Entry<Integer, Judge> entry : entryList) {
            Judge value = entry.getValue();
            model.addRow(new Object[]{
                value.getJudge_id(), value.getName(), value.getAffiliation()
            });
        }

        // Center the items per column
        centerTableItems(table);
    }
    
    public static void goToPreviousRow(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != - 1 && selectedRow < table.getRowCount() + 1) {
            int nextRow = selectedRow - 1;
            table.setRowSelectionInterval(nextRow, nextRow);
        }
    }
    
    public static void goToNextRow(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1 && selectedRow < table.getRowCount() - 1) {
            int nextRow = selectedRow + 1;
            table.setRowSelectionInterval(nextRow, nextRow);
        }
    }
    
    //Row Adders
    //Add Candidate Row
    public static void addCandidateTableRow(JTable table, String title) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount() + 1;
        
        model.addRow(new Object[] {
            rowCount, title, " ", " "
        });
    }
    //Add Judge Row
    public static void addJudgeTableRow(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount() + 1;
        
        model.addRow(new Object[] {
            rowCount,  " ", " "
        });
    }
    
    public static void deleteSelectedTableRow(JTable table) {
        int rowIndex = table.getSelectedRow(); //start at 0
        table.setRowSelectionInterval(rowIndex, rowIndex);

        if (rowIndex != -1) { // If a row is selected
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
            int selectedId = (int) table.getValueAt(rowIndex, 0);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                for(int i=0;i<selectedId;i++) {
                    if(i==selectedId-1) {
                        model.removeRow(i);
                        break;
                    }
                }
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L1_LandingPage = new javax.swing.JLayeredPane();
        start_btn = new javax.swing.JButton();
        L1_BG = new javax.swing.JLabel();
        L2_Homepage = new javax.swing.JLayeredPane();
        L2_Sidebar = new javax.swing.JLayeredPane();
        dashboard_btn = new javax.swing.JButton();
        categories_btn = new javax.swing.JButton();
        candidates_btn = new javax.swing.JButton();
        judges_btn = new javax.swing.JButton();
        about_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        logo_title = new javax.swing.JLabel();
        logo_img_container = new javax.swing.JLabel();
        dashboard_icon_btn = new javax.swing.JLabel();
        categories_icon_btn = new javax.swing.JLabel();
        candidates_icon_btn = new javax.swing.JLabel();
        judges_icon_btn = new javax.swing.JLabel();
        about_icon_btn = new javax.swing.JLabel();
        exit_icon_btn = new javax.swing.JLabel();
        L2_Sidebar_BG = new javax.swing.JLabel();
        L2_SidebarToggler = new javax.swing.JLayeredPane();
        sidebar_toggler_btn = new javax.swing.JButton();
        sidebar_toggler_BG = new javax.swing.JLabel();
        L2_MainPage = new javax.swing.JLayeredPane();
        L2_P1_Dashboard = new javax.swing.JLayeredPane();
        pageTitle1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        MS_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        MR_table = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        MS_LB_table = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        MR_LB_table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MR_title = new javax.swing.JLabel();
        MS_title = new javax.swing.JLabel();
        candidateName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        candidateName1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        L2_Dashboard_BG = new javax.swing.JLabel();
        L2_P2_Categories = new javax.swing.JLayeredPane();
        pageTitle2 = new javax.swing.JLabel();
        cat_weight = new javax.swing.JLabel();
        cat_description = new javax.swing.JLabel();
        candidateName2 = new javax.swing.JLabel();
        categoryNum = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        L2_Categories_BG = new javax.swing.JLabel();
        L2_P3_Candidates = new javax.swing.JLayeredPane();
        title2 = new javax.swing.JLabel();
        candidateName3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton30 = new javax.swing.JButton();
        candidateNum1 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        title3 = new javax.swing.JLabel();
        candidateName4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox9 = new javax.swing.JComboBox<>();
        candidateNum = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        L2_Candidates_BG1 = new javax.swing.JLabel();
        L2_P4_Judges = new javax.swing.JLayeredPane();
        judgeNumber1 = new javax.swing.JLabel();
        judgeName1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        L2_Judges_BG = new javax.swing.JLabel();
        L2_MainPage_BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L1_LandingPage.setMaximumSize(new java.awt.Dimension(1366, 768));
        L1_LandingPage.setMinimumSize(new java.awt.Dimension(1366, 768));
        L1_LandingPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        start_btn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        start_btn.setForeground(new java.awt.Color(102, 51, 255));
        start_btn.setBorderPainted(false);
        start_btn.setContentAreaFilled(false);
        start_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                start_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                start_btnMouseExited(evt);
            }
        });
        start_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_btnActionPerformed(evt);
            }
        });
        L1_LandingPage.add(start_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 230, 70));

        L1_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/landingpage_bg.png"))); // NOI18N
        L1_LandingPage.add(L1_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(L1_LandingPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_Homepage.setAlignmentX(0.0F);
        L2_Homepage.setAlignmentY(0.0F);
        L2_Homepage.setMaximumSize(new java.awt.Dimension(1366, 768));
        L2_Homepage.setMinimumSize(new java.awt.Dimension(1366, 768));
        L2_Homepage.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        L2_Sidebar.setMaximumSize(new java.awt.Dimension(278, 768));
        L2_Sidebar.setPreferredSize(new java.awt.Dimension(278, 768));
        L2_Sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dashboard_btn.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_btn.setText("Dashboard");
        dashboard_btn.setBorder(null);
        dashboard_btn.setBorderPainted(false);
        dashboard_btn.setContentAreaFilled(false);
        dashboard_btn.setMaximumSize(new java.awt.Dimension(278, 768));
        dashboard_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        dashboard_btn.setPreferredSize(new java.awt.Dimension(278, 768));
        dashboard_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseExited(evt);
            }
        });
        dashboard_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboard_btnActionPerformed(evt);
            }
        });
        L2_Sidebar.add(dashboard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 70));

        categories_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categories_btn.setForeground(new java.awt.Color(255, 255, 255));
        categories_btn.setText("Categories");
        categories_btn.setBorder(null);
        categories_btn.setBorderPainted(false);
        categories_btn.setContentAreaFilled(false);
        categories_btn.setMaximumSize(new java.awt.Dimension(278, 768));
        categories_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        categories_btn.setPreferredSize(new java.awt.Dimension(278, 768));
        categories_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                categories_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                categories_btnMouseExited(evt);
            }
        });
        categories_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categories_btnActionPerformed(evt);
            }
        });
        L2_Sidebar.add(categories_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 70));

        candidates_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        candidates_btn.setForeground(new java.awt.Color(255, 255, 255));
        candidates_btn.setText("Candidates");
        candidates_btn.setBorder(null);
        candidates_btn.setBorderPainted(false);
        candidates_btn.setContentAreaFilled(false);
        candidates_btn.setMaximumSize(new java.awt.Dimension(278, 768));
        candidates_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        candidates_btn.setPreferredSize(new java.awt.Dimension(278, 768));
        candidates_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                candidates_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                candidates_btnMouseExited(evt);
            }
        });
        candidates_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                candidates_btnActionPerformed(evt);
            }
        });
        L2_Sidebar.add(candidates_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, 70));

        judges_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        judges_btn.setForeground(new java.awt.Color(255, 255, 255));
        judges_btn.setText("Judges");
        judges_btn.setBorder(null);
        judges_btn.setBorderPainted(false);
        judges_btn.setContentAreaFilled(false);
        judges_btn.setMaximumSize(new java.awt.Dimension(278, 768));
        judges_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        judges_btn.setPreferredSize(new java.awt.Dimension(278, 768));
        judges_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                judges_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                judges_btnMouseExited(evt);
            }
        });
        judges_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judges_btnActionPerformed(evt);
            }
        });
        L2_Sidebar.add(judges_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, 70));

        about_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        about_btn.setForeground(new java.awt.Color(255, 255, 255));
        about_btn.setText("About");
        about_btn.setBorder(null);
        about_btn.setBorderPainted(false);
        about_btn.setContentAreaFilled(false);
        about_btn.setMaximumSize(new java.awt.Dimension(278, 768));
        about_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        about_btn.setPreferredSize(new java.awt.Dimension(278, 768));
        about_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                about_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                about_btnMouseExited(evt);
            }
        });
        about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btnActionPerformed(evt);
            }
        });
        L2_Sidebar.add(about_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, 70));

        exit_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exit_btn.setForeground(new java.awt.Color(255, 255, 255));
        exit_btn.setText("Exit");
        exit_btn.setBorder(null);
        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.setMaximumSize(new java.awt.Dimension(278, 768));
        exit_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        exit_btn.setPreferredSize(new java.awt.Dimension(278, 768));
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btnMouseExited(evt);
            }
        });
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        L2_Sidebar.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, 70));

        logo_title.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        logo_title.setForeground(new java.awt.Color(255, 255, 255));
        logo_title.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logo_title.setText("TABULATION SYSTEM");
        logo_title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_titleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_titleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_titleMouseExited(evt);
            }
        });
        L2_Sidebar.add(logo_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 40));

        logo_img_container.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo_img_container.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_bnw.png"))); // NOI18N
        logo_img_container.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_img_containerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_img_containerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_img_containerMouseExited(evt);
            }
        });
        L2_Sidebar.add(logo_img_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, -1));

        dashboard_icon_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_icon_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/dashboard.png"))); // NOI18N
        dashboard_icon_btn.setToolTipText("Dashboard");
        dashboard_icon_btn.setAlignmentY(0.0F);
        L2_Sidebar.add(dashboard_icon_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 70));

        categories_icon_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categories_icon_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/categories.png"))); // NOI18N
        categories_icon_btn.setToolTipText("Category");
        L2_Sidebar.add(categories_icon_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 60, 70));

        candidates_icon_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        candidates_icon_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/candidates.png"))); // NOI18N
        L2_Sidebar.add(candidates_icon_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 60, 70));

        judges_icon_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judges_icon_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/judges.png"))); // NOI18N
        L2_Sidebar.add(judges_icon_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 60, 70));

        about_icon_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_icon_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/about.png"))); // NOI18N
        L2_Sidebar.add(about_icon_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 70, 70));

        exit_icon_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_icon_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/exit.png"))); // NOI18N
        L2_Sidebar.add(exit_icon_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 70, 70));

        L2_Sidebar_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/sidebar.png"))); // NOI18N
        L2_Sidebar_BG.setAlignmentY(0.0F);
        L2_Sidebar_BG.setMaximumSize(new java.awt.Dimension(278, 768));
        L2_Sidebar_BG.setMinimumSize(new java.awt.Dimension(0, 0));
        L2_Sidebar_BG.setPreferredSize(new java.awt.Dimension(278, 768));
        L2_Sidebar.add(L2_Sidebar_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_Homepage.add(L2_Sidebar);

        L2_SidebarToggler.setMaximumSize(new java.awt.Dimension(30, 770));
        L2_SidebarToggler.setMinimumSize(new java.awt.Dimension(30, 770));
        L2_SidebarToggler.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/sidebar_icon.png"))); // NOI18N
        sidebar_toggler_btn.setBorder(null);
        sidebar_toggler_btn.setBorderPainted(false);
        sidebar_toggler_btn.setContentAreaFilled(false);
        sidebar_toggler_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sidebar_toggler_btn.setMaximumSize(new java.awt.Dimension(30, 770));
        sidebar_toggler_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        sidebar_toggler_btn.setPreferredSize(new java.awt.Dimension(30, 770));
        sidebar_toggler_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidebar_toggler_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidebar_toggler_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidebar_toggler_btnMouseExited(evt);
            }
        });
        sidebar_toggler_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebar_toggler_btnActionPerformed(evt);
            }
        });
        L2_SidebarToggler.add(sidebar_toggler_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        sidebar_toggler_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/dashboard_bg.png"))); // NOI18N
        sidebar_toggler_BG.setAlignmentY(0.0F);
        sidebar_toggler_BG.setMaximumSize(new java.awt.Dimension(30, 770));
        sidebar_toggler_BG.setMinimumSize(new java.awt.Dimension(0, 0));
        sidebar_toggler_BG.setPreferredSize(new java.awt.Dimension(30, 770));
        L2_SidebarToggler.add(sidebar_toggler_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_Homepage.add(L2_SidebarToggler);

        L2_MainPage.setMaximumSize(new java.awt.Dimension(1366, 768));
        L2_MainPage.setPreferredSize(new java.awt.Dimension(1366, 768));
        L2_MainPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L2_P1_Dashboard.setMaximumSize(new java.awt.Dimension(1370, 720));
        L2_P1_Dashboard.setMinimumSize(new java.awt.Dimension(1370, 720));
        L2_P1_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pageTitle1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        pageTitle1.setForeground(new java.awt.Color(255, 255, 255));
        pageTitle1.setText("DASHBOARD");
        L2_P1_Dashboard.add(pageTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 660, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judge 1", "judge 2" }));
        L2_P1_Dashboard.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 150, 80, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category 1", "Category 2" }));
        L2_P1_Dashboard.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 150, -1, 30));

        MS_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Candidate #", "Category 1", "Category 2", "Category 3", "Category 4", "Category 5", "Category 6", "Category 7", "Category 8", "Category 9", "Category 10", "Total Score", "Rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MS_table.setAlignmentX(0.0F);
        MS_table.setAlignmentY(0.0F);
        MS_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(MS_table);
        if (MS_table.getColumnModel().getColumnCount() > 0) {
            MS_table.getColumnModel().getColumn(0).setResizable(false);
            MS_table.getColumnModel().getColumn(0).setPreferredWidth(75);
            MS_table.getColumnModel().getColumn(11).setResizable(false);
            MS_table.getColumnModel().getColumn(11).setPreferredWidth(75);
            MS_table.getColumnModel().getColumn(12).setResizable(false);
            MS_table.getColumnModel().getColumn(12).setPreferredWidth(40);
        }

        L2_P1_Dashboard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 950, 230));

        MR_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Candidate #", "Category 1", "Category 2", "Category 3", "Category 4", "Category 5", "Category 6", "Category 7", "Category 8", "Category 9", "Category 10", "Total Score", "Rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MR_table.setAlignmentX(0.0F);
        MR_table.setAlignmentY(0.0F);
        MR_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(MR_table);
        if (MR_table.getColumnModel().getColumnCount() > 0) {
            MR_table.getColumnModel().getColumn(0).setResizable(false);
            MR_table.getColumnModel().getColumn(0).setPreferredWidth(75);
            MR_table.getColumnModel().getColumn(11).setResizable(false);
            MR_table.getColumnModel().getColumn(11).setPreferredWidth(75);
            MR_table.getColumnModel().getColumn(12).setResizable(false);
            MR_table.getColumnModel().getColumn(12).setPreferredWidth(40);
        }

        L2_P1_Dashboard.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 157, 950, 230));

        MS_LB_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Candidate #", "Score", "Rank"
            }
        ));
        jScrollPane5.setViewportView(MS_LB_table);
        if (MS_LB_table.getColumnModel().getColumnCount() > 0) {
            MS_LB_table.getColumnModel().getColumn(0).setPreferredWidth(130);
        }

        L2_P1_Dashboard.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 480, 190, 190));

        MR_LB_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Candidate #", "Score", "Rank"
            }
        ));
        MR_LB_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(MR_LB_table);
        if (MR_LB_table.getColumnModel().getColumnCount() > 0) {
            MR_LB_table.getColumnModel().getColumn(0).setResizable(false);
            MR_LB_table.getColumnModel().getColumn(0).setPreferredWidth(130);
        }

        L2_P1_Dashboard.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, 190, 160));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/ms_champion.png"))); // NOI18N
        jLabel5.setAlignmentY(0.0F);
        L2_P1_Dashboard.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 30, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/mr_champion.png"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        L2_P1_Dashboard.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LEADERBOARDS");
        L2_P1_Dashboard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1086, 80, 160, 50));

        MR_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MR_title.setForeground(new java.awt.Color(255, 186, 0));
        MR_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MR_title.setText("MR");
        L2_P1_Dashboard.add(MR_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 70));

        MS_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MS_title.setForeground(new java.awt.Color(255, 186, 0));
        MS_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MS_title.setText("MS");
        L2_P1_Dashboard.add(MS_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 60, 70));

        candidateName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        candidateName.setForeground(new java.awt.Color(255, 255, 255));
        candidateName.setText("Candidate #12");
        L2_P1_Dashboard.add(candidateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 510, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("College of Information and Computing");
        L2_P1_Dashboard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 510, 30));

        candidateName1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        candidateName1.setForeground(new java.awt.Color(255, 255, 255));
        candidateName1.setText("Candidate #12");
        L2_P1_Dashboard.add(candidateName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 500, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("College of Information and Computing");
        L2_P1_Dashboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 500, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Candidate 1", "Candidate 2" }));
        L2_P1_Dashboard.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 120, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judge 1", "Judge 2" }));
        L2_P1_Dashboard.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 100, 30));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category 1", "Category 2" }));
        L2_P1_Dashboard.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 120, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judge 1", "Judge 2" }));
        L2_P1_Dashboard.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 100, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Category 1");
        L2_P1_Dashboard.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 186, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MS");
        L2_P1_Dashboard.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 430, 60, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 186, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MR");
        L2_P1_Dashboard.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 60, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Category 1");
        L2_P1_Dashboard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 200, 110, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_up.png"))); // NOI18N
        jButton3.setToolTipText("Previous");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 60, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_down.png"))); // NOI18N
        jButton5.setToolTipText("Next");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, 60, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/refresh.png"))); // NOI18N
        jButton6.setToolTipText("Refresh");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 60, 30));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_up.png"))); // NOI18N
        jButton11.setToolTipText("Previous");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, 60, 30));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_down.png"))); // NOI18N
        jButton12.setToolTipText("Next");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, 60, 30));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove_column.png"))); // NOI18N
        jButton14.setToolTipText("Remove Category");
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, 60, 30));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add_column.png"))); // NOI18N
        jButton15.setToolTipText("Add Category");
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 60, 30));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add_row.png"))); // NOI18N
        jButton16.setToolTipText("Add Candidate");
        jButton16.setBorder(null);
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, 60, 30));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove_row.png"))); // NOI18N
        jButton17.setToolTipText("Remove Candidate");
        jButton17.setBorder(null);
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton17MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 60, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/refresh.png"))); // NOI18N
        jButton7.setToolTipText("Refresh");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, 60, 30));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add_column.png"))); // NOI18N
        jButton19.setToolTipText("Add Category");
        jButton19.setBorder(null);
        jButton19.setBorderPainted(false);
        jButton19.setContentAreaFilled(false);
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 60, 30));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove_column.png"))); // NOI18N
        jButton20.setToolTipText("Remove Category");
        jButton20.setBorder(null);
        jButton20.setBorderPainted(false);
        jButton20.setContentAreaFilled(false);
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton20MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 590, 60, 30));

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add_row.png"))); // NOI18N
        jButton21.setToolTipText("Add Candidate");
        jButton21.setBorder(null);
        jButton21.setBorderPainted(false);
        jButton21.setContentAreaFilled(false);
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton21MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 640, 60, 30));

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove_row.png"))); // NOI18N
        jButton22.setToolTipText("Remove Candidate");
        jButton22.setBorder(null);
        jButton22.setBorderPainted(false);
        jButton22.setContentAreaFilled(false);
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton22MouseExited(evt);
            }
        });
        L2_P1_Dashboard.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 690, 60, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/leaderboards_icon.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        L2_P1_Dashboard.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, 30, 50));

        L2_Dashboard_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/L2_Dashboard_BG.png"))); // NOI18N
        L2_P1_Dashboard.add(L2_Dashboard_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_MainPage.add(L2_P1_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_P2_Categories.setMaximumSize(new java.awt.Dimension(1370, 720));
        L2_P2_Categories.setMinimumSize(new java.awt.Dimension(1370, 720));
        L2_P2_Categories.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pageTitle2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        pageTitle2.setForeground(new java.awt.Color(255, 255, 255));
        pageTitle2.setText("CATEGORIES");
        L2_P2_Categories.add(pageTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 660, 40));

        cat_weight.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cat_weight.setForeground(new java.awt.Color(255, 186, 0));
        cat_weight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cat_weight.setText("10%");
        L2_P2_Categories.add(cat_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 70));

        cat_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cat_description.setForeground(new java.awt.Color(204, 204, 204));
        cat_description.setText("Category Description");
        L2_P2_Categories.add(cat_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 116, 790, 20));

        candidateName2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        candidateName2.setForeground(new java.awt.Color(255, 255, 255));
        candidateName2.setText("Category Name");
        L2_P2_Categories.add(candidateName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 510, 50));

        categoryNum.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        categoryNum.setForeground(new java.awt.Color(255, 186, 0));
        categoryNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryNum.setText("12");
        L2_P2_Categories.add(categoryNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 70, 70));

        jTextField1.setText("Search...");
        L2_P2_Categories.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 152, 160, 30));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        L2_P2_Categories.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 80, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Criterion #", "Name", "Description", "Weight", "Score"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setAlignmentX(0.0F);
        jTable1.setAlignmentY(0.0F);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        L2_P2_Categories.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 820, 360));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 186, 0));
        jLabel2.setText("100.00");
        L2_P2_Categories.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 640, 360, 80));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL SCORE:");
        L2_P2_Categories.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 360, 80));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_up.png"))); // NOI18N
        jButton4.setToolTipText("Previous");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        L2_P2_Categories.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 60, -1));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_down.png"))); // NOI18N
        jButton9.setToolTipText("Next");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        L2_P2_Categories.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, 60, -1));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/edit.png"))); // NOI18N
        jButton33.setToolTipText("Edit");
        jButton33.setBorder(null);
        jButton33.setBorderPainted(false);
        jButton33.setContentAreaFilled(false);
        jButton33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton33MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton33MouseExited(evt);
            }
        });
        L2_P2_Categories.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 200, 60, 30));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/refresh.png"))); // NOI18N
        jButton34.setToolTipText("Refresh");
        jButton34.setBorder(null);
        jButton34.setBorderPainted(false);
        jButton34.setContentAreaFilled(false);
        jButton34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton34MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton34MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton34MouseExited(evt);
            }
        });
        L2_P2_Categories.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 60, 30));

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/save.png"))); // NOI18N
        jButton35.setToolTipText("Delete Criterion");
        jButton35.setBorder(null);
        jButton35.setBorderPainted(false);
        jButton35.setContentAreaFilled(false);
        jButton35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton35MouseExited(evt);
            }
        });
        L2_P2_Categories.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 60, 30));

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add.png"))); // NOI18N
        jButton36.setToolTipText("Add Criterion");
        jButton36.setBorder(null);
        jButton36.setBorderPainted(false);
        jButton36.setContentAreaFilled(false);
        jButton36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton36MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton36MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton36MouseExited(evt);
            }
        });
        L2_P2_Categories.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, 60, 30));

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove.png"))); // NOI18N
        jButton37.setToolTipText("Delete Criterion");
        jButton37.setBorder(null);
        jButton37.setBorderPainted(false);
        jButton37.setContentAreaFilled(false);
        jButton37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton37MouseExited(evt);
            }
        });
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        L2_P2_Categories.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 520, 60, 30));

        L2_Categories_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/L2_Categories_BG.png"))); // NOI18N
        L2_Categories_BG.setAlignmentY(0.0F);
        L2_Categories_BG.setMaximumSize(new java.awt.Dimension(1415, 768));
        L2_Categories_BG.setMinimumSize(new java.awt.Dimension(1415, 768));
        L2_Categories_BG.setPreferredSize(new java.awt.Dimension(1415, 768));
        L2_P2_Categories.add(L2_Categories_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_MainPage.add(L2_P2_Categories, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        L2_P3_Candidates.setMaximumSize(new java.awt.Dimension(1370, 720));
        L2_P3_Candidates.setMinimumSize(new java.awt.Dimension(1370, 720));
        L2_P3_Candidates.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 186, 0));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("MS");
        L2_P3_Candidates.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 70, 70));

        candidateName3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        candidateName3.setForeground(new java.awt.Color(255, 255, 255));
        candidateName3.setText("Candidate Name");
        L2_P3_Candidates.add(candidateName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 500, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("College of Information and Computing");
        L2_P3_Candidates.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 500, 30));

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Candidate #", "Title", "Department", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAlignmentX(0.0F);
        jTable2.setAlignmentY(0.0F);
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setSelectionBackground(new java.awt.Color(78, 71, 198));
        jTable2.setSelectionForeground(new java.awt.Color(255, 204, 0));
        jTable2.setShowGrid(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTable2MouseMoved(evt);
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        L2_P3_Candidates.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 860, 180));

        jTable3.setBackground(new java.awt.Color(51, 51, 51));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Candidate #", "Title", "Department", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setAlignmentX(0.0F);
        jTable3.setAlignmentY(0.0F);
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setSelectionBackground(new java.awt.Color(78, 71, 198));
        jTable3.setSelectionForeground(new java.awt.Color(255, 204, 0));
        jTable3.setShowGrid(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTable3MouseMoved(evt);
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        L2_P3_Candidates.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 860, 180));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/refresh.png"))); // NOI18N
        jButton10.setToolTipText("Refresh");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 200, 60, 30));

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add.png"))); // NOI18N
        jButton28.setToolTipText("Add");
        jButton28.setBorder(null);
        jButton28.setBorderPainted(false);
        jButton28.setContentAreaFilled(false);
        jButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton28MouseExited(evt);
            }
        });
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 300, 60, 30));

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove.png"))); // NOI18N
        jButton29.setToolTipText("Remove");
        jButton29.setBorder(null);
        jButton29.setBorderPainted(false);
        jButton29.setContentAreaFilled(false);
        jButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton29MouseExited(evt);
            }
        });
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 60, 30));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/save.png"))); // NOI18N
        jButton32.setToolTipText("Save");
        jButton32.setBorder(null);
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton32MouseExited(evt);
            }
        });
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 60, 30));

        jTextField2.setToolTipText("Search");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 152, 130, 30));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item 1", "item 2", "item 3", "item4" }));
        L2_P3_Candidates.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 90, 30));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_up.png"))); // NOI18N
        jButton30.setToolTipText("Previous");
        jButton30.setBorder(null);
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton30MouseExited(evt);
            }
        });
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 60, -1));

        candidateNum1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        candidateNum1.setForeground(new java.awt.Color(153, 153, 255));
        candidateNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        candidateNum1.setText("12");
        candidateNum1.setAlignmentY(0.0F);
        L2_P3_Candidates.add(candidateNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 60, 70));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_down.png"))); // NOI18N
        jButton31.setToolTipText("Next");
        jButton31.setBorder(null);
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton31MouseExited(evt);
            }
        });
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, 60, -1));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/refresh.png"))); // NOI18N
        jButton24.setToolTipText("Refresh");
        jButton24.setBorder(null);
        jButton24.setBorderPainted(false);
        jButton24.setContentAreaFilled(false);
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton24MouseExited(evt);
            }
        });
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 60, 30));

        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/save.png"))); // NOI18N
        jButton44.setToolTipText("Save");
        jButton44.setBorder(null);
        jButton44.setBorderPainted(false);
        jButton44.setContentAreaFilled(false);
        jButton44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton44MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton44MouseExited(evt);
            }
        });
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 580, 60, 30));

        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add.png"))); // NOI18N
        jButton45.setToolTipText("Add");
        jButton45.setBorder(null);
        jButton45.setBorderPainted(false);
        jButton45.setContentAreaFilled(false);
        jButton45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton45MouseExited(evt);
            }
        });
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 630, 60, 30));

        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove.png"))); // NOI18N
        jButton46.setToolTipText("Remove");
        jButton46.setBorder(null);
        jButton46.setBorderPainted(false);
        jButton46.setContentAreaFilled(false);
        jButton46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton46MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton46MouseExited(evt);
            }
        });
        L2_P3_Candidates.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 680, 60, 30));

        title3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title3.setForeground(new java.awt.Color(255, 186, 0));
        title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title3.setText("MR");
        L2_P3_Candidates.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 70, 70));

        candidateName4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        candidateName4.setForeground(new java.awt.Color(255, 255, 255));
        candidateName4.setText("Candidate Name");
        L2_P3_Candidates.add(candidateName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 500, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("College of Information and Computing");
        L2_P3_Candidates.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 500, 30));
        L2_P3_Candidates.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 130, 30));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        L2_P3_Candidates.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 90, 30));

        candidateNum.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        candidateNum.setForeground(new java.awt.Color(153, 153, 255));
        candidateNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        candidateNum.setText("12");
        candidateNum.setAlignmentY(0.0F);
        L2_P3_Candidates.add(candidateNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, 70));

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_up.png"))); // NOI18N
        jButton47.setToolTipText("Previous");
        jButton47.setBorder(null);
        jButton47.setBorderPainted(false);
        jButton47.setContentAreaFilled(false);
        jButton47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton47MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton47MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton47MouseExited(evt);
            }
        });
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, 60, -1));

        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_down.png"))); // NOI18N
        jButton48.setToolTipText("Next");
        jButton48.setBorder(null);
        jButton48.setBorderPainted(false);
        jButton48.setContentAreaFilled(false);
        jButton48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton48MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton48MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton48MouseExited(evt);
            }
        });
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        L2_P3_Candidates.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, 60, -1));

        L2_Candidates_BG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/L2_Candidates_BG.png"))); // NOI18N
        L2_Candidates_BG1.setText("jLabel11");
        L2_P3_Candidates.add(L2_Candidates_BG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        L2_MainPage.add(L2_P3_Candidates, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_P4_Judges.setMaximumSize(new java.awt.Dimension(1370, 720));
        L2_P4_Judges.setMinimumSize(new java.awt.Dimension(1370, 720));
        L2_P4_Judges.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judgeNumber1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        judgeNumber1.setForeground(new java.awt.Color(255, 186, 0));
        judgeNumber1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judgeNumber1.setText("5");
        L2_P4_Judges.add(judgeNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 60, 60));

        judgeName1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        judgeName1.setForeground(new java.awt.Color(255, 255, 255));
        judgeName1.setText("Judge Name");
        L2_P4_Judges.add(judgeName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 510, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Affiliation");
        L2_P4_Judges.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 510, 40));

        jTable4.setBackground(new java.awt.Color(51, 51, 51));
        jTable4.setForeground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Judge ID", "Name", "Affiliation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setAlignmentX(0.0F);
        jTable4.setAlignmentY(0.0F);
        jTable4.setSelectionBackground(new java.awt.Color(78, 71, 198));
        jTable4.setSelectionForeground(new java.awt.Color(255, 204, 0));
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTable4MouseMoved(evt);
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        L2_P4_Judges.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 170, 820, 470));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/refresh.png"))); // NOI18N
        jButton23.setToolTipText("Refresh");
        jButton23.setBorder(null);
        jButton23.setBorderPainted(false);
        jButton23.setContentAreaFilled(false);
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton23MouseExited(evt);
            }
        });
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        L2_P4_Judges.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 60, 30));

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add.png"))); // NOI18N
        jButton39.setToolTipText("Add Criterion");
        jButton39.setBorder(null);
        jButton39.setBorderPainted(false);
        jButton39.setContentAreaFilled(false);
        jButton39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton39MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton39MouseExited(evt);
            }
        });
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        L2_P4_Judges.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, 60, 30));

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove.png"))); // NOI18N
        jButton40.setToolTipText("Delete Criterion");
        jButton40.setBorder(null);
        jButton40.setBorderPainted(false);
        jButton40.setContentAreaFilled(false);
        jButton40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton40MouseExited(evt);
            }
        });
        L2_P4_Judges.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 370, 60, 30));

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/save.png"))); // NOI18N
        jButton41.setToolTipText("Delete Criterion");
        jButton41.setBorder(null);
        jButton41.setBorderPainted(false);
        jButton41.setContentAreaFilled(false);
        jButton41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton41MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton41MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton41MouseExited(evt);
            }
        });
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        L2_P4_Judges.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 60, 30));
        L2_P4_Judges.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 160, 30));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        L2_P4_Judges.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, 30));

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_up.png"))); // NOI18N
        jButton42.setToolTipText("Previous");
        jButton42.setBorder(null);
        jButton42.setBorderPainted(false);
        jButton42.setContentAreaFilled(false);
        jButton42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton42MouseExited(evt);
            }
        });
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        L2_P4_Judges.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, 60, 30));

        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/arrow_down.png"))); // NOI18N
        jButton43.setToolTipText("Next");
        jButton43.setBorder(null);
        jButton43.setBorderPainted(false);
        jButton43.setContentAreaFilled(false);
        jButton43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton43MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton43MouseExited(evt);
            }
        });
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        L2_P4_Judges.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 84, 60, 30));

        L2_Judges_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/L2_Judges_BG.png"))); // NOI18N
        L2_Judges_BG.setMaximumSize(new java.awt.Dimension(1370, 720));
        L2_Judges_BG.setMinimumSize(new java.awt.Dimension(1370, 720));
        L2_Judges_BG.setPreferredSize(new java.awt.Dimension(1370, 720));
        L2_Judges_BG.setRequestFocusEnabled(false);
        L2_P4_Judges.add(L2_Judges_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_MainPage.add(L2_P4_Judges, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_MainPage_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/L2_Dashboard_BG.png"))); // NOI18N
        L2_MainPage.add(L2_MainPage_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L2_Homepage.add(L2_MainPage);

        getContentPane().add(L2_Homepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeSidebar() {
        int sidebarWidth = 60;
        L2_Sidebar.setPreferredSize(new Dimension(sidebarWidth, L2_Sidebar.getHeight()));
        L2_Sidebar.revalidate();
        L2_Sidebar.repaint();
    }
    
    private void maximizeSidebar() {
        int sidebarWidth = 278;
        L2_Sidebar.setPreferredSize(new Dimension(sidebarWidth, L2_Sidebar.getHeight()));
        L2_Sidebar.revalidate();
        L2_Sidebar.repaint();
    }
    
    //Integer to Percentage Decimal (Double)
    public static double convertToPercentage(int value) {
        double percentage = (double) value / 100.0;
        return percentage;
    }
    
    private void start_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_btnActionPerformed
        // TODO add your handling code here:
        L1_LandingPage.setVisible(false);
        L2_Homepage.setVisible(true);
    }//GEN-LAST:event_start_btnActionPerformed

    private void start_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_btnMouseEntered
        // TODO add your handling code here:
        L1_BG.setIcon(new javax.swing.ImageIcon("src\\Assets\\L1_hover.png"));
    }//GEN-LAST:event_start_btnMouseEntered

    private void start_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_btnMouseExited
        // TODO add your handling code here:
        L1_BG.setIcon(new javax.swing.ImageIcon("src\\Assets\\landingpage_bg.png"));
    }//GEN-LAST:event_start_btnMouseExited

    private void dashboard_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboard_btnActionPerformed
        // TODO add your handling code here:
        dashboard_btn.setSelected(true);
        categories_btn.setSelected(false);
        candidates_btn.setSelected(false);
        judges_btn.setSelected(false);
        about_btn.setSelected(false);
        exit_btn.setSelected(false);
        
        L2_P1_Dashboard.setVisible(true);
        L2_P2_Categories.setVisible(false);
        L2_P3_Candidates.setVisible(false);
        L2_P4_Judges.setVisible(false);
    }//GEN-LAST:event_dashboard_btnActionPerformed

    private void categories_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categories_btnActionPerformed
        // TODO add your handling code here:
        dashboard_btn.setSelected(false);
        categories_btn.setSelected(true);
        candidates_btn.setSelected(false);
        judges_btn.setSelected(false);
        about_btn.setSelected(false);
        exit_btn.setSelected(false);
        
        L2_P1_Dashboard.setVisible(false);
        L2_P2_Categories.setVisible(true);
        L2_P3_Candidates.setVisible(false);
        L2_P4_Judges.setVisible(false);
    }//GEN-LAST:event_categories_btnActionPerformed

    private void candidates_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_candidates_btnActionPerformed
        // TODO add your handling code here:
        dashboard_btn.setSelected(false);
        categories_btn.setSelected(false);
        candidates_btn.setSelected(true);
        judges_btn.setSelected(false);
        about_btn.setSelected(false);
        exit_btn.setSelected(false);
        
        L2_P1_Dashboard.setVisible(false);
        L2_P2_Categories.setVisible(false);
        L2_P3_Candidates.setVisible(true);
        L2_P4_Judges.setVisible(false);
    }//GEN-LAST:event_candidates_btnActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        // TODO add your handling code here:
        dashboard_btn.setSelected(false);
        categories_btn.setSelected(false);
        candidates_btn.setSelected(false);
        judges_btn.setSelected(false);
        about_btn.setSelected(true);
        exit_btn.setSelected(false);
        
        JOptionPane.showMessageDialog(
                null,
                            "Software Name: Tabulation System" + 
                            "\nDescription: The tabulation system is designed to streamline "
                                    + "the judging process for Mr. and Ms. Pageants, \n"
                                    + "providing tabulators with a user-friendly platform "
                                    + "to input and calculate scores accurately and efficiently." +
                            "\n\nVersion: v1.0" +
                            "\nDevelopers: Developed by Gianne P. Bacay" +
                            "\nEmail: giannebacay2004@gmail.com" +
                            "\nWebsite: https://gpbacay.github.io/PersonalPortfolio/" +
                            "\nLegal Disclaimer: The tabulation system is provided as-is, "
                                    + "without warranties or guarantees of any kind. \n"
                                    + "The developer are not liable for any damages "
                                    + "or losses arising from the use of this software.",
                            
                            "Tabulation System",
                            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_about_btnActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
        // Check user's choice
        if (choice == JOptionPane.YES_OPTION) {
            // User confirmed to exit
            L1_LandingPage.setVisible(true);
            L2_Homepage.setVisible(false);

            dashboard_btn.setSelected(true);
            categories_btn.setSelected(false);
            candidates_btn.setSelected(false);
            judges_btn.setSelected(false);
            about_btn.setSelected(false);
            exit_btn.setSelected(false);

            L2_P1_Dashboard.setVisible(true);
            L2_P2_Categories.setVisible(false);
            L2_P3_Candidates.setVisible(false);
            L2_P4_Judges.setVisible(false);
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void dashboard_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseEntered
        // TODO add your handling code here:
        dashboard_btn.setForeground(new Color(255,186,0));
        dashboard_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\dashboard_hover.png"));
    }//GEN-LAST:event_dashboard_btnMouseEntered

    private void dashboard_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseExited
        // TODO add your handling code here:
        dashboard_btn.setForeground(new Color(255,255,255));
        dashboard_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\dashboard.png"));
    }//GEN-LAST:event_dashboard_btnMouseExited

    private void categories_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categories_btnMouseEntered
        // TODO add your handling code here:
        categories_btn.setForeground(new Color(255,186,0));
        categories_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\categories_hover.png"));
    }//GEN-LAST:event_categories_btnMouseEntered

    private void categories_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categories_btnMouseExited
        // TODO add your handling code here:
        categories_btn.setForeground(new Color(255,255,255));
        categories_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\categories.png"));
    }//GEN-LAST:event_categories_btnMouseExited

    private void candidates_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candidates_btnMouseEntered
        // TODO add your handling code here:
        candidates_btn.setForeground(new Color(255,186,0));
        candidates_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\candidates_hover.png"));
    }//GEN-LAST:event_candidates_btnMouseEntered

    private void candidates_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candidates_btnMouseExited
        // TODO add your handling code here:
        candidates_btn.setForeground(new Color(255,255,255));
        candidates_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\candidates.png"));
    }//GEN-LAST:event_candidates_btnMouseExited

    private void about_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_about_btnMouseEntered
        // TODO add your handling code here:
        about_btn.setForeground(new Color(255,186,0));
        about_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\about_hover.png"));
    }//GEN-LAST:event_about_btnMouseEntered

    private void about_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_about_btnMouseExited
        // TODO add your handling code here:
        about_btn.setForeground(new Color(255,255,255));
        about_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\about.png"));
    }//GEN-LAST:event_about_btnMouseExited

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        // TODO add your handling code here:
        exit_btn.setForeground(new Color(250,82,82));
        exit_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\exit_hover.png"));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        // TODO add your handling code here:
        exit_btn.setForeground(new Color(255,255,255));
        exit_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\exit.png"));
    }//GEN-LAST:event_exit_btnMouseExited

    private void sidebar_toggler_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebar_toggler_btnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_sidebar_toggler_btnActionPerformed

    private void sidebar_toggler_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_toggler_btnMouseClicked
        // TODO add your handling code here:
        if (!sidebar_toggler_btn.isSelected()) {
            minimizeSidebar();
            sidebar_toggler_btn.setSelected(true);
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
        else {
            maximizeSidebar();
            sidebar_toggler_btn.setSelected(false);
        }
    }//GEN-LAST:event_sidebar_toggler_btnMouseClicked

    private void sidebar_toggler_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_toggler_btnMouseEntered
        // TODO add your handling code here:
        if (!sidebar_toggler_btn.isSelected()) {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\collapse_sidebar.png"));
        }
        else {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
    }//GEN-LAST:event_sidebar_toggler_btnMouseEntered

    private void sidebar_toggler_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_toggler_btnMouseExited
        // TODO add your handling code here:
        if (!sidebar_toggler_btn.isSelected()) {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\sidebar_icon.png"));
        }
        else {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
    }//GEN-LAST:event_sidebar_toggler_btnMouseExited

    private void dashboard_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboard_btnMouseClicked

    private void logo_img_containerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_img_containerMouseClicked
        // TODO add your handling code here:
        if (!sidebar_toggler_btn.isSelected()) {
            minimizeSidebar();
            sidebar_toggler_btn.setSelected(true);
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
        else {
            maximizeSidebar();
            sidebar_toggler_btn.setSelected(false);
        }
    }//GEN-LAST:event_logo_img_containerMouseClicked

    private void logo_img_containerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_img_containerMouseEntered
        // TODO add your handling code here:
        logo_title.setForeground(new Color(255,186,0));
        
        logo_img_container.setIcon(new javax.swing.ImageIcon("src\\Assets\\logo.png"));
        if (!sidebar_toggler_btn.isSelected()) {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\collapse_sidebar.png"));
        }
        else {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
    }//GEN-LAST:event_logo_img_containerMouseEntered

    private void logo_img_containerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_img_containerMouseExited
        // TODO add your handling code here:
        logo_title.setForeground(new Color(255,255,255));
        
        logo_img_container.setIcon(new javax.swing.ImageIcon("src\\Assets\\logo_bnw.png"));
        if (!sidebar_toggler_btn.isSelected()) {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\sidebar_icon.png"));
        }
        else {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
    }//GEN-LAST:event_logo_img_containerMouseExited

    private void logo_titleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_titleMouseEntered
        // TODO add your handling code here:
        logo_title.setForeground(new Color(255,186,0));
        
        logo_img_container.setIcon(new javax.swing.ImageIcon("src\\Assets\\logo.png"));
        if (!sidebar_toggler_btn.isSelected()) {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\collapse_sidebar.png"));
        }
        else {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
    }//GEN-LAST:event_logo_titleMouseEntered

    private void logo_titleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_titleMouseExited
        // TODO add your handling code here:
        logo_title.setForeground(new Color(255,255,255));
        
        logo_img_container.setIcon(new javax.swing.ImageIcon("src\\Assets\\logo_bnw.png"));
        if (!sidebar_toggler_btn.isSelected()) {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\sidebar_icon.png"));
        }
        else {
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
    }//GEN-LAST:event_logo_titleMouseExited

    private void judges_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_judges_btnMouseEntered
        // TODO add your handling code here:
        judges_btn.setForeground(new Color(255,186,0));
        judges_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\judges_hover.png"));
    }//GEN-LAST:event_judges_btnMouseEntered

    private void judges_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_judges_btnMouseExited
        // TODO add your handling code here:
        judges_btn.setForeground(new Color(255,255,255));
        judges_icon_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\judges.png"));
    }//GEN-LAST:event_judges_btnMouseExited

    private void judges_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judges_btnActionPerformed
        // TODO add your handling code here:
        dashboard_btn.setSelected(false);
        categories_btn.setSelected(false);
        candidates_btn.setSelected(false);
        judges_btn.setSelected(true);
        about_btn.setSelected(false);
        exit_btn.setSelected(false);
        
        L2_P1_Dashboard.setVisible(false);
        L2_P2_Categories.setVisible(false);
        L2_P3_Candidates.setVisible(false);
        L2_P4_Judges.setVisible(true);
    }//GEN-LAST:event_judges_btnActionPerformed

    private void logo_titleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_titleMouseClicked
        // TODO add your handling code here:
        if (!sidebar_toggler_btn.isSelected()) {
            minimizeSidebar();
            sidebar_toggler_btn.setSelected(true);
            sidebar_toggler_btn.setIcon(new javax.swing.ImageIcon("src\\Assets\\expand_sidebar.png"));
        }
        else {
            maximizeSidebar();
            sidebar_toggler_btn.setSelected(false);
        }
    }//GEN-LAST:event_logo_titleMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up_hover.png"));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up.png"));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
        jButton11.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up_hover.png"));
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        // TODO add your handling code here:
        jButton11.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up.png"));
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down_hover.png"));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
        jButton5.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down.png"));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        // TODO add your handling code here:
        jButton12.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down_hover.png"));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        // TODO add your handling code here:
        jButton12.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down.png"));
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh_hover.png"));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jButton6.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh.png"));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jButton7.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh_hover.png"));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        jButton7.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh.png"));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        // TODO add your handling code here:
        jButton15.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_column_hover.png"));
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        // TODO add your handling code here:
        jButton15.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_column.png"));
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseEntered
        // TODO add your handling code here:
        jButton19.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_column_hover.png"));
    }//GEN-LAST:event_jButton19MouseEntered

    private void jButton19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseExited
        // TODO add your handling code here:
        jButton19.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_column.png"));
    }//GEN-LAST:event_jButton19MouseExited

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        // TODO add your handling code here:
        jButton14.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_column_hover.png"));
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        // TODO add your handling code here:
        jButton14.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_column.png"));
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton20MouseClicked

    private void jButton20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseEntered
        // TODO add your handling code here:
        jButton20.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_column_hover.png"));
    }//GEN-LAST:event_jButton20MouseEntered

    private void jButton20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseExited
        // TODO add your handling code here:
        jButton20.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_column.png"));
    }//GEN-LAST:event_jButton20MouseExited

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        // TODO add your handling code here:
        jButton16.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_row_hover.png"));
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
        // TODO add your handling code here:
        jButton16.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_row.png"));
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21MouseClicked

    private void jButton21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseEntered
        // TODO add your handling code here:
        jButton21.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_row_hover.png"));
    }//GEN-LAST:event_jButton21MouseEntered

    private void jButton21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseExited
        // TODO add your handling code here:
        jButton21.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_row.png"));
    }//GEN-LAST:event_jButton21MouseExited

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseEntered
        // TODO add your handling code here:
        jButton17.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_row_hover.png"));
    }//GEN-LAST:event_jButton17MouseEntered

    private void jButton17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseExited
        // TODO add your handling code here:
        jButton17.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_row.png"));
    }//GEN-LAST:event_jButton17MouseExited

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseEntered
        // TODO add your handling code here:
        jButton22.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_row_hover.png"));
    }//GEN-LAST:event_jButton22MouseEntered

    private void jButton22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseExited
        // TODO add your handling code here:
        jButton22.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_row.png"));
    }//GEN-LAST:event_jButton22MouseExited

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        jButton10.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh_hover.png"));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
        jButton10.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh.png"));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28MouseClicked

    private void jButton28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseEntered
        // TODO add your handling code here:
        jButton28.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_hover.png"));
    }//GEN-LAST:event_jButton28MouseEntered

    private void jButton28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseExited
        // TODO add your handling code here:
        jButton28.setIcon(new javax.swing.ImageIcon("src\\Assets\\add.png"));
    }//GEN-LAST:event_jButton28MouseExited

    private void jButton29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29MouseClicked

    private void jButton29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseEntered
        // TODO add your handling code here:
        jButton29.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_hover.png"));
        
    }//GEN-LAST:event_jButton29MouseEntered

    private void jButton29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseExited
        // TODO add your handling code here:
        jButton29.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove.png"));
    }//GEN-LAST:event_jButton29MouseExited

    private void jButton30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30MouseClicked

    private void jButton30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton30MouseEntered
        // TODO add your handling code here:
        jButton30.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up_hover.png"));
    }//GEN-LAST:event_jButton30MouseEntered

    private void jButton30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton30MouseExited
        // TODO add your handling code here:
        jButton30.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up.png"));
    }//GEN-LAST:event_jButton30MouseExited

    private void jButton31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton31MouseClicked

    private void jButton31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton31MouseEntered
        // TODO add your handling code here:
        jButton31.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down_hover.png"));
    }//GEN-LAST:event_jButton31MouseEntered

    private void jButton31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton31MouseExited
        // TODO add your handling code here:
        jButton31.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down.png"));
    }//GEN-LAST:event_jButton31MouseExited

    private void jButton32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32MouseClicked

    private void jButton32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton32MouseEntered
        // TODO add your handling code here:
        jButton32.setIcon(new javax.swing.ImageIcon("src\\Assets\\save_hover.png"));
    }//GEN-LAST:event_jButton32MouseEntered

    private void jButton32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton32MouseExited
        // TODO add your handling code here:
        jButton32.setIcon(new javax.swing.ImageIcon("src\\Assets\\save.png"));
    }//GEN-LAST:event_jButton32MouseExited

    private void jButton33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33MouseClicked

    private void jButton33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton33MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33MouseEntered

    private void jButton33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton33MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33MouseExited

    private void jButton34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34MouseClicked

    private void jButton34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton34MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34MouseEntered

    private void jButton34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton34MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34MouseExited

    private void jButton35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35MouseClicked

    private void jButton35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton35MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35MouseEntered

    private void jButton35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton35MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35MouseExited

    private void jButton36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton36MouseClicked

    private void jButton36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton36MouseEntered

    private void jButton36MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton36MouseExited

    private void jButton37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37MouseClicked

    private void jButton37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton37MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37MouseEntered

    private void jButton37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton37MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37MouseExited

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23MouseEntered

    private void jButton23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23MouseExited

    private void jButton39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39MouseClicked

    private void jButton39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton39MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39MouseEntered

    private void jButton39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton39MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39MouseExited

    private void jButton40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40MouseClicked

    private void jButton40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton40MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40MouseEntered

    private void jButton40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton40MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40MouseExited

    private void jButton41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton41MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41MouseClicked

    private void jButton41MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton41MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41MouseEntered

    private void jButton41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton41MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41MouseExited

    private void jButton42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton42MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton42MouseClicked

    private void jButton42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton42MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42MouseEntered

    private void jButton42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton42MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42MouseExited

    private void jButton43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton43MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable4.getSelectedRow();
        
        if (selectedRow != -1) {
            String judgeNumber = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
            String judgeName = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();
            String judgeAffiliation = jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString();

            judgeNumber1.setText(judgeNumber);
            judgeName1.setText(judgeName);
            jLabel13.setText(judgeAffiliation);
        }
    }//GEN-LAST:event_jButton43MouseClicked

    private void jButton43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton43MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43MouseEntered

    private void jButton43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton43MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        populateMRCHashtable(getMRCHashtable());
        populateCandidatesTable(jTable2,getMRCHashtable());
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        addCandidateTableRow(jTable2,"MR");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24MouseClicked

    private void jButton24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseEntered
        // TODO add your handling code here:
        jButton24.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh_hover.png"));
    }//GEN-LAST:event_jButton24MouseEntered

    private void jButton24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseExited
        // TODO add your handling code here:
        jButton24.setIcon(new javax.swing.ImageIcon("src\\Assets\\refresh.png"));
    }//GEN-LAST:event_jButton24MouseExited

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        populateMSCHashtable(getMSCHashtable());
        populateCandidatesTable(jTable3,getMSCHashtable());
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton44MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton44MouseClicked

    private void jButton44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton44MouseEntered
        // TODO add your handling code here:
        jButton44.setIcon(new javax.swing.ImageIcon("src\\Assets\\save_hover.png"));
    }//GEN-LAST:event_jButton44MouseEntered

    private void jButton44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton44MouseExited
        // TODO add your handling code here:
        jButton44.setIcon(new javax.swing.ImageIcon("src\\Assets\\save.png"));
    }//GEN-LAST:event_jButton44MouseExited

    private void jButton45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton45MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton45MouseClicked

    private void jButton45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton45MouseEntered
        // TODO add your handling code here:
        jButton45.setIcon(new javax.swing.ImageIcon("src\\Assets\\add_hover.png"));
    }//GEN-LAST:event_jButton45MouseEntered

    private void jButton45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton45MouseExited
        // TODO add your handling code here:
        jButton45.setIcon(new javax.swing.ImageIcon("src\\Assets\\add.png"));
    }//GEN-LAST:event_jButton45MouseExited

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        addCandidateTableRow(jTable3,"MS");
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton46MouseClicked
        // TODO add your handling code here:
        deleteSelectedTableRow(jTable3);
    }//GEN-LAST:event_jButton46MouseClicked

    private void jButton46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton46MouseEntered
        // TODO add your handling code here:
        jButton46.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove_hover.png"));
        
    }//GEN-LAST:event_jButton46MouseEntered

    private void jButton46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton46MouseExited
        // TODO add your handling code here:
        jButton46.setIcon(new javax.swing.ImageIcon("src\\Assets\\remove.png"));
    }//GEN-LAST:event_jButton46MouseExited

    private void jButton47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton47MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47MouseClicked

    private void jButton47MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton47MouseEntered
        // TODO add your handling code here:
        jButton47.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up_hover.png"));
    }//GEN-LAST:event_jButton47MouseEntered

    private void jButton47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton47MouseExited
        // TODO add your handling code here:
        jButton47.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_up.png"));
    }//GEN-LAST:event_jButton47MouseExited

    private void jButton48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton48MouseClicked

    private void jButton48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton48MouseEntered
        // TODO add your handling code here:
        jButton48.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down_hover.png"));
    }//GEN-LAST:event_jButton48MouseEntered

    private void jButton48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton48MouseExited
        // TODO add your handling code here:
        jButton48.setIcon(new javax.swing.ImageIcon("src\\Assets\\arrow_down.png"));
    }//GEN-LAST:event_jButton48MouseExited

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        populateMRTableToCSV(jTable2);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        deleteSelectedTableRow(jTable2);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
            String candidateName = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
            String candidateDepartment = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();

            candidateNum.setText(candidateId);
            candidateName3.setText(candidateName);
            jLabel12.setText(candidateDepartment);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable3.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId1 = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
            String candidateName1 = jTable3.getValueAt(jTable3.getSelectedRow(), 3).toString();
            String candidateDepartment1 = jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString();

            candidateNum1.setText(candidateId1);
            candidateName4.setText(candidateName1);
            jLabel14.setText(candidateDepartment1);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseMoved
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
            String candidateName = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
            String candidateDepartment = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();

            candidateNum.setText(candidateId);
            candidateName3.setText(candidateName);
            jLabel12.setText(candidateDepartment);
        }
    }//GEN-LAST:event_jTable2MouseMoved

    private void jTable3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseMoved
        // TODO add your handling code here:
        int selectedRow = jTable3.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId1 = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
            String candidateName1 = jTable3.getValueAt(jTable3.getSelectedRow(), 3).toString();
            String candidateDepartment1 = jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString();

            candidateNum1.setText(candidateId1);
            candidateName4.setText(candidateName1);
            jLabel14.setText(candidateDepartment1);
        }
    }//GEN-LAST:event_jTable3MouseMoved

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        goToNextRow(jTable2);
        int selectedRow = jTable2.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
            String candidateName = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
            String candidateDepartment = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();

            candidateNum.setText(candidateId);
            candidateName3.setText(candidateName);
            jLabel12.setText(candidateDepartment);
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        goToNextRow(jTable3);
        int selectedRow = jTable3.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId1 = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
            String candidateName1 = jTable3.getValueAt(jTable3.getSelectedRow(), 3).toString();
            String candidateDepartment1 = jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString();

            candidateNum1.setText(candidateId1);
            candidateName4.setText(candidateName1);
            jLabel14.setText(candidateDepartment1);
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        goToPreviousRow(jTable2);
        int selectedRow = jTable2.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
            String candidateName = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
            String candidateDepartment = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();

            candidateNum.setText(candidateId);
            candidateName3.setText(candidateName);
            jLabel12.setText(candidateDepartment);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        goToPreviousRow(jTable3);
        int selectedRow = jTable3.getSelectedRow();
        
        if (selectedRow != -1) {
            String candidateId1 = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
            String candidateName1 = jTable3.getValueAt(jTable3.getSelectedRow(), 3).toString();
            String candidateDepartment1 = jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString();

            candidateNum1.setText(candidateId1);
            candidateName4.setText(candidateName1);
            jLabel14.setText(candidateDepartment1);
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        populateJudgesHashtable(getJudgesHashtable());
        populateJudgesTable(jTable4,getJudgesHashtable());
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        addJudgeTableRow(jTable4);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        populateMSTableToCSV(jTable3);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        populateJudgesTableToCSV(jTable4);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable4.getSelectedRow();
        
        if (selectedRow != -1) {
            String judgeNumber = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
            String judgeName = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();
            String judgeAffiliation = jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString();

            judgeNumber1.setText(judgeNumber);
            judgeName1.setText(judgeName);
            jLabel13.setText(judgeAffiliation);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseMoved
        // TODO add your handling code here:
        int selectedRow = jTable4.getSelectedRow();
        
        if (selectedRow != -1) {
            String judgeNumber = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
            String judgeName = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();
            String judgeAffiliation = jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString();

            judgeNumber1.setText(judgeNumber);
            judgeName1.setText(judgeName);
            jLabel13.setText(judgeAffiliation);
        }
    }//GEN-LAST:event_jTable4MouseMoved

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        goToPreviousRow(jTable4);
        int selectedRow = jTable4.getSelectedRow();
        
        if (selectedRow != -1) {
            String judgeNumber = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
            String judgeName = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();
            String judgeAffiliation = jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString();

            judgeNumber1.setText(judgeNumber);
            judgeName1.setText(judgeName);
            jLabel13.setText(judgeAffiliation);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        goToNextRow(jTable4);
        int selectedRow = jTable4.getSelectedRow();
        
        if (selectedRow != -1) {
            String judgeNumber = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
            String judgeName = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();
            String judgeAffiliation = jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString();

            judgeNumber1.setText(judgeNumber);
            judgeName1.setText(judgeName);
            jLabel13.setText(judgeAffiliation);
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tabulationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabulationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabulationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabulationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tabulationSystem frame = new tabulationSystem();
                frame.setResizable(false);
                frame.setTitle("Tabulation System");
                frame.setIconImage(new ImageIcon("src\\Assets\\logo.png").getImage());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L1_BG;
    private javax.swing.JLayeredPane L1_LandingPage;
    private javax.swing.JLabel L2_Candidates_BG1;
    private javax.swing.JLabel L2_Categories_BG;
    private javax.swing.JLabel L2_Dashboard_BG;
    private javax.swing.JLayeredPane L2_Homepage;
    private javax.swing.JLabel L2_Judges_BG;
    private javax.swing.JLayeredPane L2_MainPage;
    private javax.swing.JLabel L2_MainPage_BG;
    private javax.swing.JLayeredPane L2_P1_Dashboard;
    private javax.swing.JLayeredPane L2_P2_Categories;
    private javax.swing.JLayeredPane L2_P3_Candidates;
    private javax.swing.JLayeredPane L2_P4_Judges;
    private javax.swing.JLayeredPane L2_Sidebar;
    private javax.swing.JLayeredPane L2_SidebarToggler;
    private javax.swing.JLabel L2_Sidebar_BG;
    private javax.swing.JTable MR_LB_table;
    private javax.swing.JTable MR_table;
    private javax.swing.JLabel MR_title;
    private javax.swing.JTable MS_LB_table;
    private javax.swing.JTable MS_table;
    private javax.swing.JLabel MS_title;
    private javax.swing.JButton about_btn;
    private javax.swing.JLabel about_icon_btn;
    private javax.swing.JLabel candidateName;
    private javax.swing.JLabel candidateName1;
    private javax.swing.JLabel candidateName2;
    private javax.swing.JLabel candidateName3;
    private javax.swing.JLabel candidateName4;
    private javax.swing.JLabel candidateNum;
    private javax.swing.JLabel candidateNum1;
    private javax.swing.JButton candidates_btn;
    private javax.swing.JLabel candidates_icon_btn;
    private javax.swing.JLabel cat_description;
    private javax.swing.JLabel cat_weight;
    private javax.swing.JButton categories_btn;
    private javax.swing.JLabel categories_icon_btn;
    private javax.swing.JLabel categoryNum;
    private javax.swing.JButton dashboard_btn;
    private javax.swing.JLabel dashboard_icon_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel exit_icon_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    private static javax.swing.JTable jTable3;
    private static javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel judgeName1;
    private javax.swing.JLabel judgeNumber1;
    private javax.swing.JButton judges_btn;
    private javax.swing.JLabel judges_icon_btn;
    private javax.swing.JLabel logo_img_container;
    private javax.swing.JLabel logo_title;
    private javax.swing.JLabel pageTitle1;
    private javax.swing.JLabel pageTitle2;
    private javax.swing.JLabel sidebar_toggler_BG;
    private javax.swing.JButton sidebar_toggler_btn;
    private javax.swing.JButton start_btn;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    // End of variables declaration//GEN-END:variables
}
