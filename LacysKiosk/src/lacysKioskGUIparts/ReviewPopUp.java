/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskGUIparts;

import lacysKioskLogicparts.Products;

/**
 *
 * @author Alisha
 */
public class ReviewPopUp extends javax.swing.JInternalFrame {

    Products product;
    /**
     * Creates new form reviewPopUp
     */
    public ReviewPopUp() {
        initComponents();
        setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        reviewSubmitBtn = new javax.swing.JButton();
        reviewCancelBtn = new javax.swing.JButton();
        reviewProductLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        reviewTextArea.setColumns(20);
        reviewTextArea.setRows(5);
        jScrollPane1.setViewportView(reviewTextArea);

        reviewSubmitBtn.setText("Submit");
        reviewSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewSubmitBtnActionPerformed(evt);
            }
        });

        reviewCancelBtn.setText("Cancel");
        reviewCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewCancelBtnActionPerformed(evt);
            }
        });

        reviewProductLbl.setText("Product: ");

        jLabel2.setText("Enter review below:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(reviewSubmitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reviewCancelBtn)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(reviewProductLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reviewProductLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewSubmitBtn)
                    .addComponent(reviewCancelBtn))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reviewSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewSubmitBtnActionPerformed
        // TODO add your handling code here:
        String review = reviewTextArea.getText();
        MainPage.getEManager().addReview(review, product);
        setVisible(false);
    }//GEN-LAST:event_reviewSubmitBtnActionPerformed

    private void reviewCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewCancelBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_reviewCancelBtnActionPerformed

    public void setUpWritePopUp(Products product)
    {
        this.product = product;
        reviewTextArea.setText("");
        reviewProductLbl.setText("Product: " + product.getProductName());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reviewCancelBtn;
    private javax.swing.JLabel reviewProductLbl;
    private javax.swing.JButton reviewSubmitBtn;
    private javax.swing.JTextArea reviewTextArea;
    // End of variables declaration//GEN-END:variables
}
