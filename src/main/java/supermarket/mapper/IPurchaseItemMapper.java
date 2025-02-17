package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.PurchaseItem;

@Mapper
public interface IPurchaseItemMapper extends IMapper<PurchaseItem> {
    PurchaseItem get(long purchaseId, long productId);
}
