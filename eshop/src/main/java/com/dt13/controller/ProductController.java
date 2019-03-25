package com.dt13.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.dt13.dao.ProductDao;
import com.dt13.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao  daoImpl;
	
	//@RequestMapping(value="/product", method= RequestMethod.GET)
		@RequestMapping("/gotoform")
		public ModelAndView goToForm()
		{
			//ModelAndView mv=new ModelAndView("product","pr",new Product());
			ModelAndView mv=new ModelAndView("product");
			mv.addObject("pr",new Product());
			
			return mv;
			
		}
		
		@RequestMapping(value="/addproduct" , method=RequestMethod.POST )
		public String saveProduct(@ModelAttribute("pr") Product pro)
		{
			System.out.println(pro.getProductId());
			System.out.println(pro.getProductName());
			System.out.println(pro.getProductPrice());
			
			pro.setProductId((int)(Math.random()*10000));
			//ProDaoImpl  daoImpl=new ProDaoImpl();
			
				//get image  
			MultipartFile image=pro.getImage();
			//split into bytes 
			try {
				byte imagearray[]=image.getBytes();
				
				//decide server location to store image
				String path="D://project1/eshop/src/main/webapp/resources/proimg/";
				//assign file name
				path=path+pro.getProductId()+".png";
				//create a file object that connects to location
				File file=new File(path);
				//create stream to store byte array
				FileOutputStream  fos=new FileOutputStream(file);
				//we can not store byte array into fos
				BufferedOutputStream  bos=new BufferedOutputStream(fos);
				
				//we can pass byte array to bos
				bos.write(imagearray);
				
				
						
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			daoImpl.addProduct(pro);
			return "AdminHome";
		}
		
		//getproducts
		@RequestMapping("/getproducts")
		public ModelAndView getProducts()
		{
			ModelAndView mv=new ModelAndView("viewproducts");
		//get data from database and hold it in list
			List productList=daoImpl.getProducts();
			mv.addObject(productList);
			System.out.println(productList);
			return mv;
		}
		
		//getproducts
				@RequestMapping("/adminproducts")
				public ModelAndView adminProducts()
				{
					ModelAndView mv=new ModelAndView("adminproduct");
				//get data from database and hold it in list
					List productList=daoImpl.getProducts();
					mv.addObject(productList);
					System.out.println(productList);
					return mv;
				}
	
				
		
		@GetMapping("/viewproduct")
		public ModelAndView showSingleProduct(@RequestParam("proid") int productId)
		{
			Product product=daoImpl.getProduct(productId);
			ModelAndView mv=new ModelAndView("single","pro",product);
		return mv;
		}
		@GetMapping("/delete")
		public ModelAndView deleteProduct(@RequestParam("proid") int productId)
		{
			Product product=daoImpl.getProduct(productId);
			ModelAndView mv=new ModelAndView("single","pro",product);
		return mv;
		}
		
		
		//viewproduct
		}
		
		

