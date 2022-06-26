/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package notepad;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
//import java.awt.Font;

public class Notepad extends Frame implements ActionListener {
    //Font font=new Font("30",Font.PLAIN,30);
    static String string;
    MenuBar mb=new MenuBar();
    //////
    Menu f=new Menu("File");
    Menu ed=new Menu("Edit");
    Menu fnt=new Menu("Font");
    //File menu
    MenuItem n=new MenuItem("New");
    MenuItem o=new MenuItem("Open");
    MenuItem sa=new MenuItem("Save");
    MenuItem ex=new MenuItem("Exit");
    //Edit menu
    MenuItem cu=new MenuItem("Cut");
    MenuItem co=new MenuItem("Copy");
    MenuItem pa=new MenuItem("Paste");
    MenuItem de=new MenuItem("Delete");
    //Font menu
    //size
    Menu s=new Menu("Size");
    
    //color
    Menu c=new Menu("Color");
    //
    MenuItem b=new MenuItem("blue");
    MenuItem r=new MenuItem("red");
    MenuItem g=new MenuItem("green");
    MenuItem bl=new MenuItem("black");
    
    //////
    TextArea txt=new TextArea(); 
    Notepad()
    {
        setTitle("Notepad");
        setBounds(100,100,500,400);
        f.add(n);
        //f.add(o);
        f.add(sa);
        f.add(ex);
        
        //ed.add(cu);
        ed.add(co);
        ed.add(pa);
        //ed.add(de);
        
        fnt.add(c);
        c.add(b);
        c.add(r);
        c.add(g);
       c.add(bl);
        
        fnt.add(s);
        
        
        
        
        mb.add(f);
        mb.add(ed);
        mb.add(fnt);
        
        setMenuBar(mb);
        add(txt);
        
        setVisible(true);
        //adding colors
        b.addActionListener(this);
        r.addActionListener(this);
        g.addActionListener(this);
        bl.addActionListener(this);
        //
        //edit
        co.addActionListener(this);
        pa.addActionListener(this);
        //file
        ex.addActionListener(this);
        n.addActionListener(this);
        sa.addActionListener(this);        
    }
    public static void main(String[] args) {
        Notepad note;
        // TODO code application logic here
        note = new Notepad();
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
    
        
        if(ae.getSource()==ex)
        {
            System.exit(0);
        }
        if(ae.getSource()==n)
        {
            txt.setText(" ");
        }
        if(ae.getSource()==sa)
        {
            

                String s = txt.getText();

                File f = new File("text.txt");
                FileWriter fw;
                try {
                    fw = new FileWriter(f);
                    fw.write(s);
                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            
        }
        // colors
        if(ae.getSource()==b)
        {
            txt.setForeground(Color.BLUE);
        }
        if(ae.getSource()==r)
        {
            txt.setForeground(Color.RED);
        }
        if(ae.getSource()==g)
        {
            txt.setForeground(Color.GREEN);
        }
        if(ae.getSource()==bl)
        {
            txt.setForeground(Color.BLACK);
        }
        //end colors
        if(ae.getSource()==co)
        {
            string=txt.getSelectedText();
        }
        if(ae.getSource()==pa)
        {
            txt.setText(txt.getText()+string);
        }
        
        
    }
    
}
