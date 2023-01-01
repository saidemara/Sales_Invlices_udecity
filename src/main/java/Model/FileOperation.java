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
    FileOperation FIle;
    ArrayList<InvoiceHeader> InvoicesList = new ArrayList();

    // compare invoice Header to it's line  Invoices
    public void PrintInvoice() {
        //Get All Invoice Header from Method GetInvoicesHeader();
        ArrayList<InvoiceHeader> ListValuesOFHeader = GetInvoicesHeader();
        //Get All Invoice Header line Details from Method  GetInvoicesLine();
        ArrayList<InvoiceLine> ListValuesOFLine = GetInvoicesLine();
        for (InvoiceHeader rowInvoiceHeader : ListValuesOFHeader) {
            // Print as Flag to Print All line Details under One Invoice Header as long as Invoice Lines Includes The Same Forign Key of Invoice Header
            boolean Print = true;
            for (InvoiceLine RowInvoiceLine : ListValuesOFLine) {
                // In Case The First Record of Invoice header matched with Invoice Line
                if (rowInvoiceHeader.getInvoiceID().equals(RowInvoiceLine.getInvoiceNum()) && Print == true) {

                    System.out.println("The Invoice_Num Is=:" + rowInvoiceHeader.InvoiceID + "\n" + "{ Invoice_Date =:" + rowInvoiceHeader.InvoiceDate
                            + "," + "CustomerName=:" + rowInvoiceHeader.CustomerName + " , " +
                            "Item_Name=:" + RowInvoiceLine.getItemName() + "," + "Item_Price=:" + RowInvoiceLine.getItemPrice() + "," + "Count_is=:" + RowInvoiceLine.getCount() + "}");
                    Print = false;
                    // In Case there more than Line under the same unique Invoice Header
                } else if (rowInvoiceHeader.getInvoiceID().equals(RowInvoiceLine.getInvoiceNum()) && Print == false) {
                    System.out.println("{ Invoice_Date =:" + rowInvoiceHeader.InvoiceDate
                            + "," + "CustomerName=:" + rowInvoiceHeader.CustomerName + " , " +
                            "Item_Name=:" + RowInvoiceLine.getItemName() + "," + "Item_Price=:" + RowInvoiceLine.getItemPrice() + "," + "Count_is=:" + RowInvoiceLine.getCount() + "}");
                }
            }

        }
    }

    // Get all Invoice Headers
    public ArrayList<InvoiceHeader> GetInvoicesHeader() {
        try {
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(new File("src/main/resources/InvoiceHeader.csv"));
            // create csvReader object a    nd skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            // print Data
            for (String[] row : allData) {
                FIle = new FileOperation();
                for (String cell : row) {
                    if (cell.startsWith("T", 0)) {
                        FIle.setInvoiceID(cell);
                    } else if (cell.contains("/")) {
                        FIle.setInvoiceDate(cell);
                    } else {
                        FIle.setCustomerName(cell);
                    }
                }
                InvoicesList.add(FIle);
//                System.out.println(Header.toString());
//                ArrayList<InvoiceHeader> Invoices = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return InvoicesList;

    }

    // Get Details of Invoice Header(Lines)
    public ArrayList<InvoiceLine> GetInvoicesLine() {
        try {

            FileReader Path = new FileReader(new File("src/main/resources/InoviceLines.csv"));
            // create csvReader object a    nd skip first Line
            CSVReader ReaderLine = new CSVReaderBuilder(Path)
                    .withSkipLines(1)
                    .build();
            // print Data
            for (String[] row : ReaderLine) {
                FIle = new FileOperation();
                for (String cell : row) {
                    if (cell.startsWith("T", 0)) {
                        FIle.setInvoiceNum(cell);
                        Flag = "ID";
                    } else if (Flag.equals("ID")) {
                        FIle.setItemName(cell);
                        Flag = "EGP";
                    } else if (Flag.equals("EGP")) {
                        FIle.setItemPrice(cell);
                        Flag = "Count";
                    } else if (Flag.equals("Count")) {
                        FIle.setCount(cell);
                    }
                }
                Items.add(FIle);
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