package co.micol.notice.product.service;

import java.util.List;

//Model을 구현할때 사용하는 인터페이스
public interface ProductService {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);
}
