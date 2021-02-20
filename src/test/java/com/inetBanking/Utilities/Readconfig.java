package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
Properties pro; // This is object of property class

public Readconfig() // construction which read the property file
{
	File src=new File("./Configuration/config.properties");
	try
	{
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		}
	catch (Exception e)
	{
		System.out.println("Exception is "+e.getMessage());
	}
}
	
// Now creating different method to read each and every variable

public String getapplicationURL() //This method will return baseurl
{
String url=pro.getProperty("baseURL");
return url;
}

public String getUsername() //This method will return username
{
	String username=pro.getProperty("username");
	return username;
}


public String getpassword()// this method will return password
{
	String password=pro.getProperty("password");
	return password;
	
}
public String getchromepath() ////This method will return chromepath
{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	
}

public String getiepath() //this will return iepath
{
	String iepath=pro.getProperty("iepath");
	return iepath;
}

public String getfirefoxpath()//this will return firfoxpath
{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
}
}
