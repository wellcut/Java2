package co.micol.notice.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.notice.common.Command;
import co.micol.notice.product.service.ProductService;
import co.micol.notice.product.service.ProductVO;
import co.micol.notice.product.serviceImpl.ProductServiceImpl;

public class ProductInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//제품등록 처리 및 파일업로드
		ProductService ps = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		String saveDir = "upload/";
		int maxSize = 100*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(
												request, 
												saveDir, 
												maxSize, 
												"utf-8", 
												new DefaultFileRenamePolicy());
			String pfile = multi.getFilesystemName("pfile");
			pfile = saveDir + pfile; 
			String ofile = multi.getOriginalFileName("pfile");
			
			vo.setProductId(multi.getParameter("productId"));
			vo.setProductName(multi.getParameter("productName"));
			
			if(ofile != null) {
				vo.setProductImg(ofile);
				vo.setProductDir(pfile);
			}
			
			ps.productInsert(vo);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return "productList.do";
	}

}
