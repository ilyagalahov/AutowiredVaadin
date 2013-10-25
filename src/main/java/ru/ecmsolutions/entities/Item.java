package ru.ecmsolutions.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ilya
 * Date: 25.10.13
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Item {

    @Id
    private long ID;
    private int price;
    private byte[] photo;
    private String name;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
