package edu.team8.classes;

import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/14. 14:27
 */
public class GoodList
{
    private ArrayList<GoodExtends> goods;

    public GoodList() {
        this.goods = new ArrayList<GoodExtends>();
    }

    public void addGood(Good good)
    {
        int i = -1;
        if((i=goods.indexOf(good))<0) {
            GoodExtends ge = new GoodExtends(good);
            ge.countUp();
            goods.add(ge);
        }else{
            goods.get(i).countUp();
        }
    }

    public void subtractGood(Good good)
    {
        int i = -1;
        if((i=goods.indexOf(good))>=0)
        {
            goods.get(i).countDown();
            if(goods.get(i).getTotalCount()<=0)
                goods.remove(i);
        }
    }

    public void subtractGood(int goodIndex)
    {
        if(0 <= goodIndex && goodIndex <= goods.size())
        {
            goods.get(goodIndex).countDown();
            if(goods.get(goodIndex).getTotalCount()<=0)
                goods.remove(goodIndex);
        }
    }

    public ArrayList<GoodExtends> getGoods() {
        return goods;
    }

    public void clear(){
        goods.clear();
    }

    public boolean isEmpty(){return this.goods.size()==0;}
}
