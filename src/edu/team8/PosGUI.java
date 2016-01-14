package edu.team8;

import edu.team8.classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 帅 on 2016/1/6.
 */
public class PosGUI extends JFrame implements MouseListener,ActionListener
{
    private static final String[] vipList = {"","VIP001","VIP002","VIP003","VIP004","KONAN"};

    private JPanel westPanel;
    private GoodsTable goodsTable;

    private JLabel accountLabel;

    private JComboBox vipcode;
    private JTextArea ticketField;
    private JTextArea logField;

    private ArrayList<JButton> itemBtnList;
    private static final String[] itemBarcodeList = {
            "ITEM0000","ITEM0001","ITEM0002","ITEM0003","ITEM0004",
            "ITEM0005","ITEM0006","ITEM0007","ITEM0008","ITEM0009",
            "ITEM0010","ITEM0011","ITEM0012","ITEM0013","ITEM0014",
            "ITEM0015","ITEM0016","ITEM0017","ITEM0018","APTX4869"};

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
        }catch(Exception e){
            System.out.println("界面风格初始化失败");
        }

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
        JPanel southPanel=new JPanel(new GridLayout(1,3));
        JPanel centerPanel=new JPanel(new GridLayout(1,2));
        JPanel centerWestPanel=new JPanel(new BorderLayout());
        JPanel centerEastPanel=new JPanel(new BorderLayout());

        goodsTable = new GoodsTable();
        JPanel tableBorderPanel = new JPanel(new GridLayout());
        tableBorderPanel.setBorder(BorderFactory.createTitledBorder ("已扫描商品"));
        tableBorderPanel.add(goodsTable);
        centerEastPanel.add(tableBorderPanel,"Center");

        vipcode = new JComboBox(vipList);
        vipcode.addActionListener(this);
        JPanel vipcodeBorderPanel = new JPanel(new GridLayout());
        vipcodeBorderPanel.setBorder(BorderFactory.createTitledBorder ("会员编号"));
        vipcodeBorderPanel.add(vipcode);
        centerEastPanel.add(vipcodeBorderPanel,"North");

        accountLabel = new JLabel("等待结算");
        accountLabel.setFont(new Font("黑体",Font.BOLD,30));
        JPanel accountPanel = new JPanel(new FlowLayout());
        accountPanel.setBorder(BorderFactory.createTitledBorder ("结算信息"));
        accountPanel.add(accountLabel);
        centerEastPanel.add(accountPanel,"South");

        ticketField = new JTextArea();
        ticketField.setEditable(false);
        JScrollPane ticketScroll =new JScrollPane(ticketField);
        JPanel ticketBorderPanel = new JPanel(new GridLayout());
        ticketBorderPanel.setBorder(BorderFactory.createTitledBorder ("小票打印"));
        ticketBorderPanel.add(ticketScroll);
        centerWestPanel.add(ticketBorderPanel,"Center");

        logField = new JTextArea();
        logField.setEditable(false);
        JScrollPane logScroll =new JScrollPane(logField);
        JPanel logBorderPanel = new JPanel(new GridLayout());
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
        itemBtnList = new ArrayList<>();

        for(int i=0;i<19;i++)
        {
            JButton btn = new JButton();
            btn.setToolTipText(itemBarcodeList[i]);
            btn.setIcon(new ImageIcon("image/"+itemBarcodeList[i]+".png"));
            btn.addMouseListener(this);
            itemBtnList.add(btn);
        }

        JButton btn_w=new JButton();
        btn_w.setToolTipText("随机出错");
        btn_w.setIcon(new ImageIcon("image/APTX4869.png"));
        btn_w.addMouseListener(this);
        itemBtnList.add(btn_w);

        for(JButton btn:itemBtnList)
        {
            westPanel.add(btn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==countButton) {
            if(goodList.isEmpty())return;
            ticket = ChangeList.account(goodList.getGoods(),vipInfo,sqlVisitor);
            if(ticket!=null) {
                setScannable(false);
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
                    accountLabel.setText("等待结算");
                    setScannable(true);
                }
            }
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

    //商品按钮控制
    public void setScannable(boolean b)
    {
        for(JButton btn:itemBtnList)
        {
            btn.setEnabled(b);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i = 0;i<20;i++) {
            Good good;
            if(itemBtnList.get(i)==e.getSource()) {
                good = sqlVisitor.findByBarcode(itemBarcodeList[i]);
                if (good != null) {
                    if(e.getButton()==MouseEvent.BUTTON1) {
                        goodList.addGood(good);
                    }else if(e.getButton()==MouseEvent.BUTTON3){
                        goodList.subtractGood(good);
                    }
                    goodsTable.showGoodList();
                }
                i=20;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
