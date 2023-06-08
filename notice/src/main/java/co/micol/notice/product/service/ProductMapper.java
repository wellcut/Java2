package co.micol.notice.product.service;

import java.util.List;
//Mybatis 사용을 위한 인터페이스
public interface ProductMapper {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);
}
