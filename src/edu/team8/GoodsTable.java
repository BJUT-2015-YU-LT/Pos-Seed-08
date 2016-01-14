package edu.team8;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Vector;

/**
 * Created by 知昊 on 2016/1/14. 11:45
 */
public class GoodsTable extends JPanel
{
    private static final Vector<Object> tableHeader = new Vector<>();
    private Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

    public GoodsTable() {
        {
            tableHeader.add("条码");
            tableHeader.add("名称");
            tableHeader.add("数量");
            tableHeader.add("单位");
            tableHeader.add("单价");
        }


    }
}
