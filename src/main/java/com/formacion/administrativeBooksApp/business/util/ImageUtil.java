package com.formacion.administrativeBooksApp.business.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUtil {
	public String saveImage(MultipartFile multiPart, HttpServletRequest request) {
		try {
			String imageName = getImageName(
					multiPart.getOriginalFilename(), 
					request.getServletContext().getRealPath("/resources/images/Books/")
					);
			File imageFile = new File(imageName);
			multiPart.transferTo(imageFile);
			return imageName;
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
		
	private static String getImageName(String originalName, String routeName) {
			String[] originalNames = originalName.split("\\\\");
			String imageName = avoidDuplicatedString(originalNames[originalNames.length - 1]);
			//String routeName="C:\\Users\\droliva\\Desktop\\Udemy\\AdministrativeBookApp\\AdministrativeBooksApp\\trunk\\src\\main\\webapp\\resources\\images\\Books\\";
			return imageName + routeName;
	}
	
	private static String avoidDuplicatedString(String name) {
		String resultName = name.replace(" ", "-");
		resultName = getRandomAlphaNumeric(8) + resultName;
		return resultName;
	}
	
	private static String getRandomAlphaNumeric(int count) {
		String randomCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * randomCharacter.length());
			builder.append(randomCharacter.charAt(character));
		}
		return builder.toString();
	}
}
