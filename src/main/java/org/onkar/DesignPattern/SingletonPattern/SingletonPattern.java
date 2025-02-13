package org.onkar.DesignPattern.SingletonPattern;

public class SingletonPattern {

	public static void main(String[] args) {

		AppSetting appSetting = AppSetting.getInstance();
		AppSetting appSettingCopy = AppSetting.getInstance();

		System.out.println(appSetting == appSettingCopy);
	}

}