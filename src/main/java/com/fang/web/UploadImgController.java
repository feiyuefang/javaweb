package com.fang.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.fang.pojo.TbUser;
import com.fang.service.impl.TbUserServiceImpl;
import com.fang.util.FileUploadUtil;
import com.fang.util.ImgCut;

@Controller
@RequestMapping("/UploadDemo")
public class UploadImgController {

	@Autowired
	private TbUserServiceImpl tbUserService;

	@RequestMapping(value = "/uploadHeadImage", method = RequestMethod.POST)
	 public String uploadHeadImage(
	            HttpServletRequest request,
	            @RequestParam(value = "x") String x,
	            @RequestParam(value = "y") String y,
	            @RequestParam(value = "h") String h,
	            @RequestParam(value = "w") String w,
	            @RequestParam(value = "imgFile") MultipartFile imageFile) throws Exception {
		TbUser user = (TbUser) request.getSession().getAttribute("tbuser");
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String resourcePath = "images/uploadPortrait/";
		if (imageFile != null) {
			if (FileUploadUtil.allowUpload(imageFile.getContentType())) {
				String saveName = user.getAccountNumber();
				File dir = new File(realPath + resourcePath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File file = new File(dir, saveName + ".jpg");
				imageFile.transferTo(file);
				String srcImagePath = realPath + resourcePath + saveName;
				int imageX = Integer.parseInt(x);
				int imageY = Integer.parseInt(y);
				int imageH = Integer.parseInt(h);
				int imageW = Integer.parseInt(w);
				// 这里开始截取操作
				System.out.println("==========imageCutStart=============");
				ImgCut.imgCut(srcImagePath, imageX, imageY, imageW, imageH);
				System.out.println("==========imageCutEnd=============");
				user.setHeadPortrait(resourcePath + saveName+".jpg");
				int k = tbUserService.updatePortrait(user);
				if (k == 1) {
					request.getSession().setAttribute("tbuser", user);
				}
			}
		}
		return "index";
	}
}
