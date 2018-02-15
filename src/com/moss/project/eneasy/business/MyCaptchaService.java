package com.moss.project.eneasy.business;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class MyCaptchaService {
	// a singleton class
	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();

	public static ImageCaptchaService getInstance() {
		return instance;
	}
	
}
