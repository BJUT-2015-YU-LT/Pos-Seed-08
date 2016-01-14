package edu.team8;

import edu.team8.classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 帅 on 2016/1/6.
 */
public class PosGUI extends JFrame implements ActionListener
{
    private static final String[] vipList = {"","VIP001","VIP002","VIP003","VIP004","KONAN"};

    private JPanel westPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel centerWestPanel;
    private JPanel centerEastPanel;

    private GoodsTable goodsTable;
    private JScrollPane ticketScroll;
    private JScrollPane logScroll;

    private JPanel vipcodeBorderPanel;
    private JPanel tableBorderPanel;
    private JPanel ticketBorderPanel;
    private JPanel logBorderPanel;
    private JPanel accountPanel;

    private JLabel accountLabel;

    private JComboBox vipcode;
    private JTextArea ticketField;
    private JTextArea logField;

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
    private JButton paperButton;

    private Vip vipInfo;
    private TicketInfo ticket;
    private GoodList goodList;
    private GetInfoInSQL sqlVisitor;

    public PosGUI(String title) {
        super(title);
        //修改显示样式
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}

        this.setLayout(new BorderLayout());                           //布局
        this.setSize(1280,720);                                       //窗体大小
        this.setLocationRelativeTo(null);                             //让窗体居中显示
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //默认关闭模式

        init();//窗口初始化

        goodList = new GoodList();
        GetInfoInSQL.setWindow(this);
        sqlVisitor= new GetInfoInSQL();
        goodsTable.setGoodList(goodList);
        PrintTicket.setBs(this);
    }

    private void init()
    {
        westPanel=new JPanel(new GridLayout(10,2));
        westPanel.setPreferredSize(new Dimension(200,0));
        southPanel=new JPanel(new GridLayout(1,3));
        centerPanel=new JPanel(new GridLayout(1,2));
        centerWestPanel=new JPanel(new BorderLayout());
        centerEastPanel=new JPanel(new BorderLayout());

        goodsTable = new GoodsTable();
        tableBorderPanel = new JPanel(new GridLayout());
        tableBorderPanel.setBorder(BorderFactory.createTitledBorder ("已扫描商品"));
        tableBorderPanel.add(goodsTable);
        centerEastPanel.add(tableBorderPanel,"Center");

        vipcode = new JComboBox(vipList);
        vipcode.addActionListener(this);
        vipcodeBorderPanel = new JPanel(new GridLayout());
        vipcodeBorderPanel.setBorder(BorderFactory.createTitledBorder ("会员编号"));
        vipcodeBorderPanel.add(vipcode);
        centerEastPanel.add(vipcodeBorderPanel,"North");

        accountLabel = new JLabel("待结算");
        accountLabel.setFont(new Font("黑体",Font.BOLD,30));
        accountPanel = new JPanel(new FlowLayout());
        accountPanel.setBorder(BorderFactory.createTitledBorder ("结算信息"));
        accountPanel.add(accountLabel);
        centerEastPanel.add(accountPanel,"South");

        ticketField = new JTextArea();
        ticketField.setEditable(false);
        ticketScroll =new JScrollPane(ticketField);
        ticketBorderPanel = new JPanel(new GridLayout());
        ticketBorderPanel.setBorder(BorderFactory.createTitledBorder ("小票打印"));
        ticketBorderPanel.add(ticketScroll);
        centerWestPanel.add(ticketBorderPanel,"Center");

        logField = new JTextArea();
        logField.setEditable(false);
        logScroll =new JScrollPane(logField);
        logBorderPanel = new JPanel(new GridLayout());
        logBorderPanel.setPreferredSize(new Dimension(0,160));
        logBorderPanel.setBorder(BorderFactory.createTitledBorder ("日志信息"));
        logBorderPanel.add(logScroll);
        centerWestPanel.add(logBorderPanel,"South");

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
        printButton.setEnabled(false);
        southPanel.add(printButton);

        //补纸按钮
        paperButton=new JButton("补纸");
        paperButton.setFont(new Font("幼圆", Font.BOLD,20));
        paperButton.addActionListener(this);
        southPanel.add(paperButton);

        this.add(westPanel,"West");
        this.add(southPanel,"South");
        centerPanel.add(centerWestPanel);
        centerPanel.add(centerEastPanel);
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
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0000"));
        }
        if(e.getSource()==btn_2) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0001"));
        }
        if(e.getSource()==btn_3) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0002"));
        }
        if(e.getSource()==btn_4) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0003"));
        }
        if(e.getSource()==btn_5) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0004"));
        }
        if(e.getSource()==btn_6) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0005"));
        }
        if(e.getSource()==btn_7) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0006"));
        }
        if(e.getSource()==btn_8) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0007"));
        }
        if(e.getSource()==btn_9) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0008"));
        }
        if(e.getSource()==btn_10) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0009"));
        }
        if(e.getSource()==btn_11) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0010"));
        }
        if(e.getSource()==btn_12) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0011"));
        }
        if(e.getSource()==btn_13) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0012"));
        }
        if(e.getSource()==btn_14) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0013"));
        }
        if(e.getSource()==btn_15) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0014"));
        }
        if(e.getSource()==btn_16) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0015"));
        }
        if(e.getSource()==btn_17) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0016"));
        }
        if(e.getSource()==btn_18) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0017"));
        }
        if(e.getSource()==btn_19) {
            goodList.addGood(sqlVisitor.findByBarcode("ITEM0018"));
        }
        if(e.getSource()==btn_20) {
            Good good = null;
            good = sqlVisitor.findByBarcode("APTX4869");
            if(good!=null)
                goodList.addGood(good);
        }
        if(e.getSource()==countButton) {
            ticket = ChangeList.account(goodList.getGoods(),vipInfo,sqlVisitor);
            if(ticket!=null) {
                accountLabel.setText("需要收款: " + ticket.getPaidPrice() + "元");
                countButton.setEnabled(false);
                printButton.setEnabled(true);
            }
        }
        if(e.getSource()==printButton)
        {
            if(ticket!=null) {
                if(PrintTicket.PrintTicket(ticket)==-1){
                    printLog("缺纸");
                }else{
                    countButton.setEnabled(true);
                    printButton.setEnabled(false);
                    goodList.clear();
                    goodsTable.clear();
                }
            }
            else
                printLog("还未进行结算");
        }
        if(e.getSource()==paperButton)
        {
            PrintTicket.fullPaper();
            ticketField.setText("");
            printLog("已补充纸");
        }
        if(e.getSource()==vipcode)
        {
            String vipStr = vipcode.getSelectedItem().toString();
            if(!vipStr.equals("")) {
                vipInfo = sqlVisitor.findVipByCode(vipStr);
            }else{
                vipInfo = null;
            }
        }
        goodsTable.showGoodList();
    }

    //日志信息接口
    public void printLog(String log)
    {
        logField.append(
                new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]", Locale.CHINA).format(new Date())
                +log+ "\n" );
        logField.setCaretPosition(logField.getText().length());
    }

    //小票打印接口
    public void printReceipt(String receipt)
    {
        ticketField.append(receipt+ "\n" );
        ticketField.setCaretPosition(ticketField.getText().length());
    }
}
