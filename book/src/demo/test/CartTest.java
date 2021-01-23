package demo.test;

import demo.bean.Cart;
import demo.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Eric
 * @date 2021/1/22 11:35
 */
public class CartTest {
    Cart cart = new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"级",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"级",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"三级",1,new BigDecimal(900),new BigDecimal(900)));
        cart.addItem(new CartItem(998,"四级",1,new BigDecimal(900),new BigDecimal(900)));
        cart.updateCount(998,10);
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        System.out.println(cart);
    }

    @Test
    public void clear() {

    }

    @Test
    public void updateCount() {
    }
}