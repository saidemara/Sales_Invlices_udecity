package Model;

public class InvoiceLine extends InvoiceHeader {

    public String getInvoiceNum() {
        return InvoiceNum;
    }

    public void setInvoiceNum(String Invoice) {
        InvoiceNum = Invoice;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    String InvoiceNum;
    String ItemName;
    String ItemPrice;
    String  Count;
    public String toString() {
        return "InvoiceName is :=" + getItemName() + "{" +
                "ItemPrice is:= " + getItemPrice() + " Count is := " + getCount()+"}";
    }


}
