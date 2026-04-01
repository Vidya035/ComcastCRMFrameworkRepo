package com.workshop.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	{
		Random ranDom=new Random();
		int ranDomNumber=ranDom.nextInt(5000);
		return ranDomNumber;
	}
	
	public String getSysytemDateYYYYDDMM()
	{
		Date obj=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(obj);
		return date;
	}
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date obj=new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(obj);
	    cal.add(Calendar.DAY_OF_MONTH, days);
	    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	    String endDate = sim.format(cal.getTime());
	    return endDate;
	}
}
