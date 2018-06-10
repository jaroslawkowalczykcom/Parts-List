package filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    private List<BlockHeader> blockListHeader = new ArrayList<>();
    private List<Block> blockList = new ArrayList<>();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_FilePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE))
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

                String firstLine = bufferedReader.readLine().trim();
                String[] columnName = firstLine.split("\\s+");
                blockListHeader.add(new BlockHeader(columnName[0], columnName[1], columnName[2], columnName[3], columnName[4], columnName[5]));
                DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                model.setColumnIdentifiers(columnName);

                Object[] tableLines = bufferedReader.lines().toArray();

                for (int i = 0; i < tableLines.length; i++) {
                    String line = tableLines[i].toString().trim();
                    String[] dataRow = line.split("\\s+");
                    blockList.add(new Block(Integer.parseInt(dataRow[0]), dataRow[1], Integer.parseInt(dataRow[2]), Integer.parseInt(dataRow[3]), Integer.parseInt(dataRow[4]), Integer.parseInt(dataRow[5])));
                    model.addRow(dataRow);
                }
                reader.close();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
            }
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
                Cell cellNrPoz = null;
                Cell cellSrednica = null;
                Cell cellDlugosc = null;
                Cell cellSztuki = null;
                

                for (int i = 0; i < blockList.size(); i++) {
                    System.out.println(blockList.get(i));

                    cellNrPoz = worksheet.getRow(i + 3).getCell(0);
                    cellSrednica = worksheet.getRow(i + 3).getCell(1);
                    cellDlugosc = worksheet.getRow(i + 3).getCell(2);
                    cellSztuki = worksheet.getRow(i + 3).getCell(3);

                    cellNrPoz.setCellValue(blockList.get(i).getNrPoz());
                    cellSrednica.setCellValue(blockList.get(i).getSrednica());
                    cellDlugosc.setCellValue(blockList.get(i).getDlugosc());
                    cellSztuki.setCellValue(blockList.get(i).getSztuki());
                    
                  
                    
//                    if(blockList.get(i).getSrednica() != 6) {
//                        worksheet.setColumnHidden(4, true);
//                    } 
//                    
//                    if (blockList.get(i).getSrednica() != 8) {
//                        worksheet.setColumnHidden(5, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 10) {
//                        worksheet.setColumnHidden(6, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 12) {
//                        worksheet.setColumnHidden(7, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 14) {
//                        worksheet.setColumnHidden(8, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 16) {
//                        worksheet.setColumnHidden(9, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 18) {
//                        worksheet.setColumnHidden(10, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 20) {
//                        worksheet.setColumnHidden(11, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 22) {
//                        worksheet.setColumnHidden(12, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 25) {
//                        worksheet.setColumnHidden(13, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 28) {
//                        worksheet.setColumnHidden(14, true);
//                    }
//                    
//                    if (blockList.get(i).getSrednica() != 32) {
//                        worksheet.setColumnHidden(15, true);
//                    }                     
                    
                    
                }
                
                int startHideRow = blockList.size() + 3;
                int endHideRow = 202;   // Number depends on Excel sheet. Remember (lastRowToDelete - 1)
               
                for (int i = startHideRow; i <= endHideRow; i++) {
                    worksheet.getRow(i).setHeight((short) 0);
                }
                
                HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
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
    private javax.swing.JLabel jLabel_FilePath;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
