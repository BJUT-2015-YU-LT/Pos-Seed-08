package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;
import edu.team8.classes.TicketInfo;
import edu.team8.classes.Vip;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by 帅 on 2016/1/6.
 */
public class PosGUI extends JFrame implements ActionListener
{
    private static final String[] vipList = {"","VIP001","VIP002","VIP003","VIP004","KONAN"};

    private String barcodeText;
    private String logText;

    private JPanel westPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel centerEastPanel;

    private JScrollPane tableScroll;
    private JScrollPane ticketScroll;

    private JPanel vipcodeBorderPanel;
    private JPanel tableBorderPanel;
    private JPanel ticketBorderPanel;

    private JTable itemTable;

    private JComboBox vipcode;
    private JTextArea jta;
    private JTextArea ticketField;

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

    private JButton countButton;
    private JButton printButton;

    public PosGUI(String title) {
        super(title);
        //修改显示样式
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}

        barcodeText = new String();
        logText = new String();

        this.setLayout(new BorderLayout());                           //布局
        this.setSize(1280,720);                                       //窗体大小
        this.setLocationRelativeTo(null);                             //让窗体居中显示
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //默认关闭模式

        init();//窗口初始化

    }

    private void init()
    {
        westPanel=new JPanel(new GridLayout(10,2));
        westPanel.setPreferredSize(new Dimension(200,0));
        southPanel=new JPanel(new GridLayout(1,3));
        centerPanel=new JPanel(new GridLayout(1,2));
        centerEastPanel=new JPanel(new BorderLayout());

        jta=new JTextArea();

        tableScroll = new JScrollPane(itemTable);
        tableBorderPanel = new JPanel(new GridLayout());
        tableBorderPanel.setBorder(BorderFactory.createTitledBorder ("已扫描商品"));
        tableBorderPanel.add(tableScroll);
        centerEastPanel.add(tableBorderPanel,"Center");

        vipcode = new JComboBox(vipList);
        vipcodeBorderPanel = new JPanel(new GridLayout());
        vipcodeBorderPanel.setBorder(BorderFactory.createTitledBorder ("会员编号"));
        vipcodeBorderPanel.add(vipcode);
        centerEastPanel.add(vipcodeBorderPanel,"North");

        ticketField = new JTextArea();
        ticketField.setEditable(false);
        ticketScroll =new JScrollPane(ticketField);
        ticketBorderPanel = new JPanel(new GridLayout());
        ticketBorderPanel.setBorder(BorderFactory.createTitledBorder ("小票打印"));
        ticketBorderPanel.add(ticketScroll);
        centerPanel.add(ticketBorderPanel);

        //将商品按钮添加到窗体中
        this.addItemButton();


        //结算按钮
        countButton=new JButton("结算");
        countButton.setFont(new Font("幼圆", Font.BOLD,20));
        countButton.addActionListener(this);
        southPanel.add(countButton);

        //打印按钮
        printButton=new JButton("打印");
        printButton.setFont(new Font("幼圆", Font.BOLD,20));
        printButton.addActionListener(this);
        southPanel.add(printButton);

        this.add(westPanel,"West");
        this.add(southPanel,"South");
        centerPanel.add(centerEastPanel,"East");
        this.add(centerPanel,"Center");

        this.setVisible(true);
    }

    private void addItemButton() {
        //各种商品按钮
        btn_1=new JButton();
        btn_1.setToolTipText("可乐");
        btn_1.setIcon(new ImageIcon("image/ITEM0000.png"));
        btn_1.addActionListener(this);
        westPanel.add(btn_1);

        btn_2=new JButton();
        btn_2.setToolTipText("红牛");
        btn_2.setIcon(new ImageIcon("image/ITEM0001.png"));
        btn_2.addActionListener(this);
        westPanel.add(btn_2);

        btn_3=new JButton();
        btn_3.setToolTipText("薯片");
        btn_3.setIcon(new ImageIcon("image/ITEM0002.png"));
        btn_3.addActionListener(this);
        westPanel.add(btn_3);

        btn_4=new JButton();
        btn_4.setToolTipText("汉堡");
        btn_4.setIcon(new ImageIcon("image/ITEM0003.png"));
        btn_4.addActionListener(this);
        westPanel.add(btn_4);

        btn_5=new JButton();
        btn_5.setToolTipText("雨伞");
        btn_5.setIcon(new ImageIcon("image/ITEM0004.png"));
        btn_5.addActionListener(this);
        westPanel.add(btn_5);

        btn_6=new JButton();
        btn_6.setToolTipText("抱枕");
        btn_6.setIcon(new ImageIcon("image/ITEM0005.png"));
        btn_6.addActionListener(this);
        westPanel.add(btn_6);

        btn_7=new JButton();
        btn_7.setToolTipText("显示屏");
        btn_7.setIcon(new ImageIcon("image/ITEM0006.png"));
        btn_7.addActionListener(this);
        westPanel.add(btn_7);

        btn_8=new JButton();
        btn_8.setToolTipText("增高垫");
        btn_8.setIcon(new ImageIcon("image/ITEM0007.png"));
        btn_8.addActionListener(this);
        westPanel.add(btn_8);

        btn_9=new JButton();
        btn_9.setToolTipText("口罩");
        btn_9.setIcon(new ImageIcon("image/ITEM0008.png"));
        btn_9.addActionListener(this);
        westPanel.add(btn_9);

        btn_10=new JButton();
        btn_10.setToolTipText("RPG");
        btn_10.setIcon(new ImageIcon("image/ITEM0009.png"));
        btn_10.addActionListener(this);
        westPanel.add(btn_10);

        btn_11=new JButton();
        btn_11.setToolTipText("咖啡");
        btn_11.setIcon(new ImageIcon("image/ITEM0010.png"));
        btn_11.addActionListener(this);
        westPanel.add(btn_11);

        btn_12=new JButton();
        btn_12.setToolTipText("二锅头");
        btn_12.setIcon(new ImageIcon("image/ITEM0011.png"));
        btn_12.addActionListener(this);
        westPanel.add(btn_12);

        btn_13=new JButton();
        btn_13.setToolTipText("方便面");
        btn_13.setIcon(new ImageIcon("image/ITEM0012.png"));
        btn_13.addActionListener(this);
        westPanel.add(btn_13);

        btn_14=new JButton();
        btn_14.setToolTipText("肉松饼");
        btn_14.setIcon(new ImageIcon("image/ITEM0013.png"));
        btn_14.addActionListener(this);
        westPanel.add(btn_14);

        btn_15=new JButton();
        btn_15.setToolTipText("拖鞋");
        btn_15.setIcon(new ImageIcon("image/ITEM0014.png"));
        btn_15.addActionListener(this);
        westPanel.add(btn_15);

        btn_16=new JButton();
        btn_16.setToolTipText("鼠标");
        btn_16.setIcon(new ImageIcon("image/ITEM0015.png"));
        btn_16.addActionListener(this);
        westPanel.add(btn_16);

        btn_17=new JButton();
        btn_17.setToolTipText("电池");
        btn_17.setIcon(new ImageIcon("image/ITEM0016.png"));
        btn_17.addActionListener(this);
        westPanel.add(btn_17);

        btn_18=new JButton();
        btn_18.setToolTipText("卫生纸");
        btn_18.setIcon(new ImageIcon("image/ITEM0017.png"));
        btn_18.addActionListener(this);
        westPanel.add(btn_18);

        btn_19=new JButton();
        btn_19.setToolTipText("C4");
        btn_19.setIcon(new ImageIcon("image/ITEM0018.png"));
        btn_19.addActionListener(this);
        westPanel.add(btn_19);

        btn_20=new JButton();
        btn_20.setToolTipText("随机出错");
        btn_20.setIcon(new ImageIcon("image/APTX4869.png"));
        btn_20.addActionListener(this);
        westPanel.add(btn_20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        if(e.getSource()==btn_11) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0010");
        }
        if(e.getSource()==btn_12) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0011");
        }
        if(e.getSource()==btn_13) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0012");
        }
        if(e.getSource()==btn_14) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0013");
        }
        if(e.getSource()==btn_15) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0014");
        }
        if(e.getSource()==btn_16) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0015");
        }
        if(e.getSource()==btn_17) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0016");
        }
        if(e.getSource()==btn_18) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0017");
        }
        if(e.getSource()==btn_19) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("ITEM0018");
        }
        if(e.getSource()==btn_20) {
            if(jta.getText().length()!=0)
                jta.append(",\n");
            jta.append("APTX4869");
        }
        if(e.getSource()==countButton) {
            barcodeText=jta.getText();
            GetInfoInSQL.setWindow(this);
            ArrayList<Good> goods = GetInfoInSQL.makeGoodList(barcodeText);
            ArrayList<GoodExtends> ge= ChangeList.processChangeList(goods);
            TicketInfo ticket = ChangeList.account(ge,new Vip("wewewe",200));
            PrintTicket.PrintTicketList(ticket,this);
         }
    }

    //日志信息接口
    public void printLog(String log)
    {
        System.out.println(log);
    }

    //小票打印接口
    public void printReceipt(String receipt)
    {
        ticketField.append(receipt+ "\n" );
    }
}
