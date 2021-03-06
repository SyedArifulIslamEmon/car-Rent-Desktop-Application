/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent.UI;

//import RentAcarGUI.RentCarGUI1;
import carRent.BLL.CarBLL;
import carRent.DB.DAO.Car;
import java.sql.SQLException;
import java.util.ListIterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author noushad
 */
public class CarRegistrationUI extends javax.swing.JFrame {

    /**
     * Creates new form RentCarGUI1
     */
    private final CarBLL aCarBLL;

    public CarRegistrationUI() {

        initComponents();
        setLocationRelativeTo(null);
        this.aCarBLL = new CarBLL();
        fillCombo();
        getAllCarList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        carRegNoTextBox = new javax.swing.JTextField();
        carEngineNoTextBox = new javax.swing.JTextField();
        carSaveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        carListTable = new javax.swing.JTable();
        carModelComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setTitle("New Car Registration");
        setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(500, 680));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Registration Number");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(34, 36, 117, 16);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Engine Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(65, 78, 86, 16);

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Model Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(69, 120, 82, 16);

        carRegNoTextBox.setBackground(new java.awt.Color(204, 204, 204));
        carRegNoTextBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(carRegNoTextBox);
        carRegNoTextBox.setBounds(169, 32, 205, 20);

        carEngineNoTextBox.setBackground(new java.awt.Color(204, 204, 204));
        carEngineNoTextBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(carEngineNoTextBox);
        carEngineNoTextBox.setBounds(169, 74, 205, 20);

        carSaveButton.setText("Save");
        carSaveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        carSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carSaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(carSaveButton);
        carSaveButton.setBounds(274, 159, 100, 20);

        carListTable.setBackground(new java.awt.Color(204, 204, 204));
        carListTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        carListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Reg No.", "Engine No.", "Model"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(carListTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 220, 453, 403);

        carModelComboBox.setBackground(new java.awt.Color(204, 204, 204));
        carModelComboBox.setFont(new java.awt.Font("Gulim", 0, 12)); // NOI18N
        carModelComboBox.setBorder(null);
        getContentPane().add(carModelComboBox);
        carModelComboBox.setBounds(169, 116, 205, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carRent/UI/Black-Texture-Cool-Backgrounds.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carSaveButtonActionPerformed
        // TODO add your handling code here:
        try {
            String registrationNumber = carRegNoTextBox.getText();
            String engineNumber = carEngineNoTextBox.getText();
            String carModel = carModelComboBox.getSelectedItem().toString();
            Car aCar = new Car(carModel, engineNumber, registrationNumber);
            JOptionPane.showMessageDialog(rootPane, aCarBLL.save(aCar));
            getAllCarList();
            carEngineNoTextBox.setText("");
            carRegNoTextBox.setText("");
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_carSaveButtonActionPerformed

    private void fillCombo() {
        
        String[] models = {"Aston Martin DB11", "Audi A5 Sportback", "Audi R8 Spyder", "Bentley Mulsanne EWB", "BMW M2", "Bugatti Chiron", "Ford GT", "Honda NSX"};

        for (String model : models) {
            carModelComboBox.addItem(model);
        }
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarRegistrationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CarRegistrationUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carEngineNoTextBox;
    private javax.swing.JTable carListTable;
    private javax.swing.JComboBox<String> carModelComboBox;
    private javax.swing.JTextField carRegNoTextBox;
    private javax.swing.JButton carSaveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void getAllCarList() {
       try{
           String[] columnNames = {"ID","REG NO","ENGINE NO","MODEL"};
           DefaultTableModel model = new DefaultTableModel();
           model.setColumnIdentifiers(columnNames);
           carListTable.setModel(model);
           ListIterator litr = aCarBLL.getAllCars().listIterator();
           while(litr.hasNext()){
               Car aCar = (Car) litr.next();
               model.addRow(new Object[]{aCar.getId(),aCar.getregistrationNumber(),aCar.getEngineNumber(),aCar.getCarModel()});
           }
       }catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane, e.getMessage());
       }
    }
}
