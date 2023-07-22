package com.fabrick.colmi.davidemaria.commons;

public class Constants {

	private Constants() {}
	
	public static final String GET_ACCOUNT = "/api/gbs/banking/v4.0/accounts/{accountId}";
	public static final String ACCOUNT_BALANCE = "/api/gbs/banking/v4.0/accounts/{accountId}/balance";
	public static final String ACCOUNT_TRANSACTIONS = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions";
	public static final String MONEY_TRANSFER = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";
	public static final String BASE_URL = "https://sandbox.platfr.io";
	public static final String AUTH_SCHEMA = "Auth-Schema";
	public static final String AUTH_SCHEMA_VALUE = "S2S";
	public static final String API_KEY = "Api-Key";
	public static final String API_KEY_VALUE = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	public static final String TIME_ZONE = "X-Time-Zone";

}
