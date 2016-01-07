package edu.team8;

import javafx.scene.layout.Border;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 帅 on 2016/1/6.
 */
public class BarcodeScanner extends JFrame implements ActionListener {
    private String barcodeText;
    private String logText;

    private JPanel westPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel eastPanel;

    private JTextArea jta;
    private JTextArea jta2;
    private JTextArea jta3;

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
        logText = new String();

        init();//窗口初始化

    }

    private void init() {
        this.setLayout(new BorderLayout());                           //布局
        this.setSize(1280,720);                                       //窗体大小
        this.setLocationRelativeTo(null);                             //让窗体居中显示
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //默认关闭模式

        westPanel=new JPanel(new GridLayout(10,1));
        southPanel=new JPanel(new GridLayout(1,1));
        centerPanel=new JPanel(new GridLayout(2,1));
        eastPanel=new JPanel(new GridLayout(1,1));

        //titleBorder=new TitledBorder(null,"")

        jta=new JTextArea();
        jta.setEditable(false);
        TitledBorder tb_1 = BorderFactory.createTitledBorder ("已扫描商品");
        tb_1.setTitleFont(new Font("黑体",Font.PLAIN,20));
        tb_1.setTitleJustification(TitledBorder.LEFT);
        tb_1.setTitlePosition(TitledBorder.TOP);
        jta.setBorder(tb_1);
        jta.add (new JLabel ("标题边框"));
        centerPanel.add(jta);

        jta3=new JTextArea();
        jta3.setEditable(false);
        TitledBorder tb_3 = BorderFactory.createTitledBorder ("日志信息");
        tb_3.setTitleFont(new Font("黑体",Font.PLAIN,20));
        tb_3.setTitleJustification(TitledBorder.LEFT);
        tb_3.setTitlePosition(TitledBorder.TOP);
        jta3.setBorder(tb_3);
        jta3.add (new JLabel ("标题边框"));
        centerPanel.add(jta3);

        jta2=new JTextArea();
        jta2.setEditable(false);
        TitledBorder tb_2 = BorderFactory.createTitledBorder ("小票打印");
        tb_2.setTitleFont(new Font("黑体",Font.PLAIN,20));
        tb_2.setTitleJustification(TitledBorder.LEFT);
        tb_2.setTitlePosition(TitledBorder.TOP);
        jta2.setBorder(tb_2);
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
        btn_7.setForeground(Color.GRAY);
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
        jta.setFont(new Font("宋体",Font.BOLD,20));
        if(e.getSource()==btn_1) {
            jta.append("ITEM0000\b可乐,\n");
        }
        if(e.getSource()==btn_2) {
            jta.append("ITEM0001\b红牛,\n");
        }
        if(e.getSource()==btn_3) {
            jta.append("ITEM0002\b薯片,\n");
        }
        if(e.getSource()==btn_4) {
            jta.append("ITEM0003\b汉堡,\n");
        }
        if(e.getSource()==btn_5) {
            jta.append("ITEM0004\b雨伞,\n");
        }
        if(e.getSource()==btn_6) {
            jta.append("ITEM0005\b抱枕,\n");
        }
        if(e.getSource()==btn_7) {
            jta.append("ITEM0006\b屏幕,\n");
        }
        if(e.getSource()==btn_8) {
            jta.append("ITEM0007\b增高垫,\n");
        }
        if(e.getSource()==btn_9) {
            jta.append("ITEM0008\b口罩,\n");
        }
        if(e.getSource()==btn_10) {
            jta.append("ITEM0009\bRPG,\n");
        }
        if(e.getSource()==btn_11) {
            barcodeText=jta3.getText();
            logText = GetGoodByBarcode.makeGoodList(barcodeText).toString();
            jta3.setText(logText);
        }
    }

    public void printLog(String log)
    {
        jta3.append(log);
    }
}
