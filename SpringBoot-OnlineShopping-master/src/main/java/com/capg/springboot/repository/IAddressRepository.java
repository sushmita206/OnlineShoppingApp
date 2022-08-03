package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.Address;

/*/*****************************************************************************
 * IAddress Controller Class
 * 
 * Created By: Siddharth Shitole
 * Date:08/01/2022 
 *******************************************************************************/

public interface IAddressRepository extends JpaRepository<Address,String> {

	Address findByAddressId(String addressid);
   
}
