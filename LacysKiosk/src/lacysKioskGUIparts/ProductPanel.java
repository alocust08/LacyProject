
package lacysKioskGUIparts;

import lacysKioskLogicparts.Products;

/**
 * Product panel to display product information to customer
 * @author Alisha
 */
public class ProductPanel extends javax.swing.JPanel {

    Products product; //Hold product for each panel
    //Messages review;
    
    /**
     * Creates new form ProductPanel
     */
    public ProductPanel() { //Default constructor
        initComponents();
    }
    
    public ProductPanel(Products prod) //Constructor with Inventory object passed in
    {
        initComponents();
        product = prod;
        setProductPanel(prod);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        starRater1 = new lacysKioskGUIparts.StarRater();
        ratingLabel = new javax.swing.JLabel();
        ratingNumText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        checkReviewsButton = new javax.swing.JButton();
        writeReviewButton = new javax.swing.JButton();
        imagePanel = new javax.swing.JPanel();

        itemLabel.setText("Item Name: ");
        itemLabel.setToolTipText("");

        priceLabel.setText("Price: ");

        ratingLabel.setLabelFor(ratingNumText);
        ratingLabel.setText("Rating: ");

        descriptionArea.setEditable(false);
        descriptionArea.setColumns(20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        addButton.setText("Add To Cart");
        addButton.setToolTipText("");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        checkReviewsButton.setText("Check Reviews");
        checkReviewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkReviewsButtonActionPerformed(evt);
            }
        });

        writeReviewButton.setText("Write Review");
        writeReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeReviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ratingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ratingNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(starRater1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkReviewsButton)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 29, Short.MAX_VALUE)
                                .addComponent(writeReviewButton)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(starRater1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ratingLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ratingNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(writeReviewButton)
                    .addComponent(checkReviewsButton)
                    .addComponent(addButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //Bring up pop up window for add to cart
        AddToCartPopUp addPopUp = MainPage.getCartPopUp(); //Get static add to cart pop up from main page
        addPopUp.setUpAddPopUp(product); //Set up the add pop up window with product information
        addPopUp.setVisible(true); //Make the pop up visible
    }//GEN-LAST:event_addButtonActionPerformed

    private void checkReviewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkReviewsButtonActionPerformed
        //Open pop up window for reviews of product written by customers
        CheckReviewsPopUp reviewsPopUp = MainPage.getReviewsPopUp();
        reviewsPopUp.setUpReviewsPopUp(product);
        reviewsPopUp.setVisible(true);
        
    }//GEN-LAST:event_checkReviewsButtonActionPerformed

    private void writeReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeReviewButtonActionPerformed
        //Open pop up window to write a review for a product
        ReviewPopUp writePopUp = MainPage.getReviewPopUp();
        writePopUp.setUpWritePopUp(product);
        writePopUp.setVisible(true);
    }//GEN-LAST:event_writeReviewButtonActionPerformed

    public void setProductPanel(Products product){ //set up product panel
        itemLabel.setText(product.getProductName());
        priceLabel.setText("$" + String.format("%,.2f", product.getUnitPrice()));
        descriptionArea.setText(product.getDescription());
        starRater1.setRating((float) convertToStarRating(product.getRate()));
        ratingNumText.setText(String.format("%.1f%%", product.getRate()));
    }
    
    private double convertToStarRating(double rating)
    {
        //Take a percentage number (ex: 10 not .10 for 10%) and convert to star's rating system of 5
        //Multiply the rating by 5 which is the star's highest rating. Then divide that by 100
        return (5.0 * rating) / 100.0;
    }
    
    private double convertToRegularRating(double rating)
    {
        //Take the star's rating and conver to percentage out of 100
        //Mulitply the rating by 100 (which is the regular highest rating). Then divide by 5.
        return (100.0 * rating) / 5.0; 
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton checkReviewsButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JTextField ratingNumText;
    private lacysKioskGUIparts.StarRater starRater1;
    private javax.swing.JButton writeReviewButton;
    // End of variables declaration//GEN-END:variables
}
