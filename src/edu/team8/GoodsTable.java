package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;
import edu.team8.classes.GoodList;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by 知昊 on 2016/1/14. 11:45
 */
public class GoodsTable extends JPanel
{
    private static final Vector<Object> tableHeader = new Vector<>();
    private Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

    private JTable table;
    private JScrollPane scroll;

    private GoodList goodList;
    private boolean isVip;

    public GoodsTable() {
        super(new GridLayout());
        {
            tableHeader.add("条码");
            tableHeader.add("名称");
            tableHeader.add("数量");
            tableHeader.add("单位");
            tableHeader.add("单价");
            tableHeader.add("优惠");
        }
        table = new JTable(tableData,tableHeader);
        table.setEnabled(false);
        scroll = new JScrollPane(table);
        this.add(scroll);
    }

    public int getGood(Good good)
    {
        return 0;
    }

    public void showGoodRow(GoodExtends good)
    {
        Vector<Object> row = new Vector<Object>();
        {
            row.add(good.getBarcode());
            row.add(good.getName());
            row.add(good.getTotalCount());
            row.add(good.getUnit());
            row.add(String.format("%.2f", good.getPrice()));
            switch (good.getPreferType())
            {
                case Good.NORMAL:
                    row.add("无");
                    break;
                case Good.DISCOUNT:
                    row.add(discountToString(good.getDiscount())+"/会员"+
                            discountToString(good.getVipDiscount()));
                    break;
                case Good.PROMOTION:
                    row.add("买 " + String.format("%.0f",good.getDiscount()) + " 赠一");
                    break;
            }
        }
        tableData.add(row);
    }

    private String discountToString(double discount)
    {
        String s = new String();

        if(discount==1)return "无";
        int decide = (int)(discount*100);
        if(decide%10==0)
            s += String.format("%.0f",discount*10);
        else
            s += String.format("%.0f",discount*100);
        s+="折";
        return s;
    }

    public void showGoodList()
    {
        tableData.clear();
        for(GoodExtends ge:goodList.getGoods()) {
            showGoodRow(ge);
        }
        SwingUtilities.updateComponentTreeUI(table);
    }

    public void setGoodList(GoodList goodList) {
        this.goodList = goodList;
    }

    public void clear(){
        this.tableData.clear();
    }
}
