package com.Aspen.rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		
		Date d = new Date();
		String screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		System.out.println(screenshotName);
		System.out.println(d);

	}

}
