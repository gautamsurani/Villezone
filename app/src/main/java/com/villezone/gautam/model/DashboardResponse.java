package com.villezone.gautam.model;

import java.util.List;

public class DashboardResponse {
    private List<Products> discounted_products;

    private List<String> slider_images;

    private List<Products> latest_products;

    public List<Products> getPopular_products() {
        return discounted_products;
    }

    public void setPopular_products(List<Products> popular_products) {
        this.discounted_products = popular_products;
    }

    public List<String> getSlider_images() {
        return slider_images;
    }

    public void setSlider_images(List<String> slider_images) {
        this.slider_images = slider_images;
    }

    public List<Products> getLatest_products() {
        return latest_products;
    }

    public void setLatest_products(List<Products> latest_products) {
        this.latest_products = latest_products;
    }
}