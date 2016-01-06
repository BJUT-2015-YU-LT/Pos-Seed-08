package edu.team8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 帅 on 2016/1/6.
 */
public class BarcodeScanner extends JFrame implements ActionListener {

    private JPanel westPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel eastPanel;

    private JTextArea jta;
    private JTextArea jta2;

    private JButton btn_1;
    private JButton btn_2;
    private JButton btn_3;
    private JButton btn_4;
    private JButton btn_5;
    private JButton btn_6;
    private JButton btn_7;
    private JButton btn_8;
    private JButton btn_9;
    private JButton btn_10;
    private JButton btn_11;

    public BarcodeScanner(String sss) {
        super(sss);

        init();//窗口初始化

    }

    private void init() {
        this.setLayout(new BorderLayout());                           //布局
        this.setSize(1280,720);                                       //窗体大小
        this.setLocationRelativeTo(null);                             //让窗体居中显示
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //默认关闭模式

        westPanel=new JPanel(new GridLayout(10,1));
        southPanel=new JPanel(new GridLayout(1,1));
        centerPanel=new JPanel(new GridLayout(1,1));
        eastPanel=new JPanel(new GridLayout(1,1));

        jta=new JTextArea();
        jta.setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.BLUE));
        centerPanel.add(jta);

        jta2=new JTextArea();
        jta2.setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.GREEN));
        eastPanel.add(jta2);
        eastPanel.setPreferredSize(new Dimension(120,0));

        //将按钮添加到窗体中
        btn_1=new JButton("可乐");                                   //各种商品按钮
        btn_1.addActionListener(this);
        westPanel.add(btn_1);

        btn_2=new JButton("红牛");
        btn_2.addActionListener(this);
        westPanel.add(btn_2);

        btn_3=new JButton("薯片");
        btn_3.addActionListener(this);
        westPanel.add(btn_3);

        btn_4=new JButton("汉堡");
        btn_4.addActionListener(this);
        westPanel.add(btn_4);

        btn_5=new JButton("雨伞");
        btn_5.addActionListener(this);
        westPanel.add(btn_5);

        btn_6=new JButton("抱枕");
        btn_6.addActionListener(this);
        westPanel.add(btn_6);

        btn_7=new JButton("屏幕");
        btn_7.addActionListener(this);
        westPanel.add(btn_7);

        btn_8=new JButton("增高垫");
        btn_8.addActionListener(this);
        westPanel.add(btn_8);

        btn_9=new JButton("口罩");
        btn_9.addActionListener(this);
        westPanel.add(btn_9);

        btn_10=new JButton("RPG");
        btn_10.addActionListener(this);
        westPanel.add(btn_10);

        btn_11=new JButton("提交");                                      //提交按钮
        btn_11.addActionListener(this);
        southPanel.add(btn_11);

        this.add(westPanel,"West");
        this.add(southPanel,"South");
        this.add(centerPanel,"Center");
        this.add(eastPanel,"East");


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_1) {
            System.out.println("可乐");
        }
        if(e.getSource()==btn_2) {
            System.out.println("红牛");
        }
        if(e.getSource()==btn_3) {
            System.out.println("薯片");
        }
        if(e.getSource()==btn_4) {
            System.out.println("汉堡");
        }
        if(e.getSource()==btn_5) {
            System.out.println("雨伞");
        }
        if(e.getSource()==btn_6) {
            System.out.println("抱枕");
        }
        if(e.getSource()==btn_7) {
            System.out.println("屏幕");
        }
        if(e.getSource()==btn_8) {
            System.out.println("增高垫");
        }
        if(e.getSource()==btn_9) {
            System.out.println("口罩");
        }
        if(e.getSource()==btn_10) {
            System.out.println("RPG");
        }
        if(e.getSource()==btn_11) {


        }
    }
}
