/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HandsVeinRegistration.java
 *
 * Created on Oct 24, 2012, 9:58:05 AM
 */
package handsveindetection;

import handsveindetection.db.HandsVeinDBInstantiate;
import handsveindetection.db.HandsVeinDao;
import handsveindetection.db.HandsVeinDetails;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Amar
 */
public class HandsVeinRegistration extends javax.swing.JPanel {
//
  
    //"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
   private static final String EMAIL_PATTERN ="^([\\w]((\\.(?!\\.))|[-!#\\$%'\\*\\+/=\\?\\^`\\{\\}\\|~\\w])*)(?<=[\\w])@(([\\w][-\\w]*[\\w]\\.)+[a-zA-Z]{2,6})$"; ;

   private static final String NUMBER_PATTERN="\\d{10}";
    /** Creates new form HandsVeinRegistration */
    public HandsVeinRegistration() {
        initComponents();
    }

   private boolean valiDateInput(){
       
    if(regnameText.getText().trim().length()==0){
             JOptionPane.showMessageDialog(this, "Name can not be blank");
         return false;
     }
   
    else if(regcontactNumberText.getText().trim().length()!=10){
                JOptionPane.showMessageDialog(this, "Contact Must be of 10 digit numeric value");
                return false;
     }
         
    else if(!Pattern.matches(NUMBER_PATTERN, regcontactNumberText.getText())){
        JOptionPane.showMessageDialog(this, "Contact Must be of 10 digit numeric value");
                return false;
     }
    else if((regemaillText.getText().trim().length()==0)){
        JOptionPane.showMessageDialog(this, "Email can not be blank");
       return false;
    }
    else if(!Pattern.matches(EMAIL_PATTERN, regemaillText.getText())){
         JOptionPane.showMessageDialog(this, "Please Enter Valid Emial Id ");
       return false;
     }
   
         
   else if( regaddressText.getText().trim().length()==0){
        JOptionPane.showMessageDialog(this, "Address can not be blank");
       return false;
    }
    
    else if(regimageLabel.getIcon()==null){
           JOptionPane.showMessageDialog(this, "Password can not be blank");
         return false;
     }
     return true;
   } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reglogo = new javax.swing.JLabel();
        regNameLabel = new javax.swing.JLabel();
        regnameText = new javax.swing.JTextField();
        regContactNumberLabel = new javax.swing.JLabel();
        regcontactNumberText = new javax.swing.JTextField();
        regEmailIdLabel = new javax.swing.JLabel();
        regemaillText = new javax.swing.JTextField();
        regaddresslabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        regaddressText = new javax.swing.JTextArea();
        regPaswordLabel = new javax.swing.JLabel();
        regimageLabel = new javax.swing.JLabel();
        regSubmitButton = new javax.swing.JButton();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(600, 480));

        reglogo.setFont(new java.awt.Font("Tahoma", 1, 12));
        reglogo.setText("              New User Registration Form");

        regNameLabel.setText("Name");

        regnameText.setText("jTextField1");

        regContactNumberLabel.setText("Contact Number");

        regcontactNumberText.setText("jTextField2");

        regEmailIdLabel.setText("Email Id");

        regemaillText.setText("jTextField3");

        regaddresslabel.setText("Addresss");

        regaddressText.setColumns(20);
        regaddressText.setRows(5);
        jScrollPane1.setViewportView(regaddressText);

        regPaswordLabel.setText("Password");

        regimageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/handsveindetection/vein.jpg"))); // NOI18N
        regimageLabel.setText("jLabel7");

        regSubmitButton.setText("Submit");
        regSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(reglogo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regEmailIdLabel)
                            .addComponent(regPaswordLabel)
                            .addComponent(regaddresslabel)
                            .addComponent(regContactNumberLabel)
                            .addComponent(regNameLabel))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(regSubmitButton)
                            .addComponent(regemaillText)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(regnameText, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(regcontactNumberText)
                            .addComponent(regimageLabel, 0, 0, Short.MAX_VALUE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reglogo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regcontactNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regContactNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regemaillText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regEmailIdLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(regaddresslabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regimageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(regSubmitButton))
                    .addComponent(regPaswordLabel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void regSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regSubmitButtonActionPerformed
// TODO add your handling code here:
    if(valiDateInput()){
          HandsVeinDao handsVeinDao = HandsVeinDBInstantiate.getHandsVeinDao();
          HandsVeinDetails handsVeinDetails= new HandsVeinDetails();
          handsVeinDetails.setUserName(regnameText.getText().trim());
          handsVeinDetails.setContactNumber(regcontactNumberText.getText().trim());
          handsVeinDetails.setEmail(regemaillText.getText().trim());
          handsVeinDetails.setAddress(regaddressText.getText().trim());
          ImageIcon icon=(ImageIcon) regimageLabel.getIcon();
          Image image= icon.getImage();
          ByteArrayOutputStream byteArrayOutputStream=null;
          try{
                byteArrayOutputStream= new ByteArrayOutputStream();
                ImageIO.write(new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_BYTE_GRAY), "jpg", byteArrayOutputStream);
                byte imagebyte[] = byteArrayOutputStream.toByteArray();
                handsVeinDetails.setPassword(imagebyte);
               // System.out.println(new String(imagebyte));

          }catch(Throwable t){
              t.printStackTrace();
          }finally{
              try{
                   byteArrayOutputStream.close();
              }catch(Throwable e){
                  e.printStackTrace();;
              }

          }
          String dbGeneratedUserId = handsVeinDao.generateId(handsVeinDetails);
          JOptionPane.showMessageDialog(this, "your user Id "+dbGeneratedUserId);
    }
}//GEN-LAST:event_regSubmitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel regContactNumberLabel;
    private javax.swing.JLabel regEmailIdLabel;
    private javax.swing.JLabel regNameLabel;
    private javax.swing.JLabel regPaswordLabel;
    private javax.swing.JButton regSubmitButton;
    private javax.swing.JTextArea regaddressText;
    private javax.swing.JLabel regaddresslabel;
    private javax.swing.JTextField regcontactNumberText;
    private javax.swing.JTextField regemaillText;
    private javax.swing.JLabel regimageLabel;
    private javax.swing.JLabel reglogo;
    private javax.swing.JTextField regnameText;
    // End of variables declaration//GEN-END:variables
}
