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
 * This is the Interface that defines methods for processing product sales data.
 */
public interface IProductSales {
    /**
     * Returns the 2D array of product sales data.
     * Rows represent years, columns represent products.
     */
    int[][] GetProductSales();
    /**
     * This returns the total sales across all products and years.
     */
    int GetTotalSales();
    /**
     * Returns the count of sales items over the sales limit.
     */
    int GetSalesOverLimit();
    /**
     * This returns the count of sales items under the sales limit.
     */
    int GetSalesUnderLimit();
    /**
     * Returns the number of years for which sales data exists.
     */
    int GetProductsProcessed();
    /**
     * This returns the average sales per product item processed.
     */
    double GetAverageSales();
}
