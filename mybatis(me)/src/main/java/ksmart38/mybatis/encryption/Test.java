package ksmart38.mybatis.encryption;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Test {

	public static void main(String[] args) {
		StandardPBEStringEncryptor stringPBEConfig = new StandardPBEStringEncryptor();
		stringPBEConfig.setPassword("ksmart38"); 			//대칭키(암호화키)
		stringPBEConfig.setAlgorithm("PBEWithMD5AndDES"); 	//사용할 암호화 알고리즘
		
		//암호화할 평문 대상
		String jdbcUrl = "jdbc:log4jdbc:mysql://localhost:3306/ksmart38db?serverTimezone=UTC&characterEncoding=UTF8";
		String userName = "root";
		String password = "java0000";
		
		System.out.println("평문(jdbcUrl) : " + jdbcUrl);
		System.out.println("암호문(jdbcUrl) : " + stringPBEConfig.encrypt(jdbcUrl));
		System.out.println("평문(userName) : " + userName);
		System.out.println("암호문(userName) : " + stringPBEConfig.encrypt(userName));
		System.out.println("평문(password) : " + password);
		System.out.println("암호문(password) : " + stringPBEConfig.encrypt(password));
		
		System.out.println("복호화(jdbcUrl) : " + stringPBEConfig.decrypt("Yxy6W4K3jZat0NZg5w/hbO4sSi/asgIwT1E+5EvWg02MWFZ0VI+bCT9FNuuoCUqzTHc7kRrxKNdIGUY5J0JVRGcoqmato3VeVMuQbsYwsP55Jf+oRFM6hfbbuoqsbMw/2/nbQDXSsU0="));
		System.out.println("복호화(userName) : " + stringPBEConfig.decrypt("V/V+VP3fh1y8pcgjFKHO6g=="));
		System.out.println("복호화(password) : " + stringPBEConfig.decrypt("K6eg/sIdKnaZqUd5BdYvj0Psbk9QTY5D"));
		
	}

}
