package com.example.demo.b4.Services;

import com.example.demo.b4.Controller.productController;
import com.example.demo.b4.Giohang;
import com.example.demo.b4.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GiohangService {
    private final Giohang gh = new Giohang();
    private final productController x = new productController();
    public void add(int proid, int quantity){
        Map<Product, Integer> list = gh.getListproduct();
        Product pro = findProduct(proid);
        if(list.containsKey(pro)){
            int currentQuantity = list.get(pro);
            int newQuantity = currentQuantity + quantity;
            list.put(pro, newQuantity);
        }else{
            list.put(pro, quantity);
        }
    }

    public void remove(int proid){
        Map<Product, Integer> list = gh.getListproduct();
        Product pro = findProduct(proid);
        if(list.containsKey(pro)){
            int currentQuantity = list.get(pro);
            list.remove(pro);
        }
    }
    public Product findProduct(int proid){
        List<Product> test = x.getList();
        for (Product pro: test) {
            if(pro.getProid() == proid){
                return pro;
            }
        }
        return null;
    }


    public Map<Product, Integer> getList(){
        return gh.getListproduct();
    }
}

//    public void add(int proid, int quantity){
//        Map<Product, Integer> list = gh.getListproduct();
//        List<Product> listpro = new ArrayList<>(list.keySet());
//        Product pro = findProduct(listpro, proid);
//        if(pro != null){
//            int currentquantity = list.get(findProduct(listpro, proid));
//            int newquantity = currentquantity + quantity;
//            list.put(pro, newquantity);
//        }else{
//            list.put(pro, quantity);
//        }
//    }
