package ingsoft1920.em.Servicios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ingsoft1920.em.DAO.NominaDAO;
import ingsoft1920.em.Model.NominaModel;

public class GenerarPDF {
	
	private static final Logger logger = LogManager.getLogger(GenerarPDF.class);
    
	private static int valor=0;
	//tipos de fuente
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	

	public static ByteArrayInputStream generarPDF(List<NominaModel> listaNominas) {             
  
    	Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	
        	PdfPTable table = new PdfPTable(5);
        	table.setWidthPercentage(110);
        	table.setWidths(new int[] {40,40,40,40,40});
        	
        	PdfPCell hcell;
        	hcell = new PdfPCell(new Phrase("Id_Nomina", categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Id_Empleado",categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Id_Incentivo",categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Id_Sueldo",categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Valor",categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
 	for (NominaModel nomina:listaNominas) {
        		
        		PdfPCell cell;
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_nomina()));
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_empleado()));
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_incentivo()));
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_sueldo()));
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		valor = nomina.getId_sueldo() + nomina.getId_incentivo();
        		cell = new PdfPCell(new Phrase(valor));       		
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
 	}
       
        		        	
        	PdfWriter.getInstance(document, out);
        	
            document.open(); 
            document.addTitle("Nomina");
         // First page
         // Primera página 
         Chunk chunk = new Chunk("Nomina", chapterFont);
         chunk.setBackground(BaseColor.CYAN);
         // Let's create de first Chapter (Creemos el primer capítulo)
         Chapter chapter = new Chapter(new Paragraph(chunk), 1);
         chapter.setNumberDepth(0);
         chapter.add(new Paragraph("esto es una prueba", paragraphFont));
         document.add(chapter);  
         //Añadimos una tabla  
            document.add(table);        
            document.close();
            
        } catch (DocumentException documentException) {
        	logger.error("Error : {0}", documentException);
        	}
        return new ByteArrayInputStream(out.toByteArray());
        
    	}
	}
