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
    private String barcodeText;

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
        barcodeText = new String();

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
        jta.setEditable(false);
        jta.setBorder (BorderFactory.createTitledBorder ("已扫描商品"));
        jta.add (new JLabel ("标题边框"));
        centerPanel.add(jta);

        jta2=new JTextArea();
        jta2.setEditable(false);
        jta2.setBorder (BorderFactory.createTitledBorder ("输出界面"));
        jta2.add (new JLabel ("标题边框"));
        eastPanel.add(jta2);
        eastPanel.setPreferredSize(new Dimension(400,0));

        //将按钮添加到窗体中
        btn_1=new JButton("可乐");                               //各种商品按钮
        btn_1.setFont(new Font("黑体", Font.BOLD,20));
        btn_1.setForeground(Color.RED);
        btn_1.addActionListener(this);
        westPanel.add(btn_1);

        btn_2=new JButton("红牛");
        btn_2.setFont(new Font("黑体", Font.BOLD,20));
        btn_2.setForeground(Color.YELLOW);
        btn_2.addActionListener(this);
        westPanel.add(btn_2);

        btn_3=new JButton("薯片");
        btn_3.setFont(new Font("黑体", Font.BOLD,20));
        btn_3.setForeground(new Color(234,199,135));
        btn_3.addActionListener(this);
        westPanel.add(btn_3);

        btn_4=new JButton("汉堡");
        btn_4.setFont(new Font("黑体", Font.BOLD,20));
        btn_4.setForeground(Color.ORANGE);
        btn_4.addActionListener(this);
        westPanel.add(btn_4);

        btn_5=new JButton("雨伞");
        btn_5.setFont(new Font("黑体", Font.BOLD,20));
        btn_5.setForeground(Color.CYAN);
        btn_5.addActionListener(this);
        westPanel.add(btn_5);

        btn_6=new JButton("抱枕");
        btn_6.setFont(new Font("黑体", Font.BOLD,20));
        btn_6.setForeground(Color.MAGENTA);
        btn_6.addActionListener(this);
        westPanel.add(btn_6);

        btn_7=new JButton("屏幕");
        btn_7.setFont(new Font("黑体", Font.BOLD,20));
        btn_7.setForeground(Color.DARK_GRAY);
        btn_7.addActionListener(this);
        westPanel.add(btn_7);

        btn_8=new JButton("增高垫");
        btn_8.setFont(new Font("黑体", Font.BOLD,20));
        btn_8.setForeground(Color.PINK);
        btn_8.addActionListener(this);
        westPanel.add(btn_8);

        btn_9=new JButton("口罩");
        btn_9.setFont(new Font("黑体", Font.BOLD,20));
        btn_9.setForeground(Color.GREEN);
        btn_9.addActionListener(this);
        westPanel.add(btn_9);

        btn_10=new JButton("RPG");
        btn_10.setFont(new Font("黑体", Font.BOLD,20));
        btn_10.addActionListener(this);
        westPanel.add(btn_10);

        btn_11=new JButton("提交");                                           //提交按钮
        btn_11.setFont(new Font("黑体", Font.BOLD,20));
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
            jta.append("可乐,\n");
        }
        if(e.getSource()==btn_2) {
            jta.append("红牛,\n");
        }
        if(e.getSource()==btn_3) {
            jta.append("薯片,\n");
        }
        if(e.getSource()==btn_4) {
            jta.append("汉堡,\n");
        }
        if(e.getSource()==btn_5) {
            jta.append("雨伞,\n");
        }
        if(e.getSource()==btn_6) {
            jta.append("抱枕,\n");
        }
        if(e.getSource()==btn_7) {
            jta.append("屏幕,\n");
        }
        if(e.getSource()==btn_8) {
            jta.append("增高垫,\n");
        }
        if(e.getSource()==btn_9) {
            jta.append("口罩,\n");
        }
        if(e.getSource()==btn_10) {
            jta.append("RPG,\n");
        }
        if(e.getSource()==btn_11) {


        }
    }
}
