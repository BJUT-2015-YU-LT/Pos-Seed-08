package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啸宇 on 2016/1/6.
 */
public class ChangeList {
    public ChangeList() {
        ArrayList<Good> list = new ArrayList<Good>();
        ArrayList<GoodExtends> list1 = new ArrayList<GoodExtends>();
        List<String> list2=new ArrayList<String>();
        for(int k=0;k<list.size();k++)
        {
            list2=list.get(k).getBarcode();
        }
        int i,count=0,count1;
        Good good;
        for (i = 0; i < list.size(); i++) {
            good= list.get(i);
            good.getBarcode();
            list1.get(i).setCount(count++);
            count=list1.get(i).getCount();
            list1.get(i).setCount(count++);
        }
    }
}
