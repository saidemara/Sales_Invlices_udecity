package Controller;

import Model.FileOperation;
import Model.InvoiceHeader;
import Model.InvoiceLine;

import java.util.ArrayList;
import java.util.List;

public class Print extends FileOperation {
    public static void main(String[] args) {

        FileOperation Files = new FileOperation();
//        ArrayList<InvoiceHeader> ListOFInvoie = Files.GetInvoicesHeader();
//        ArrayList<InvoiceLine> ListOFIines = Files.GetInvoicesLine();

        for (InvoiceHeader FileData :Files.GetInvoicesHeader())
        {
            for(InvoiceLine FileDataLIne :Files.GetInvoicesLine())
          if(FileData.getInvoiceID().equals(FileDataLIne.getInvoiceNum()))
          {
              System.out.println(Files.GetInvoicesHeader()  .toString());
          }
        }


    }
}
