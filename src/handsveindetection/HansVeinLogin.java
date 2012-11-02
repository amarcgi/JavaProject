/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HansVeinLogin.java
 *
 * Created on Oct 24, 2012, 9:57:50 AM
 */
package handsveindetection;

import handsveindetection.db.HandsVeinDBInstantiate;
import handsveindetection.db.HandsVeinDao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Amar
 */
public class HansVeinLogin extends javax.swing.JPanel {

    /** Creates new form HansVeinLogin */
    public HansVeinLogin() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        userIdtext = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Login with your User Id and Hands Vein");

        userIdLabel.setText("User Id");

        userIdtext.setText("jTextField1");

        passwordLabel.setText("Password");

        imageLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Amar\\Desktop\\vein.jpg")); // NOI18N

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIdLabel)
                            .addComponent(passwordLabel))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(SubmitButton)
                            .addComponent(userIdtext))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdLabel)
                    .addComponent(userIdtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubmitButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
    label:{
    if(validateField()){
                String userId=userIdtext.getText();
                int length = userId.length();
                int findcharIndex=0;
                for(int i=0;i<length;i++){
                   if(userId.charAt(i)=='@'){
                       findcharIndex=i;
                       break;
                   }
                 }
                String pk=userId.substring(findcharIndex+1, length);
                int pkValue=0;
                try{
                pkValue= Integer.parseInt(pk);  
                }catch(NumberFormatException e){
                   e.printStackTrace();
                    break label;
                 }
                 HandsVeinDao handsVeinDao = HandsVeinDBInstantiate.getHandsVeinDao();
                 if(handsVeinDao.checkUserId(pkValue)){
                     ImageIcon icon=(ImageIcon) imageLabel.getIcon();
                     Image image= icon.getImage();
                     ByteArrayOutputStream baos = new ByteArrayOutputStream();
                     try{
                       ImageIO.write(new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_BYTE_GRAY), "jpg", baos);  
                     }catch(Exception t){
                         t.printStackTrace(); 
                     }

                    if(handsVeinDao.checkPassword(baos.toByteArray(), pkValue)){
                           JOptionPane.showMessageDialog(this, "Login Sucessfull");
                       }
                    else{
                        JOptionPane.showMessageDialog(this, "You are not authorized User");
                    }
                 } 
                 else{
                    JOptionPane.showMessageDialog(this, "User Id Does Not Exist Please Registared");  
                 }
          }
 }
}//GEN-LAST:event_SubmitButtonActionPerformed

 public boolean validateField(){
        if(userIdtext.getText().trim().length()==0){
            JOptionPane.showMessageDialog(HansVeinLogin.this, "Plase Enetr Valid User ID");
            return false;
        
        }
        if(imageLabel.getIcon()==null){
            JOptionPane.showMessageDialog(HansVeinLogin.this, "Plase Enetr Valid Password");
            return false;
        }
        return true;
    }
   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JTextField userIdtext;
    // End of variables declaration//GEN-END:variables
}