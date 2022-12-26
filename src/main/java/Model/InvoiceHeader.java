package Model;

import java.util.ArrayList;

public class InvoiceHeader {

    String InvoiceID;
    String InvoiceDate;
    String CustomerName;

    ArrayList<InvoiceLine> Items = new ArrayList<InvoiceLine>() ;
    public String getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        InvoiceID = invoiceID;
    }

    public String getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    @Override
    public String toString() {

        return "InvoiceID is :=" + getInvoiceID() + "{" +
                "CustomerName is:= " + getCustomerName() + " Date is := " + getInvoiceDate()+"}";
    }


}
