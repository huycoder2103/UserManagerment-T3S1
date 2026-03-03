/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa26;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Cart {
    private Map<String, Product> cart;

    public Cart() {
    }

    public Cart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }
    public boolean add(Product product){
        boolean check=false;
        try{
            if(this.cart==null){
                this.cart= new HashMap<>();
                
            }
            if(this.cart.containsKey((product.getId()))){
                int currentQantity=this.cart.get(product.getId()).getQuantity();
                product.setQuantity(currentQantity+product.getQuantity());
            }this.cart.put(product.getId(), product);
            check=true;
        }catch(Exception e){
            
        }
        return check;
    }
}