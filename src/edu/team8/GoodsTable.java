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
            row.add(good.getDiscount());
            /*switch (good.getPreferType())
            {
                case Good.NORMAL:
                    row.add(good.getPrice());
                    break;
                case Good.DISCOUNT:
                    if(null!=vipInfo){
                        good.setPrice(good.getPrice()*good.getVipDiscount());
                    }else{
                        good.setPrice(good.getPrice()*good.getDiscount());
                    }
                    break;
                case Good.PROMOTION:
                    GoodExtends savedGood = new GoodExtends(good);
                    //计算节省的商品个数
                    savedGood.setTotalCount(savedGood.getTotalCount()-savedGood.getPaidCount());
                    savedList.add(savedGood);
                    break;
            }*/
        }
        tableData.add(row);
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
