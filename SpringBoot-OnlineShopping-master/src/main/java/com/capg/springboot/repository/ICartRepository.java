package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.Cart;


/*/*****************************************************************************
 *ICart Controller Class
 *
 * Created By: Sushmita Maity
 * Date:08/01/2022 
 *******************************************************************************/

public interface ICartRepository extends JpaRepository<Cart,String>{
	Cart findByCartId(String cartId);

}
