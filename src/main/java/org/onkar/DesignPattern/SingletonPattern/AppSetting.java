package org.onkar.DesignPattern.SingletonPattern;

class AppSetting {
	
	private static AppSetting appSetting;
	private String databaseUrl;
	private String apiKey;
	
	public static AppSetting getInstance() {
		if(appSetting == null) {
			appSetting = new AppSetting();
		}
		return appSetting;
	}
	
	private AppSetting() {
		
		// Read settings form the configuration file.
		databaseUrl = "hkhdkflajsfjasfjl";
		apiKey = "ADCG";
	}
	
	public String getDatabaseUrl() {
		return databaseUrl;
	}
	
	public String getApiKey() {
		return apiKey;
	}
}

