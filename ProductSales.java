/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maingui;

/**
 *
 * @author RC_Student_Lab
 */
/**
 * Class implementing IProductSales interface to provide
 * sales processing logic for the retailer's products.
 */
public class ProductSales implements IProductSales {
    // 2D array salesData: Rows = years, Columns = products (Microphone, Speakers, Mixing Desk)
    private final int[][] salesData;
    // Sales limit used to categorize sales as over or under limit
    private final int salesLimit = 500;
    /**
     * Constructor initializes the sales data for 2 years.
     * Data derived from the sales table shown: microphones, speakers, mixing desk.
     */
    public ProductSales() {
        this.salesData = new int[][] {
            {300, 150, 700},  // Year 1 sales for each product
            {250, 200, 600}   // Year 2 sales for each product
        };
    }
    /**
     * Returns the full sales data.
     */
    @Override
    public int[][] GetProductSales() {
        return salesData;
    }
    /**
     * Calculates the total sales by summing all product sales over all years.
     */
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : salesData) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }
    /**
     * Counts the number of sales records over the sales limit.
     */
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : salesData) {
            for (int sale : year) {
                if (sale > salesLimit) count++;
            }
        }
        return count;
    }
    /**
     * Counts the number of sales records under the sales limit.
     */
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : salesData) {
            for (int sale : year) {
                if (sale < salesLimit) count++;
            }
        }
        return count;
    }
    /**
     * Returns the number of years processed (number of rows in the sales data).
     */
    public int GetProductsProcessed() {
        return salesData.length;
    }
    /**
     * Calculates average sales per product entry.
     */
    public double GetAverageSales() {
        int totalItems = salesData.length * salesData[0].length;
        if (totalItems == 0) return 0;
        return (double) GetTotalSales() / totalItems;
    }
}
