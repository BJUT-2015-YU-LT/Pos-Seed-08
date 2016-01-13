package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    private JScrollPane jsp;
    private JScrollPane jsp2;
    private JScrollPane jsp3;

    private JPanel jcp;
    private JPanel jcp2;
    private JPanel jcp3;

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
    private JButton btn_12;
    private JButton btn_13;
    private JButton btn_14;
    private JButton btn_15;
    private JButton btn_16;
    private JButton btn_17;
    private JButton btn_18;
    private JButton btn_19;
    private JButton btn_20;
    private JButton btn_21;

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

        westPanel=new JPanel(new GridLayout(10,2));
        southPanel=new JPanel(new GridLayout(1,1));
        centerPanel=new JPanel(new GridLayout(1,1));
        eastPanel=new JPanel(new GridLayout(2,1));
        westPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        southPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //titleBorder=new TitledBorder(null,"")

        jta=new JTextArea();
        jta.setEditable(false);
        TitledBorder tb_1 = BorderFactory.createTitledBorder ("已扫描商品");
        tb_1.setTitleFont(new Font("黑体",Font.PLAIN,20));
        tb_1.setTitleJustification(TitledBorder.LEFT);
        tb_1.setTitlePosition(TitledBorder.TOP);
        jta.add (new JLabel ("标题边框"));
        jsp=new JScrollPane(jta);
        jcp = new JPanel(new GridLayout());
        jcp.setBorder(tb_1);
        jcp.add(jsp);
        eastPanel.add(jcp);


        jta2=new JTextArea();
        jta2.setEditable(false);
        TitledBorder tb_2 = BorderFactory.createTitledBorder ("小票打印");
        tb_2.setTitleFont(new Font("黑体",Font.PLAIN,20));
        tb_2.setTitleJustification(TitledBorder.LEFT);
        tb_2.setTitlePosition(TitledBorder.TOP);
        jta2.add (new JLabel ("标题边框"));
        jsp2=new JScrollPane(jta2);
        jcp2 = new JPanel(new GridLayout());
        jcp2.setBorder(tb_2);
        jcp2.add(jsp2);
        centerPanel.add(jcp2);


        jta3=new JTextArea();
        jta3.setEditable(false);
        TitledBorder tb_3 = BorderFactory.createTitledBorder ("日志信息");
        tb_3.setTitleFont(new Font("黑体",Font.PLAIN,20));
        tb_3.setTitleJustification(TitledBorder.LEFT);
        tb_3.setTitlePosition(TitledBorder.TOP);
        jsp3=new JScrollPane(jta3);
        jcp3 = new JPanel(new GridLayout());
        jcp3.setBorder(tb_3);
        jcp3.add(jsp3);
        eastPanel.add(jcp3);
        eastPanel.setPreferredSize(new Dimension(400,0));

        //将按钮添加到窗体中
        btn_1=new JButton();                                              //各种商品按钮
        btn_1.setToolTipText("可乐");
        btn_1.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_1.setForeground(Color.RED);
        btn_1.setIcon(new ImageIcon("image/ITEM0000.png"));
        btn_1.addActionListener(this);
        westPanel.add(btn_1);

        btn_2=new JButton();
        btn_2.setToolTipText("红牛");
        //btn_2.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_2.setForeground(Color.RED);
        btn_2.setIcon(new ImageIcon("image/ITEM0001.png"));
        btn_2.addActionListener(this);
        westPanel.add(btn_2);

        btn_3=new JButton();
        btn_3.setToolTipText("薯片");
        //btn_3.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_3.setForeground(Color.ORANGE);
        btn_3.setIcon(new ImageIcon("image/ITEM0002.png"));
        btn_3.addActionListener(this);
        westPanel.add(btn_3);

        btn_4=new JButton();
        btn_4.setToolTipText("汉堡");
        //btn_4.setFont(new Font("幼圆", Font.BOLD,15));
        //btn_4.setForeground(Color.ORANGE);
        btn_4.setIcon(new ImageIcon("image/ITEM0003.png"));
        btn_4.addActionListener(this);
        westPanel.add(btn_4);

        btn_5=new JButton();
        btn_5.setToolTipText("雨伞");
        //btn_5.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_5.setForeground(Color.orange);
        btn_5.setIcon(new ImageIcon("image/ITEM0004.png"));
        btn_5.addActionListener(this);
        westPanel.add(btn_5);

        btn_6=new JButton();
        btn_6.setToolTipText("抱枕");
        //btn_6.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_6.setForeground(Color.orange);
        btn_6.setIcon(new ImageIcon("image/ITEM0005.png"));
        btn_6.addActionListener(this);
        westPanel.add(btn_6);

        btn_7=new JButton();
        btn_7.setToolTipText("显示屏");
        //btn_7.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_7.setForeground(Color.YELLOW);
        btn_7.setIcon(new ImageIcon("image/ITEM0006.png"));
        btn_7.addActionListener(this);
        westPanel.add(btn_7);

        btn_8=new JButton();
        btn_8.setToolTipText("增高垫");
        //btn_8.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_8.setForeground(Color.YELLOW);
        btn_8.setIcon(new ImageIcon("image/ITEM0007.png"));
        btn_8.addActionListener(this);
        westPanel.add(btn_8);

        btn_9=new JButton();
        btn_9.setToolTipText("口罩");
        //btn_9.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_9.setForeground(Color.GREEN);
        btn_9.setIcon(new ImageIcon("image/ITEM0008.png"));
        btn_9.addActionListener(this);
        westPanel.add(btn_9);

        btn_10=new JButton();
        btn_10.setToolTipText("RPG");
        //btn_10.setFont(new Font("Gulim", Font.BOLD,20));
        //btn_10.setForeground(Color.GREEN);
        btn_10.setIcon(new ImageIcon("image/ITEM0009.png"));
        btn_10.addActionListener(this);
        westPanel.add(btn_10);

        btn_12=new JButton();
        btn_12.setToolTipText("咖啡");
        //btn_12.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_12.setForeground(Color.CYAN);
        btn_12.setIcon(new ImageIcon("image/ITEM0010.png"));
        btn_12.addActionListener(this);
        westPanel.add(btn_12);

        btn_13=new JButton();
        btn_13.setToolTipText("二锅头");
        //btn_13.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_13.setForeground(Color.CYAN);
        btn_13.setIcon(new ImageIcon("image/ITEM0011.png"));
        btn_13.addActionListener(this);
        westPanel.add(btn_13);

        btn_14=new JButton();
        btn_14.setToolTipText("方便面");
        //btn_14.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_14.setForeground(Color.BLUE);
        btn_14.setIcon(new ImageIcon("image/ITEM0012.png"));
        btn_14.addActionListener(this);
        westPanel.add(btn_14);

        btn_15=new JButton();
        btn_15.setToolTipText("肉松饼");
        //btn_15.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_15.setForeground(Color.BLUE);
        btn_15.setIcon(new ImageIcon("image/ITEM0013.png"));
        btn_15.addActionListener(this);
        westPanel.add(btn_15);

        btn_16=new JButton();
        btn_16.setToolTipText("拖鞋");
        //btn_16.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_16.setForeground(Color.MAGENTA);
        btn_16.setIcon(new ImageIcon("image/ITEM0014.png"));
        btn_16.addActionListener(this);
        westPanel.add(btn_16);

        btn_17=new JButton();
        btn_17.setToolTipText("鼠标");
        //btn_17.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_17.setForeground(Color.MAGENTA);
        btn_17.setIcon(new ImageIcon("image/ITEM0015.png"));
        btn_17.addActionListener(this);
        westPanel.add(btn_17);

        btn_18=new JButton();
        btn_18.setToolTipText("电池");
        //btn_18.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_18.setForeground(Color.GRAY);
        btn_18.setIcon(new ImageIcon("image/ITEM0016.png"));
        btn_18.addActionListener(this);
        westPanel.add(btn_18);

        btn_19=new JButton();
        btn_19.setToolTipText("卫生纸");
        //btn_19.setFont(new Font("幼圆", Font.BOLD,20));
        //btn_19.setForeground(Color.GRAY);
        btn_19.setIcon(new ImageIcon("image/ITEM0017.png"));
        btn_19.addActionListener(this);
        westPanel.add(btn_19);

        btn_20=new JButton();
        btn_20.setToolTipText("C4");
        //btn_20.setFont(new Font("Gulim", Font.BOLD,20));
        btn_20.setIcon(new ImageIcon("image/ITEM0018.png"));
        btn_20.addActionListener(this);
        westPanel.add(btn_20);

        btn_21=new JButton();
        btn_21.setToolTipText("随机出错");
        //btn_21.setFont(new Font("幼圆", Font.BOLD,20));
        btn_21.setIcon(new ImageIcon("image/APTX4869.png"));
        btn_21.addActionListener(this);
        westPanel.add(btn_21);

        btn_11=new JButton("<<提交>>");                                           //提交按钮
        btn_11.setFont(new Font("幼圆", Font.BOLD,20));
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
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0000");
        }
        if(e.getSource()==btn_2) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0001");
        }
        if(e.getSource()==btn_3) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0002");
        }
        if(e.getSource()==btn_4) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0003");
        }
        if(e.getSource()==btn_5) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0004");
        }
        if(e.getSource()==btn_6) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0005");
        }
        if(e.getSource()==btn_7) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0006");
        }
        if(e.getSource()==btn_8) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0007");
        }
        if(e.getSource()==btn_9) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0008");
        }
        if(e.getSource()==btn_10) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0009");
        }
        if(e.getSource()==btn_12) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0010");
        }
        if(e.getSource()==btn_13) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0011");
        }
        if(e.getSource()==btn_14) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0012");
        }
        if(e.getSource()==btn_15) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0013");
        }
        if(e.getSource()==btn_16) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0014");
        }
        if(e.getSource()==btn_17) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0015");
        }
        if(e.getSource()==btn_18) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0016");
        }
        if(e.getSource()==btn_19) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0017");
        }
        if(e.getSource()==btn_20) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0018");
        }
        if(e.getSource()==btn_21) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("APTX4869");
        }
        if(e.getSource()==btn_11) {
            barcodeText=jta.getText();
            GetInfoInSQL.setWindow(this);
            ArrayList<Good> goods = GetInfoInSQL.makeGoodList(barcodeText);
            ArrayList<GoodExtends> ge= ChangeList.processChangeList(goods);
            PrintList.PrintGoodList(ge,this);
        }
    }

    public void printLog(String log)
    {
        jta3.append(log+"\n");
    }                                                                      //日志信息接口

    public void printReceipt(String receipt)
    {
        jta2.append(receipt+ "\n" );
    }                                                                      //小票打印接口
}
