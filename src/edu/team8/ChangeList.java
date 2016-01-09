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

    /**
     * 第二轮迭代
     * 根据商品列表和索引文件生成购物清单
     * @param itemList
     * @param barcodeList
     * @return
     */
    public static ArrayList<GoodExtends> ConvertList(ArrayList<Good> itemList,ArrayList<String> barcodeList)
    {
        ArrayList<GoodExtends> list1 = new ArrayList<GoodExtends>();
        for (Good good:itemList)
            list1.add(new GoodExtends(good));
        int i=-1;
        for (String s:barcodeList)
        {
            Good tempGood = new Good(s);
            if((i=itemList.indexOf(tempGood))>=0)
            {
                list1.get(i).countUp();
            }
        }
        for (i=0;i<list1.size();i++)
        {
            if(list1.get(i).getCount()==0)
                list1.remove(i);
        }
        return list1;
    }
}