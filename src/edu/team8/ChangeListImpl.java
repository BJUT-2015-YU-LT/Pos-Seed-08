package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;

import java.util.ArrayList;

/**
 * Created by 啸宇 on 2016/1/7.
 */
public class ChangeListImpl implements ChangeList{
    @Override
    public ArrayList<GoodExtends> ChangeList1(ArrayList<Good> list)
    {
        ArrayList<GoodExtends> list1 = new ArrayList<GoodExtends>();
        int i=0;
        for (Good g:list)
        {
            if((i=list1.indexOf(g))>=0)
            {
                list1.get(i).countUp();
            }
            else
            {
                list1.add(new GoodExtends(g));
            }
        }
        return list1;
    }
}
