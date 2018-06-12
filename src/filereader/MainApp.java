package filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 * @author Jarosław Kowalczyk
 */
public class MainApp extends javax.swing.JFrame {

    private List<Block> blockList = new ArrayList<>();
    private List<Integer> listOfPozNumber = new ArrayList<>();
    
    public MainApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        jLabel_FilePath = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jTextField_BlockName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        btnLoad.setText("Wczytaj");
        btnLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadMouseClicked(evt);
            }
        });

        jLabel_FilePath.setText("File path");

        btnSave.setText("Zapisz");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        jTextField_BlockName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_BlockName.setText("JK_OPIS_PRETA");

        jLabel1.setText("Nazwa bloku:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_FilePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField_BlockName, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_BlockName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel_FilePath)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void addBlockToList(BufferedReader bufferedReader) {
        String blockName = jTextField_BlockName.getText();
        Object[] tableLines = bufferedReader.lines().toArray();
        
        // i = 1 because in txt file line 0 is table Header
        for (int i = 1; i < tableLines.length; i++) {
            String line = tableLines[i].toString().trim();
            String[] dataRow = line.split("\\s+");

            if (dataRow[1].equals(blockName)){
                // Add pozNumber to array
                listOfPozNumber.add(Integer.parseInt(dataRow[2]));
                // Block object without first column[0]
                Block theBlock = new Block(dataRow[1], Integer.parseInt(dataRow[2]), Integer.parseInt(dataRow[3]), dataRow[4], Integer.parseInt(dataRow[5]), Double.parseDouble(dataRow[6]));
                blockList.add(theBlock);
            }
        } 
    }
    
    public boolean checkForDuplicates() {
        Set<Integer> set = new HashSet<Integer>(listOfPozNumber);
        
        if(set.size() < listOfPozNumber.size()) {
            return true;
        }
        return false;
    }
    
    public void addHeaderToJtable() {
        String[] columnName = {"BLOCKNAME", "NUMBER", "PIECES", "SYMBOL", "DIAMETER", "LENGTH"};
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setColumnIdentifiers(columnName);
    }
    
    public void addRowToJtable() {
        Collections.sort(blockList);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        Object rowData[] = new Object[6];
        for (int i = 0; i < blockList.size(); i++) {
            rowData[0] = blockList.get(i).getBlockName();
            rowData[1] = blockList.get(i).getBarNumber();
            rowData[2] = blockList.get(i).getBarPieces();
            rowData[3] = blockList.get(i).getBarSymbol();
            rowData[4] = blockList.get(i).getBarDiameter();
            rowData[5] = blockList.get(i).getBarLength();
            model.addRow(rowData);
        }
    }    
    
    private void btnLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileTypeFilter(".txt", "Text File"));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            jLabel_FilePath.setText(selectedFile.getAbsolutePath());
            try {
                FileReader reader = new FileReader(selectedFile.getAbsolutePath());
                BufferedReader bufferedReader = new BufferedReader(reader);

                addHeaderToJtable();
                addBlockToList(bufferedReader);
                reader.close();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
            }
        }
        addRowToJtable();
        
        if(checkForDuplicates() == true) {
            JOptionPane.showMessageDialog(null, "Uwaga występują pozycje o tych samych numerach!");
        }
    }//GEN-LAST:event_btnLoadMouseClicked
    
    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileTypeFilter(".xls", "Excel File"));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        int result = fileChooser.showSaveDialog(null);
        
        Collections.sort(blockList);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                FileInputStream fileInputStream = new FileInputStream(selectedFile.getAbsolutePath());
                HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
                HSSFSheet worksheet = wb.getSheetAt(0);
                Cell cellBarNumber = null;
                Cell cellBarDiameter = null;
                Cell cellBarLength = null;
                Cell cellBarPieces = null;
                
                for (int i = 0; i < blockList.size(); i++) {
                    System.out.println(blockList.get(i));

                    cellBarNumber = worksheet.getRow(i + 3).getCell(0);
                    cellBarDiameter = worksheet.getRow(i + 3).getCell(1);
                    cellBarLength = worksheet.getRow(i + 3).getCell(2);
                    cellBarPieces = worksheet.getRow(i + 3).getCell(3);

                    cellBarNumber.setCellValue(blockList.get(i).getBarNumber());
                    cellBarDiameter.setCellValue(blockList.get(i).getBarDiameter());
                    cellBarLength.setCellValue(blockList.get(i).getBarLength());
                    cellBarPieces.setCellValue(blockList.get(i).getBarPieces());
                }
                
                int startHideRow = blockList.size() + 3;
                int endHideRow = 202;                               // REMEMBER TO TYPE CORRECT VALUE FROM XLS SHEET
                for (int i = startHideRow; i <= endHideRow; i++) {
                    worksheet.getRow(i).setHeight((short) 0);
                }
                
                // Refreshing FormulaCells
                HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
                
                Cell fi6 = worksheet.getRow(endHideRow + 1).getCell(4);
                Cell fi8 = worksheet.getRow(endHideRow + 1).getCell(5);
                Cell fi10 = worksheet.getRow(endHideRow + 1).getCell(6);
                Cell fi12 = worksheet.getRow(endHideRow + 1).getCell(7);
                Cell fi14 = worksheet.getRow(endHideRow + 1).getCell(8);
                Cell fi16 = worksheet.getRow(endHideRow + 1).getCell(9);
                Cell fi18 = worksheet.getRow(endHideRow + 1).getCell(10);
                Cell fi20 = worksheet.getRow(endHideRow + 1).getCell(11);
                Cell fi22 = worksheet.getRow(endHideRow + 1).getCell(12);
                Cell fi25 = worksheet.getRow(endHideRow + 1).getCell(13);
                Cell fi28 = worksheet.getRow(endHideRow + 1).getCell(14);
                Cell fi32 = worksheet.getRow(endHideRow + 1).getCell(15);
                
                if (fi6.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(4,true);
                }
                
                if (fi8.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(5,true);
                }

                if (fi10.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(6,true);
                }

                if (fi12.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(7,true);
                }

                if (fi14.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(8,true);
                }

                if (fi16.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(9,true);
                }

                if (fi18.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(10,true);
                }

                if (fi20.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(11,true);
                }

                if (fi22.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(12,true);
                }

                if (fi25.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(13,true);
                }

                if (fi28.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(14,true);
                }

                if (fi32.getNumericCellValue() == 0) {
                    worksheet.setColumnHidden(15,true);
                }                
                
                
                wb.createSheet("sheet");
                fileInputStream.close();

                FileOutputStream fileOutputStream = new FileOutputStream(selectedFile.getAbsolutePath());
                wb.write(fileOutputStream);
                fileOutputStream.close();
                JOptionPane.showMessageDialog(null, "Plik .xls został pomyślnie zapisany");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_FilePath;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_BlockName;
    // End of variables declaration//GEN-END:variables
}
