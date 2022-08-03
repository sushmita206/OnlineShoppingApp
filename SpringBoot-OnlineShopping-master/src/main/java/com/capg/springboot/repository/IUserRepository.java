package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.User;

/*/*****************************************************************************
 *ILogin Controller Class 
 *
 * Created By: Amulya Bodeppagari
 * Date:08/01/2022 
 *******************************************************************************/

public interface IUserRepository extends JpaRepository<User,String> {
//	public User addUser(User user);
//	public User removeUser(User user);
//	public User validateUser(User user);
//	public User signOut(User user);
	public User findByUserId(String id);
}
