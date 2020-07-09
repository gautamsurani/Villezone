package com.villezone.gautam.listner;

import com.villezone.gautam.model.CartItem;

public interface CartItemClickListener {
    void onPlusClick(CartItem cartItem);

    void onMinusClick(CartItem cartItem);

    void onDeleteClick(CartItem cartItem, int position);
}
