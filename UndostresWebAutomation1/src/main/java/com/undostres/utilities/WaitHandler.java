package com.undostres.utilities;

import java.util.concurrent.TimeUnit;

public class WaitHandler extends LaunchApp{
	
	public static void imp_Wait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void exp_Wait() {
		
	}

}
