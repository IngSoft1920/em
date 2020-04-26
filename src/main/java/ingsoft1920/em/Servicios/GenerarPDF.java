package ingsoft1920.em.Servicios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.BaseColor;
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

import ingsoft1920.em.Beans.DatoEmpleadoBean;
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
	

	public static ByteArrayInputStream generarPDF(List<NominaModel> listaNominas,float sueldo) {             
  
    	Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	
        	Paragraph info = new Paragraph(empleado.getNombre() +
        									" Perez"  + "\n" +
        									empleado.getCorreo() + "\n" +empleado.getTelefono()+"\n\n", 
        									FontFactory.getFont("arial", 
        											14,
        											Font.BOLD,
        											BaseColor.DARK_GRAY)
        			);
        	info.setAlignment(Element.ALIGN_RIGHT);
        	
        	
        	
        	PdfPTable table = new PdfPTable(2);
        	
        	PdfPCell hcell;
        	hcell = new PdfPCell(new Phrase("Empresa", categoryFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Domicilio",categoryFont));
        	hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table.addCell(hcell);
        	
        	table.addCell("Hotel Debod");
        	table.addCell("C/ Gran Via 64");
        	
        	
        	hcell = new PdfPCell(new Phrase("Valor",categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
        	
        	hcell = new PdfPCell(new Phrase("Sueldo final",categoryFont));
        	hcell.setVerticalAlignment(Element.ALIGN_CENTER);
        	table.addCell(hcell);
 	for (NominaModel nomina:listaNominas) {
        		
        		table.addCell( Integer.toString(nomina.getId_nomina()));
        		
        		table.addCell( Integer.toString(nomina.getId_empleado()));
        		
        		table.addCell( Integer.toString(nomina.getId_incentivo()));
        		
        		table.addCell(Integer.toString(nomina.getValor()));

        		table.addCell(Float.toString(sueldo));
 	}
       
        	PdfPTable table4 = new PdfPTable(1);
        	
        	PdfPCell hcell4;
        	hcell4 = new PdfPCell(new Phrase("Liquido a recibir", categoryFont));
        	hcell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
        	hcell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table4.addCell(hcell4);
        	PdfPCell Total_dinero = new PdfPCell(new Phrase("1000"));  
        	Total_dinero.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table4.addCell(Total_dinero);
        		        	
        	PdfWriter.getInstance(document, out);
        	
            document.open(); 
         // First page
         // Primera página 
         Chunk chunk = new Chunk("Nomina", chapterFont);
         chunk.setBackground(BaseColor.CYAN);
        
         //Añadimos una tabla  
         	document.add(info);
            document.add(table); 
            document.add(table1);
            document.add(table2);
            document.add(table3);
            document.add(table4);
            
            document.close();
            
        } catch (DocumentException documentException) {
        	logger.error("Error : {0}", documentException);
        	}
        return new ByteArrayInputStream(out.toByteArray());
        
    	}
	}
