package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;
	}

	public String getSystemData() {
//		LocalDate date=LocalDate.now();
//		return date;

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
		return date;
	}

	public String getEndDate(int days) {

//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ✅ Correct format
//	        
//	        Calendar cal = Calendar.getInstance(); // ✅ Manually create Calendar
//	        cal.add(Calendar.DAY_OF_MONTH, days);  // ✅ Corrected constant usage
//	        
//	        return sdf.format(cal.getd());
	        
	        LocalDate futureDate = LocalDate.now().plusDays(days);
	        
	        // Format the date as 'yyyy-MM-dd'
	        return futureDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	        

	}

}
