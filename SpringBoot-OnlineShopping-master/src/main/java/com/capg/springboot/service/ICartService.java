package com.capg.springboot.service;

import com.capg.springboot.Exceptions.CartNotFoundException;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.entity.Product;

/*/*****************************************************************************
 *ICart Controller Class
 *
 * Created By: Sushmita Maity
 * Date:08/01/2022 
 *******************************************************************************/

public interface ICartService {

	public Cart addProductToCart(Cart cart,Product p,int quantity);
	public Cart removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart,Product p,int quantity) ;
	public Cart viewAllProducts(Cart cart) ;
	public Cart removeAllProducts(Cart cart);
}
