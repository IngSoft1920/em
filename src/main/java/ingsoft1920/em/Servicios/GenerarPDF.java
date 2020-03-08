package ingsoft1920.em.Servicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarPDF {

    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
    /**
     * We create a PDF document with iText using different elements to learn 
     * to use this library.
     * Creamos un documento PDF con iText usando diferentes elementos para aprender 
     * a usar esta librería.
     * @param pdfNewFile  <code>String</code> 
     *      pdf File we are going to write. 
     *      Fichero pdf en el que vamos a escribir. 
     */
    public static void createPDF(File pdfNewFile) {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Nomina)");
            document.addSubject("Using iText (usando iText)");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Código Xules");
            document.addCreator("Código Xules");
            
            // First page
            // Primera página 
            Chunk chunk = new Chunk("Nominas", chapterFont);
            chunk.setBackground(BaseColor.GRAY);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph("Valor menganito", paragraphFont));
            document.add(chapter);
            document.close();
        } catch (DocumentException documentException) {
        	System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        	}
        
    	}
	}
