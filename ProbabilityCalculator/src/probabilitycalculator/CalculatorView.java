/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilitycalculator;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Ramon, Sam
 */
public class CalculatorView extends javax.swing.JFrame {

    /**
     * Creates new form CalculatorView
     */
    
    String[] cardnames = {"Blazing Breath", "Unicorn Dancer Unica", "Wind Reader Zell", "Dragon Oracle", "Breath of the Salamander", "Grimnir, War Cyclone", "Imprisoned Dragon", "Dragon Warrior", "Rahab", "Sibyl of the Waterwyrm", "Draconic Fervor", "Lightning Blast", "Sahaquiel", "Lucifer", "Ouroboros", "Israfil", "Bahamut"};
    String[] cardtype = {"Spell", "Follower", "Follower", "Spell", "Spell", "Follower", "Follower", "Follower", "Follower", "Follower", "Spell", "Spell", "Follower", "Follower", "Follower", "Follower", "Follower"};
    String[] cardrarity = {"Bronze", "Silver", "Silver", "Bronze", "Gold", "Gold", "Silver", "Silver", "Gold", "Legendary", "Silver", "Silver", "Legendary", "Legendary", "Legendary", "Legendary", "Legendary"};
    int[] cardcost = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 9, 10};
    int[] numdeck = {2, 3, 1, 3, 3, 2, 3, 3, 2, 2, 2, 2, 3, 3, 1, 2, 3};
    int[] numAnimated = {2, 0, 0, 0, 1, 2, 0, 3, 2, 2, 2, 1, 1, 0, 0, 0, 0};
    int totalCards = 40;
    int totalEvents = 0;
    float currProb = 0;
    List<Card> cards = new ArrayList<Card>();
    
    private Event event;
    
    List<Event> events = new ArrayList<Event>();
    
    public CalculatorView() {
        initComponents();
        
        //System.out.println(cardnames.length);
        //System.out.println(cardtype.length);
        //System.out.println(cardrarity.length);
        //System.out.println(cardcost.length);
        //System.out.println(numdeck.length);
        //System.out.println(numAnimated.length);
        
        for(int i = 0; i < 17; i++){
            Card temp = new Card(cardnames[i], cardtype[i], cardrarity[i], cardcost[i], numdeck[i], numAnimated[i]);
            
            cards.add(temp);
        }
        
      
    }
    
    public void updateCalc(Event event, int flag){
        this.event = event;
        events.add(event);
        totalEvents++;
        //get probability of event from eventAddView
        
        if(flag == 0){ //first event entered into the system
            currProb = event.getSmallN() / event.getBigN();
        }
        else if(flag == 1){ //from OR
            currProb = currProb + (event.getSmallN() / event.getBigN()); //does not work yet!! just guideline or something
        }
        else if(flag == 2){ //from AND
            currProb = currProb * (event.getSmallN() / event.getBigN()); // does not work yet!! just guideline or something
        }
        else if(flag == 3){ //from dependent events
            //same as flag 2 except there's a decrease in the total already
        }
        else if(flag == 4){ //from independent events
            //same as flag 1?
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        evtList = new javax.swing.JList<>();
        addEvtButton = new javax.swing.JButton();
        computeButton = new javax.swing.JButton();
        orButton = new javax.swing.JButton();
        andButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        evtList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(evtList);

        addEvtButton.setText("Add Event");
        addEvtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEvtButtonActionPerformed(evt);
            }
        });

        computeButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        computeButton.setText("Compute!");
        computeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeButtonActionPerformed(evt);
            }
        });

        orButton.setText("OR");
        orButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orButtonActionPerformed(evt);
            }
        });

        andButton.setText("AND");
        andButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                andButtonActionPerformed(evt);
            }
        });

        answerField.setEditable(false);
        answerField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jScrollPane2.setViewportView(answerField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(addEvtButton)
                        .addGap(30, 30, 30)
                        .addComponent(orButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(andButton)
                        .addGap(24, 24, 24)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEvtButton)
                    .addComponent(orButton)
                    .addComponent(andButton))
                .addGap(18, 18, 18)
                .addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void computeIndeConProbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeIndeConProbActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_computeIndeConProbActionPerformed

    private void addEvtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEvtButtonActionPerformed
        // TODO add your handling code here:
        EventAddView evtAdd = new EventAddView(this, cardnames, cards, totalCards);
        evtAdd.setVisible(true);
    }//GEN-LAST:event_addEvtButtonActionPerformed

    private void computeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeButtonActionPerformed
        // TODO add your handling code here:
        if(totalEvents > 0){
        answerField.setText(Float.toString(currProb));
        }
        else{
            JOptionPane.showMessageDialog(this, "No events yet! :(");
        }
    }//GEN-LAST:event_computeButtonActionPerformed

    private void orButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orButtonActionPerformed
        // TODO add your handling code here:
        if(totalEvents == 0){
            JOptionPane.showMessageDialog(this, "No events yet! :(");
        }
        else{
            EventAddViewOA evtAdd = new EventAddViewOA(this, cardnames, cards, totalCards, 1);
            evtAdd.setVisible(true);
        }
    }//GEN-LAST:event_orButtonActionPerformed

    private void andButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andButtonActionPerformed
        // TODO add your handling code here:
        if(totalEvents == 0){
            JOptionPane.showMessageDialog(this, "No events yet! :(");
        }
        else{
            EventAddViewOA evtAdd = new EventAddViewOA(this, cardnames, cards, totalCards, 2);
            evtAdd.setVisible(true);
        }
    }//GEN-LAST:event_andButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEvtButton;
    private javax.swing.JButton andButton;
    private javax.swing.JTextField answerField;
    private javax.swing.JButton computeButton;
    private javax.swing.JList<String> evtList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orButton;
    // End of variables declaration//GEN-END:variables
}
