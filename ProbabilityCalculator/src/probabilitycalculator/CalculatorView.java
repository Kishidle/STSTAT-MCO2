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
    int prevTotalCards = totalCards;
    int totalEvents = 0;
    float currProb = 0;
    List<Card> cards = new ArrayList<Card>();
    String lastSelectedName;
    String lastSelectedRarity;
    String lastSelectedType;
    String lastSelectedCost;
    int selectedNameRadioBtn;
    private DefaultListModel lModel;
    
    private Event event;
    
    List<Event> events = new ArrayList<Event>();
    
    public CalculatorView() {
        initComponents();
        lModel = new DefaultListModel();
        evtList.setModel(lModel);
        //System.out.println(cardnames.length);
        //System.out.println(cardtype.length);
        //System.out.println(cardrarity.length);
        //System.out.println(cardcost.length);
        //System.out.println(numdeck.length);
        //System.out.println(numAnimated.length);
        
        for(int i = 0; i < 17; i++){
            Card temp = new Card(cardnames[i], cardtype[i], cardrarity[i], cardcost[i], numdeck[i], numAnimated[i]);
            temp.setPrev(numdeck[i]);
            cards.add(temp);
        }
        
      
    }
    public int getTotalCards(){
        return totalCards;
    }
    public List<Card> getCardList(){
        return cards;
    }
    public void updateMultiple(int temp){
        currProb = currProb * temp;
    }
    public void updateCalc(Event event, int flag){
        this.event = event;
       
        
        events.add(event);
       
        
        totalEvents++;
        //get probability of event from eventAddView
        
        /*if(flag == 0){ //first event entered into the system
            currProb = event.getSmallN() / event.getBigN();
        }*/
        if(flag == 1){ //from OR
            String temp = lModel.getElementAt(lModel.getSize() - 1).toString();
            temp = temp + " OR " + event.getName();
            lModel.setElementAt(temp, lModel.getSize() - 1);
            currProb = currProb + (event.getSmallN() / event.getBigN()); //does not work yet!! just guideline or something
        }
        else if(flag == 2){ //from AND
            String temp = lModel.getElementAt(lModel.getSize() - 1).toString();
            temp = temp + " AND " + event.getName();
            lModel.setElementAt(temp, lModel.getSize() - 1);
            boolean mutualEx = false;
            Event tempEvent = events.get(events.size() - 2);
            if(!tempEvent.getSelectedName().equals("Any") && !event.getSelectedName().equals("Any") ){
                mutualEx = true;
                
            }
            if(!tempEvent.getSelectedType().equals("Any") && !event.getSelectedType().equals("Any")){
                mutualEx = true;
            }
            if(!tempEvent.getSelectedRarity().equals("Any") && !event.getSelectedRarity().equals("Any")){
                mutualEx = true;
            }
            if(!tempEvent.getSelectedCost().equals("Any") && !event.getSelectedCost().equals("Any")){
                mutualEx = true;
            }
            if(mutualEx){
                System.out.println("Mutually exclusive!");
                currProb = 0;
            }
            else
                System.out.println(event.getSmallN() + "/" + event.getBigN());
                currProb = currProb * (event.getSmallN() / event.getBigN()); // does not work yet!! just guideline or something
        }
        else if(flag == 3){ //from dependent events
            lModel.addElement(event.getName().toString());
            System.out.println("Selected Name Radio Button: " + selectedNameRadioBtn);
                
                if(totalEvents == 1){
                    
                    currProb = event.getSmallN() / event.getBigN();
                }
                else{
                    currProb = currProb * (event.getSmallN() / event.getBigN());
                }
                boolean foundCard = false;
                boolean rarityFlag = true;
                boolean typeFlag = true;
                boolean costFlag = true;
                System.out.println("It went to else!");
                System.out.println(lastSelectedCost);
                //find first card that meets conditions
            
                int i = 0;
                while(!foundCard && i < cards.size()){
                    if(selectedNameRadioBtn == 1){
                        if(cards.get(i).getName() == lastSelectedName){
                            if(cards.get(i).getNumberOf() != 0){
                                cards.get(i).setPrev(cards.get(i).getNumberOf());
                                int tempNum = cards.get(i).getNumberOf() - 1;
                                cards.get(i).setNumberOf(tempNum);
                                foundCard = true;
                            }
                        }
                    }
                    else if(selectedNameRadioBtn == 0){
                        System.out.println("test");
                        if(lastSelectedType.equals("Any")){
                            System.out.println("went here");
                        }
                        else{
                            if(lastSelectedType.equals(cards.get(i).getType()))
                                typeFlag = true;
                            else typeFlag = false;
                        }
                        if(lastSelectedRarity.equals("Any")){
                            System.out.println("went here2");
                        
                        }
                        else{
                            if(lastSelectedRarity.equals(cards.get(i).getRarity()))
                                rarityFlag = true;
                            else rarityFlag = false;
                        }
                        if(lastSelectedCost.equals("Any")){
                            System.out.println("went here3");
                        
                        }
                        else
                            if(Integer.parseInt(lastSelectedCost) == cards.get(i).getCost())
                                costFlag = true;
                            else costFlag = false;
                      
                    
                        if(costFlag && rarityFlag && typeFlag)
                            if(cards.get(i).getNumberOf() != 0){
                                cards.get(i).setPrev(cards.get(i).getNumberOf());
                                System.out.println(cards.get(i).getType());
                                System.out.println(cards.get(i).getRarity());
                                int tempNum = cards.get(i).getNumberOf() - 1;
                                System.out.println("Temp num: " + tempNum);
                                cards.get(i).setNumberOf(tempNum);
                                foundCard = true;
                            }
                        }
                    i++;
                }
     
            
           
            prevTotalCards = totalCards;
            totalCards--;
            
        }
        else if(flag == 4){ //from independent events
            lModel.addElement(event.getName().toString());
            if(totalEvents == 1)
                currProb = event.getSmallN() / event.getBigN();
            
            else
                currProb = currProb * (event.getSmallN() / event.getBigN());
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
        drawMultipleButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        drawMultipleButton.setText("Draw Multiple w/o Order");
        drawMultipleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawMultipleButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset!");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resetButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(drawMultipleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(orButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(andButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addEvtButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addEvtButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(orButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(andButton))
                    .addComponent(computeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drawMultipleButton)
                .addGap(1, 1, 1)
                .addComponent(resetButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            
            answerField.setText(String.format("%.6f", currProb));
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
            EventAddViewOA evtAdd = new EventAddViewOA(this, cardnames, cards, prevTotalCards, 1);
            evtAdd.setVisible(true);
        }
    }//GEN-LAST:event_orButtonActionPerformed

    private void andButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andButtonActionPerformed
        // TODO add your handling code here:
        if(totalEvents == 0){
            JOptionPane.showMessageDialog(this, "No events yet! :(");
        }
        else{
            EventAddViewOA evtAdd = new EventAddViewOA(this, cardnames, cards, prevTotalCards, 2);
            evtAdd.setVisible(true);
        }
    }//GEN-LAST:event_andButtonActionPerformed

    private void drawMultipleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawMultipleButtonActionPerformed
        // TODO add your handling code here:
        int drawCount = Integer.parseInt(JOptionPane.showInputDialog("How many cards will you draw?"));
        int temp = drawCount;
        
        EventAddViewMultiple evtAddMtl = new EventAddViewMultiple(this, cardnames, cards, totalCards, drawCount - 1, temp);
        evtAddMtl.setVisible(true);
    }//GEN-LAST:event_drawMultipleButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        CalculatorView newMain = new CalculatorView();
        dispose();
        newMain.setVisible(true);
    }//GEN-LAST:event_resetButtonActionPerformed

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
    private javax.swing.JButton drawMultipleButton;
    private javax.swing.JList<String> evtList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orButton;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables
}
