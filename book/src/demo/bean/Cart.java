package demo.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Eric
 * @date 2021/1/22 10:47
 */
public class Cart {

    /**
     * key 商品编号
     * value 商品信息
     */
    private Map<Integer,CartItem> items=new LinkedHashMap<Integer,CartItem>();

    /**添加商品
     * @param cartItem 商品对象
     */
    public void addItem(CartItem cartItem){
//        判断购物车是否加入该商品
        CartItem item = items.get(cartItem.getId());
//        未添加
        if (item==null){
            items.put(cartItem.getId(),cartItem);
        }else {
//         已添加
//            数量累加
            item.setCount(item.getCount()+1);
//            总金额累加
            item.setTotalPrice(item.getTotalPrice().add(item.getPrice()));
        }
    }

    /**删除商品
     * @param id 商品编号
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
    }

    /**修改商品数量
     * @param id 编号
     * @param count 数量
     */
    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        cartItem.setCount(count);
        cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
    }

    public Integer getTotalCount(){
        Integer totalCount=0;
        for (Integer a:items.keySet()){
            totalCount=totalCount+items.get(a).getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        for (Integer a:items.keySet()){
            totalPrice=totalPrice.add(items.get(a).getTotalPrice());
        }
        return totalPrice;
    }
    public Map<Integer,CartItem>getItems(){
        return items;
    }
    public void setItems(Map<Integer,CartItem> items){
        this.items=items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount="+getTotalCount()+
                ",totalPrice="+getTotalPrice()+
                ",items=" + items +
                '}';
    }
}
