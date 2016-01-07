package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啸宇 on 2016/1/6.
 */
public interface ChangeList {

    public static ArrayList<GoodExtends> processChangeList(ArrayList<Good> list)
    {
        ArrayList<GoodExtends> list1 = new ArrayList<GoodExtends>();
        int i=-1;
        for (Good g:list)
        {
<<<<<<< HEAD

        }
        int i,count=0,count1;
        Good good;
        for (i = 0; i < list.size(); i++) {
            good= list.get(i);
            good.getBarcode();
            list1.get(i).setCount(count++);
            count=list1.get(i).getCount();
            list1.get(i).setCount(count++);
=======
            if((i=list1.indexOf(g))>=0)
            {
                list1.get(i).countUp();
            }
            else
            {
                list1.add(new GoodExtends(g));
            }
>>>>>>> origin/master
        }
        return list1;
    }

}
