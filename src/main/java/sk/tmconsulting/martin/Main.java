package sk.tmconsulting.martin;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Main {
    public static void main(String[] args) throws IOException {
        // Vytvorenie nového dokumentu PDF
        PDDocument document = new PDDocument();

        // Vytvorenie novej stránky v dokumente
        PDPage page = new PDPage();
        document.addPage(page);

        // Vytvorenie objektu na kreslenie do stránky
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Nastavenie fontu a veľkosti textu
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        // Vloženie textu na stránku
        contentStream.beginText();
        contentStream.newLineAtOffset(0, 0);
        contentStream.showText("Hello World");
        contentStream.endText();

        // Zatvorenie objektu na kreslenie
        contentStream.close();

        // Uloženie dokumentu
        document.save("hello.pdf");

        // Zatvorenie dokumentu
        document.close();
    }
}
