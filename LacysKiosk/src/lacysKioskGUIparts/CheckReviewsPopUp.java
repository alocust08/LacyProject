
package lacysKioskGUIparts;

import java.util.Collection;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lacysKioskLogicparts.Messages;
import lacysKioskLogicparts.Products;

/**
 * Internal frame pop up to show reviews for a product
 * @author Alisha
 */
public class CheckReviewsPopUp extends javax.swing.JInternalFrame {

    Products product;
    /**
     * Creates new form CheckReviewsPopUp
     */
    public CheckReviewsPopUp() {
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

        reviewsForLabel = new javax.swing.JLabel();
        productNameLabel = new javax.swing.JLabel();
        reviewsPanel = new javax.swing.JPanel();
        reviewCloseBtn = new javax.swing.JButton();

        setTitle("Reviews");

        reviewsForLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reviewsForLabel.setText("Reviews for");

        productNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productNameLabel.setText("some product here");

        reviewsPanel.setAutoscrolls(true);

        javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
        reviewsPanel.setLayout(reviewsPanelLayout);
        reviewsPanelLayout.setHorizontalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        reviewCloseBtn.setText("Close");
        reviewCloseBtn.setToolTipText("");
        reviewCloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewCloseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(reviewsForLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productNameLabel)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reviewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(reviewCloseBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewsForLabel)
                    .addComponent(productNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(reviewCloseBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reviewCloseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewCloseBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_reviewCloseBtnActionPerformed

    
    public void setUpReviewsPopUp(Products product) //Set up frame with review panels
    {
        this.product = product;
        
        productNameLabel.setText(product.getProductName());
        
        reviewsPanel.removeAll(); //clear everything from panel from possible previous browse
        JPanel viewPanel = new JPanel();
        viewPanel.setSize(reviewsPanel.getWidth(), reviewsPanel.getHeight());
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollpanel = new JScrollPane(); //Scrollpanel so can see all reviews shown
        scrollpanel.setSize(reviewsPanel.getWidth(), reviewsPanel.getHeight());
        
        Collection<Messages> allReviews = product.getMessagesCollection();
        Iterator iter = allReviews.iterator();
        while (iter.hasNext())
        {
            Messages review = (Messages) iter.next();
            ReviewPanel revPanel = new ReviewPanel();
            revPanel.setUpReviewPanel(review, product.getRate());
            viewPanel.add(revPanel);    
        }
        
        scrollpanel.setViewportView(viewPanel);
        reviewsPanel.add(scrollpanel);
        reviewsPanel.revalidate();
        reviewsPanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JButton reviewCloseBtn;
    private javax.swing.JLabel reviewsForLabel;
    private javax.swing.JPanel reviewsPanel;
    // End of variables declaration//GEN-END:variables
}
