package Model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperation extends InvoiceLine {

    private String Flag;
    InvoiceHeader Header;
    InvoiceLine Line;
    static FileOperation FIle = new FileOperation();
    ArrayList<InvoiceHeader> InvoicesList = new ArrayList<>();




    public void PrintInvoice()
       { for (InvoiceHeader row : GetInvoicesHeader()) {
           for (InvoiceLine RowLine : GetInvoicesLine()) {
               if (row.getInvoiceID().equals(RowLine.getInvoiceNum())) {
                   System.out.println("The Invoice1Num Is :" + row.InvoiceID + "\n" + "{ Invoice1Date " + row.InvoiceDate
                           + "," + "Customer1Name" + row.CustomerName + "/nl "
                           + "Item1Name " + RowLine.getItemName() + "," + "Item2Price" + "," + RowLine.getItemPrice() + "," + "Item2Price" + RowLine.getCount() + "}");
                      break;
               }

               }
           }
       }





    public ArrayList<InvoiceHeader> GetInvoicesHeader() {
        try {
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(new File("src/main/resources/InvoiceHeader.csv"));
            // create csvReader object a    nd skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            // print Data
            for (String[] row : allData) {
                Header = new InvoiceHeader();
                for (String cell : row) {
                    if (cell.startsWith("T", 0)) {
                        Header.setInvoiceID(cell);
                    } else if (cell.contains("/")) {
                        Header.setInvoiceDate(cell);
                    } else {
                        Header.setCustomerName(cell);
                    }
                }
                InvoicesList.add(Header);
//                System.out.println(Header.toString());
//                ArrayList<InvoiceHeader> Invoices = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return InvoicesList;

    }


    public ArrayList<InvoiceLine> GetInvoicesLine() {
        try {

            FileReader Path = new FileReader(new File("src/main/resources/InoviceLines.csv"));
            // create csvReader object a    nd skip first Line
            CSVReader ReaderLine = new CSVReaderBuilder(Path)
                    .withSkipLines(1)
                    .build();
            // print Data
            for (String[] row : ReaderLine) {
                Line = new InvoiceLine();
                for (String cell : row) {
                    if (cell.startsWith("T", 0)) {
                        Line.setInvoiceNum(cell);
                        Flag = "ID";
                    } else if (Flag.equals("ID")) {
                        Line.setItemName(cell);
                        Flag = "EGP";
                    } else if (Flag.equals("EGP")) {
                        Line.setItemPrice(cell);
                        Flag = "Count";
                    } else if (Flag.equals("Count")) {
                        Line.setCount(cell);
                    }
                }
                Items.add(Line);
//                System.out.println(Line.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Items;
    }


}