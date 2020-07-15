package com.villezone.gautam.listner;

public interface ProductItemListener<T> {
    void onClick(T item);
    void onCartAdded();
}
