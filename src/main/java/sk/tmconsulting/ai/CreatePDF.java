package sk.tmconsulting.ai;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class CreatePDF {
    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("HelloWorld2.pdf"));
            document.open();
            document.add(new Paragraph("Hello World!"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
