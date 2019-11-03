package com.modal;

public class Order_details {
private int id;
private Orders order_id;
private Product product_id;
private int quantity;


public Order_details() {
super();
}

public Order_details(Orders order_id, Product product_id, int quantity) {
super();

this.order_id = order_id;
this.product_id = product_id;
this.quantity = quantity;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Orders getOrder_id() {
return order_id;
}

public void setOrder_id(Orders order_id) {
this.order_id = order_id;
}

public Product getProduct_id() {
return product_id;
}

public void setProduct_id(Product product_id) {
this.product_id = product_id;
}

public int getQuantity() {
return quantity;
}

public void setQuantity(int quantity) {
this.quantity = quantity;
}

@Override
public String toString() {
return "Order_details [id=" + id + ", order_id=" + order_id + ", product_id=" + product_id + ", quantity="
+ quantity + "]";
}

}