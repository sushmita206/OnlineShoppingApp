package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.Category;

/*/*****************************************************************************
 *ICart Controller Class 
 *
 * Created By: Nagasindhur Bachu
 * Date:08/01/2022 
 *******************************************************************************/

public interface ICategoryRepository extends JpaRepository<Category,String> {
	Category findByCatId(String catId);
}
