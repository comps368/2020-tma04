package comps368.tma03.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemViewModel {

    private Integer itemId;
    
    @NotEmpty(message = "Item Code must be provided!")
    private String itemCode;

    @NotEmpty(message = "Item Name must be provided!")
    private String itemName;

    private double itemPrice;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public Items copyValue(Items _i){
        _i.setItemCode(this.itemCode);
        _i.setItemName(this.itemName);
        _i.setItemPrice(this.itemPrice);
        return _i;
    }
}
