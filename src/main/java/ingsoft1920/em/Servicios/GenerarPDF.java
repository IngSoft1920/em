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
	
	final static Logger logger = LogManager.getLogger(GenerarPDF.class);
    
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
        	
        	PdfPTable table = new PdfPTable(3);
        	table.setWidthPercentage(60);
        	table.setWidths(new int[] {1,3,3});
        	
        	PdfPCell hcell;
        	hcell = new PdfPCell(new Phrase("Id_Nomina", chapterFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Id_Empleado",chapterFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Id_Incentivo",chapterFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Id_Sueldo",chapterFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Valor",chapterFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	for (NominaModel nomina:listaNominas) {
        		
        		PdfPCell cell;
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_nomina()));
        		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_empleado()));
        		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_incentivo()));
        		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		cell = new PdfPCell(new Phrase(nomina.getId_sueldo()));
        		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        		valor = nomina.getId_sueldo() + nomina.getId_incentivo();
        		cell = new PdfPCell(new Phrase(valor));
        		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        		table.addCell(cell);
        		
        	}
        	
        	PdfWriter.getInstance(document, out);
        	
            document.open();
            document.addTitle("Nomina)");
            document.add(table);  
            document.close();
            
        } catch (DocumentException documentException) {
        	logger.error("Error : {0}", documentException);
        	}
        return new ByteArrayInputStream(out.toByteArray());
        
    	}
	}
