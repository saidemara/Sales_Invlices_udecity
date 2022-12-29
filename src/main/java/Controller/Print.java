package Controller;

import Model.FileOperation;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import com.sun.org.apache.bcel.internal.generic.IFLE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Print extends FileOperation {


    // Print Inovies Sales
    public static void main(String[] args) {
        Print PrintInvoices = new Print();
        PrintInvoices.PrintInvoice();
    }


}
