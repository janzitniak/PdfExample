package sk.tmconsulting;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaPdfHelloWorld {
    public static void main(String[] args) {

/*        try {
            FileReader fileReader = new FileReader("subor.txt");
            String textSubor = String.valueOf(fileReader.read());
            System.out.println(textSubor);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Chýba subor.txt!");
        }*/

        String obsah = null; // deklaracia premennej, ktora ma platnost v ramci metody main
        try {
            obsah = new String(Files.readAllBytes(Paths.get("subor.txt")));
            System.out.println(obsah);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        Document document = new Document(); // vytvorime prazdny PDF Dokument
        try {
            // vytvori konkretny subor HelloWorld.pdf, ktorý umiestni do priečinka \\Mac\Home\Documents\
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open(); // dokument musime ho otvorit
            document.add(new Paragraph(obsah)); // do dokumentu vpiseme text A Hello Word PDF document
            document.close(); // zatvorime dokument
            writer.close(); // zatvorime subor
        } catch (DocumentException e) {
            System.out.println("Nastal problém s vytváraním dokumentu");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Problém so súborom!");
        }

        System.out.println("KONIEC aplikácie");

    }
}
