package com.capg.springboot.service;

import com.capg.springboot.Exceptions.UserNotFoundException;
import com.capg.springboot.entity.User;

/*/*****************************************************************************
 *ILogin Controller Class 
 *
 * Created By: Amulya Bodeppagari
 * Date:08/01/2022 
 *******************************************************************************/

public interface IUserService {
	public User addUser(User user);
	public User removeUser(User user);
	public User validateUser(String id)throws UserNotFoundException;
	/* public User signOut(User user); */
}

