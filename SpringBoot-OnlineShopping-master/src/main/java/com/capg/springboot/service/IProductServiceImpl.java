package com.capg.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.Exceptions.ProductNotFoundException;
import com.capg.springboot.dto.Productdto;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.entity.Category;
import com.capg.springboot.entity.Product;
import com.capg.springboot.repository.ICartRepository;
import com.capg.springboot.repository.ICategoryRepository;
import com.capg.springboot.repository.IProductRepository;

/*/*****************************************************************************
 * IProduct Controller Class 
 *
 * Created By: Sumit Gangotri
 * Date:08/01/2022 
 *******************************************************************************/

@Service
@Transactional
public class IProductServiceImpl implements IProductService {
  
	@Autowired
	private IProductRepository iproductrepository;
	@Autowired
	private ICartRepository icartrepository;
	@Autowired 
	private ICategoryRepository icategoryrepository;
	
	
//*********************************************************************************************************************	
		
	/* Method: viewAllproduct
	 * Description: It views all product for customer
	 * @Override: It indicates that the child class method is over-writing its base class method.
	 * return: It returns the address. 
	 */
	@Override
	public List<Product> viewAllProducts() {
	
		return iproductrepository.findAll();
	}
	
//*********************************************************************************************************************	
	
	/* Method: viewProductbyid
	 * Description: it views the product for customer by if
	 * @Override: It indicates that the child class method is over-writing its base class method.
	 * return: It returns the address. 
	 */	
	@Override
	public Product viewProduct(String id) {
		
		return iproductrepository.findByproductId(id);
	}
	
	
//*********************************************************************************************************************	
	
		/* Method: removeProduct 
		 * Description: It remove the product for customer.
		 * @Override: It indicates that the child class method is over-writing its base class method.
	     * return: It returns the address. 
	     */

	@Override
	public Product removeProduct(String pid) throws ProductNotFoundException {
		Product product= iproductrepository.deleteByproductId(pid);
		   if(product==null)
			   throw new ProductNotFoundException("Product Not Found Exception");
		   return product;
	}
	

	@Override
	public Product addProduct(Productdto productdto) {
		Cart cart = icartrepository.findByCartId(productdto.getCartId());
		Category category=icategoryrepository.findByCatId(productdto.getCatId());
		// copy each field from productdto to Product
		// sdd cart and category to Product.
		Product product = new Product();
		product.setCart(cart);
		product.setCategory(category);
		product.setColor(productdto.getColor());
		product.setDimension(productdto.getDimension());
		product.setManufacturer(productdto.getManufacturer());
		product.setPrice(productdto.getPrice());
		product.setProductId(productdto.getProductId());
		product.setProductName(productdto.getProductName());
		product.setQuantity(productdto.getQuantity());
		product.setSpecification(productdto.getSpecification());
		return iproductrepository.save(product);
	}

//*********************************************************************************************************************	
	
		/* Method: updateProdut
		 * Description: It update the product
		 * @Override: It indicates that the child class method is over-writing its base class method.
	     * return: It returns the address. 
	     */
	
	@Override
	public Product updateProduct(Productdto productdto) {
		// TODO Auto-generated method stub
		Cart cart = icartrepository.findByCartId(productdto.getCartId());
		Category category=icategoryrepository.findByCatId(productdto.getCatId());
		// copy each field from productdto to Product
		// sdd cart and category to Product.
		Product product = new Product();
		product.setCart(cart);
		product.setCategory(category);
		product.setColor(productdto.getColor());
		product.setDimension(productdto.getDimension());
		product.setManufacturer(productdto.getManufacturer());
		product.setPrice(productdto.getPrice());
		product.setProductId(productdto.getProductId());
		product.setProductName(productdto.getProductName());
		product.setQuantity(productdto.getQuantity());
		product.setSpecification(productdto.getSpecification());
		return iproductrepository.save(product);
	
	}

//*********************************************************************************************************************	
	
	/* Method: findAllProductbyCategory
	 * Description: It finds all the product by category for customer.
	 * @Override: It indicates that the child class method is over-writing its base class method.
	 * return: It returns the address. 
	 */
	
	@Override
	public List<Product> findAllProductByCategory(String cname) throws ProductNotFoundException {
          
		List<Product> product= iproductrepository.findAllProductByCategory(cname);
		 if(product==null||product.size()==0)
			 throw new ProductNotFoundException("Product Not Found");
		return product;
	}



	
	}
