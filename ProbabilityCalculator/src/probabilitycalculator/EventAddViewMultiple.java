/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilitycalculator;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Ramon
 */
public class EventAddViewMultiple extends javax.swing.JFrame {

    /**
     * Creates new form EventAddView
     */
    private CalculatorView mainView;
    private String[] cardNames;
    private List<Card> cardList;
    private int totalCards;
    private int drawCount;
    private int temp;
    
    public EventAddViewMultiple(){
        
    }
    public EventAddViewMultiple(CalculatorView mainView, String[] cardNames, List<Card> cardList, int totalCards, int drawCount, int temp) {
        initComponents();
        
   
        
        this.mainView = mainView;
        this.cardNames = cardNames;
        this.cardList = cardList;
        this.totalCards = totalCards;
        this.drawCount = drawCount;
        this.temp = temp;
        initEvtComboBox();
    }
    
    private void initEvtComboBox(){
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardNameBtnGroup = new javax.swing.ButtonGroup();
        repBtnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        eventName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        rarityComboBox = new javax.swing.JComboBox<>();
        costComboBox = new javax.swing.JComboBox<>();
        cardnameLbl = new javax.swing.JLabel();
        replacementLbl = new javax.swing.JLabel();
        useCardComboBox = new javax.swing.JComboBox<>();
        replacementComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter event name:");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton(evt);
            }
        });

        jLabel4.setText("Card Name:");

        nameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "Blazing Breath", "Unicorn Dancer Unica", "Wind Reader Zell", "Dragon Oracle", "Breath of the Salamander", "Grimnir, War Cyclone", "Imprisoned Dragon", "Dragon Warrior", "Rahab", "Sibyl of the Waterwyrm", "Draconic Fervor", "Lightning Blast", "Sahaquiel", "Lucifer", "Ouroboros", "Israfil", "Bahamut" }));

        jLabel5.setText("Card Type:");

        jLabel6.setText("Card Rarity:");

        jLabel7.setText("Card Cost:");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "Follower", "Spell", "Amulet" }));

        rarityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "Bronze", "Silver", "Gold", "Legendary" }));

        costComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cardnameLbl.setText("Use card name?");

        replacementLbl.setText("With replacement?");

        useCardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        replacementComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(eventName, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rarityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(costComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cardnameLbl)
                                .addGap(18, 18, 18)
                                .addComponent(useCardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(replacementLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(replacementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardnameLbl)
                    .addComponent(useCardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replacementLbl)
                    .addComponent(replacementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rarityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(costComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jButton1)
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
    }// </editor-fold>//GEN-END:initComponents

    private void addButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton
        // TODO add your handling code here:
        
        //if radio button yes is selected, only count the card name
        //if radio button no is selected, do not count card name and count everything else
        
        // radio button for with replacement
   
        //if radio button yes code part:
    
        //if radio button no code part:
        int count = 0;
        boolean rarityFlag = true;
        boolean typeFlag = true;
        boolean costFlag = true;
        for(int i = 0; i < cardList.size(); i++){
            if(!(nameComboBox.getSelectedItem().toString().equals("Any"))){
                if(nameComboBox.getSelectedItem().toString().equals(cardList.get(i).getName())){
                    count+=cardList.get(i).getNumberOf();
                }
            }
            else{
                
            
                if(typeComboBox.getSelectedItem().toString().equals("Any")){
                
                }
                else{
                    if(typeComboBox.getSelectedItem().toString().equals(cardList.get(i).getType()))
                        typeFlag = true;
                    else typeFlag = false;
                }
            
                if(rarityComboBox.getSelectedItem().toString().equals("Any")){
                
                }
                else
                    if(rarityComboBox.getSelectedItem().toString().equals(cardList.get(i).getRarity()))
                        rarityFlag = true;
                    else rarityFlag = false;
            
                if(costComboBox.getSelectedItem().toString().equals("Any")){
                
                }
                else
                    if(Integer.parseInt(costComboBox.getSelectedItem().toString()) == cardList.get(i).getCost())
                        costFlag = true;
                    else costFlag = false;
                
                
              
                if(typeFlag && rarityFlag && costFlag){
                //System.out.print(cardList.get(i).getName());
                    count+=cardList.get(i).getNumberOf();
                    rarityFlag = true;
                    typeFlag = true;
                    costFlag = true;
                   
                }
            }
        }
   
        System.out.print(count);
        Event newEvent = new Event(eventName.getText().toString(), count, totalCards, "none", nameComboBox.getSelectedItem().toString(), typeComboBox.getSelectedItem().toString(), rarityComboBox.getSelectedItem().toString(), costComboBox.getSelectedItem().toString());
        
        if(replacementComboBox.getSelectedItem().toString().equals("No")){
            
            if(useCardComboBox.getSelectedItem().toString().equals("Yes")){
                
                mainView.selectedNameRadioBtn = 1;
                
            }
            else{
                System.out.println("It went here on second pass!");
                mainView.selectedNameRadioBtn = 0;
            }
            
            mainView.lastSelectedCost = costComboBox.getSelectedItem().toString();
            //System.out.print(mainView.lastSelectedCost);
            mainView.lastSelectedType = typeComboBox.getSelectedItem().toString();
            mainView.lastSelectedRarity = rarityComboBox.getSelectedItem().toString();
            mainView.lastSelectedName = nameComboBox.getSelectedItem().toString();
            mainView.updateCalc(newEvent, 3);
        }
        else if(replacementComboBox.getSelectedItem().toString().equals("Yes")){
            mainView.updateCalc(newEvent, 4);
        }
        else{
            mainView.updateCalc(newEvent, 0);
        }
        if(drawCount > 0){
            EventAddViewMultiple evtAddMtl = new EventAddViewMultiple(mainView, cardNames, mainView.getCardList(), mainView.getTotalCards(), drawCount - 1, temp);
            evtAddMtl.setVisible(true);
            
        }
        else{
            mainView.updateMultiple(temp);
        }
        dispose();
    }//GEN-LAST:event_addButton

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
            java.util.logging.Logger.getLogger(EventAddViewMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventAddViewMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventAddViewMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventAddViewMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventAddViewMultiple().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup cardNameBtnGroup;
    private javax.swing.JLabel cardnameLbl;
    private javax.swing.JComboBox<String> costComboBox;
    private javax.swing.JTextField eventName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nameComboBox;
    private javax.swing.JComboBox<String> rarityComboBox;
    private javax.swing.ButtonGroup repBtnGroup;
    private javax.swing.JComboBox<String> replacementComboBox;
    private javax.swing.JLabel replacementLbl;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JComboBox<String> useCardComboBox;
    // End of variables declaration//GEN-END:variables
}
