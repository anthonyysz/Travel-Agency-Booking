package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //get cart info from purchase
        Cart cart = purchase.getCart();

        // generate tracking number and setting the tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populating the cart with the cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        if (cart != null) {
            if(cartItems.isEmpty() == false) {
                for (CartItem item : cartItems){
                    if (item == null){
                        return new PurchaseResponse("There was an error checking out");
                    }
                    else {
                        item.setCart(cart);
                        cart.add(item);
                    }
                }
            }
            else {
                return new PurchaseResponse("There was an error checking out");
            }
        }
        else {
            return new PurchaseResponse("There was an error checking out");
        }

        //populating the customer with the cart
        Customer customer = purchase.getCustomer();
        cart.setCustomer(customer);

        //marking the order as ordered
        cart.setStatus(StatusType.ordered);

        //saving the cart
        cartRepository.save(cart);

        //returning the tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
