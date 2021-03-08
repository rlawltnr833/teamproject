package ksmart38.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart38.mybatis.domain.Goods;

@Mapper
public interface GoodsMapper {
	// 상품 조회
	public List<Goods> getGoodsList(String searchKey, String searchValue);
	
	// 상품 등록
	public int addGoods(Goods goods);
	
	// 상품정보 조회
	public Goods getGoodsInfoByGcode(String goodsCode);
	
	// 상품정보 수정
	public int modifyGoods(Goods goods);
}
