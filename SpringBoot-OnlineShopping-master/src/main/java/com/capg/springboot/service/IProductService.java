package com.capg.springboot.service;

import java.util.List;
import java.util.Optional;

import com.capg.springboot.Exceptions.ProductNotFoundException;
import com.capg.springboot.dto.Productdto;
import com.capg.springboot.entity.Category;
import com.capg.springboot.entity.Product;

/*/*****************************************************************************
 * IProduct Controller Class 
 *
 * Created By: Sumit Gangotri
 * Date:08/01/2022 
 *******************************************************************************/

public interface IProductService {
  public List<Product> viewAllProducts();
  public Product addProduct(Productdto productdto);
  
  public Product updateProduct(Productdto productdto);
  public Product viewProduct(String id)throws ProductNotFoundException;
  public List<Product> findAllProductByCategory(String cname) throws ProductNotFoundException;
  public Product removeProduct(String pid) throws ProductNotFoundException;

 
}
