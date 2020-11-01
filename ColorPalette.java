/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/**
 *
 * @author BHARATH sharan
 */

public class ColorPalette extends Applet implements
ActionListener, ItemListener {
Button btnRed, btnGreen, btnBlue;
String str = "";
CheckboxGroup cbgColor;
CheckboxGroup cbgImage;
Checkbox optFore, optBack;
Checkbox optMb, optWsb;
Image imgMb, imgWsb;
TextArea txtaComments = new TextArea("", 5, 30);

public void init() {
setLayout(new GridLayout(4, 3));
cbgColor = new CheckboxGroup();
cbgImage = new CheckboxGroup();
Label lblColor = new Label("Select the Area :") ;
Label lblImage = new Label("Select the Image :") ;
optFore = new Checkbox("Foreground", cbgColor,true);
optBack = new Checkbox("Background", cbgColor,false);
optMb = new Checkbox("REC-Main Block", cbgImage,true);
optWsb = new Checkbox("REC-Workshop Block",cbgImage, false);
btnRed = new Button("Red");
btnGreen = new Button("Green");
btnBlue = new Button("Blue");


imgMb = getImage(getDocumentBase(),
getParameter("recmb"));
imgWsb = getImage(getDocumentBase(),
getParameter("recwsb"));
add(btnRed);
add(btnGreen);
add(btnBlue);
add(lblColor);
add(optFore);
add(optBack);
add(lblImage);
add(optMb);
add(optWsb);
add(txtaComments);
optFore.addItemListener(this);
optBack.addItemListener(this);
optMb.addItemListener(this);
optWsb.addItemListener(this);
btnRed.addActionListener(this);
btnGreen.addActionListener(this);
btnBlue.addActionListener(this);
}
public void actionPerformed(ActionEvent ae) {
str = cbgColor.getSelectedCheckbox().getLabel() ;
if(ae.getSource() == btnRed &&
str.equals("Background")) {
txtaComments.setBackground(Color.red);
}
if(ae.getSource() == btnRed &&
str.equals("Foreground")) {
txtaComments.setForeground(Color.red);
}
if(ae.getSource() == btnGreen &&
str.equals("Background")) {
txtaComments.setBackground(Color.green);
}
if(ae.getSource() == btnGreen &&
str.equals("Foreground")) {
txtaComments.setForeground(Color.green);
}
if(ae.getSource() == btnBlue &&
str.equals("Background")) {
txtaComments.setBackground(Color.blue);
}

if(ae.getSource() == btnBlue &&
str.equals("Foreground")) {
txtaComments.setForeground(Color.blue);
}
}
public void itemStateChanged(ItemEvent ie) {
repaint();
}
public void paint(Graphics g) {
if(optMb.getState() == true)
g.drawImage(imgMb, 200, 400, this) ;
if(optWsb.getState() == true)
g.drawImage(imgWsb, 200, 400, this) ;
}
}