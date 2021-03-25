package com.maktab.models;

import javax.persistence.*;

@Entity
public class ParcelPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Weight", nullable = false)
    private double weight;
    @Column(name = "Content", nullable = false)
    private String content;
    @Column(name = "Length", nullable = false)
    private double length;
    @Column(name = "Width", nullable = false)
    private double width;
    @Column(name = "Height", nullable = false)
    private double height;

    public ParcelPost() {
    }

    public ParcelPost(double weight) {
        this.weight = weight;
        this.content = "Document Content";
    }

    public ParcelPost(double weight, String content, double length, double width, double height) {
        this.weight = weight;
        this.content = content;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
