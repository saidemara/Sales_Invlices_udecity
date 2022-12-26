package Model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperation extends InvoiceLine {

    String Flag;

    static FileOperation InvoiceHeadObj = new FileOperation();
    static InvoiceHeader Header = new InvoiceHeader();




    ArrayList<InvoiceHeader> Invoices = new ArrayList<InvoiceHeader>();

    public static void main(String[] args) {

//        InvoiceHeadObj.GetInvoicesHeader();
//        InvoiceHeadObj.GetInvoicesLine();

    }

    public ArrayList<InvoiceHeader> GetInvoicesHeader() {
        try {
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(new File("src/main/resources/InvoiceHeader.csv"));
            // create csvReader object a    nd skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    if (cell.startsWith("T", 0)) {
                        Header.setInvoiceID(cell);

                    } else if (cell.contains("/")) {
                        Header.setInvoiceDate(cell);

                    } else {
                        Header.setCustomerName(cell);
                    }
                }
                Invoices.add(Header);
//                System.out.println(Header.toString());
            }
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Invoices;
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
                for (String cell : row) {
                    if (cell.startsWith("T", 0)) {
                        InvoiceHeadObj.setInvoiceNum(cell);
                        Flag = "ID";
                    } else if (Flag.equals("ID")) {
                        InvoiceHeadObj.setItemName(cell);
                        Flag = "EGP";
                    } else if (Flag.equals("EGP")) {
                        InvoiceHeadObj.setItemPrice(cell);
                        Flag = "Count";
                    } else if (Flag.equals("Count")) {
                        InvoiceHeadObj.setCount(cell);
                    }
                    InvoiceHeadObj.Items.add(InvoiceHeadObj);

                }
//                    System.out.println(InvoiceHeadObj.toString());

            }
            ReaderLine.close();

        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return InvoiceHeadObj.Items;
    }


}