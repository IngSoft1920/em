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
	

	public static ByteArrayInputStream generarPDF(List<NominaModel> listaNominas,float sueldo, DatoEmpleadoBean empleado) {             
  
    	Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String sueldo_base = null;
		String incentivos = null, penalizacion = null;
		Float total=null;

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
        	
        	
        	PdfPTable table1 = new PdfPTable(3);
        	PdfPCell hcell1;
        	hcell1 = new PdfPCell(new Phrase("Trabajador", categoryFont));
        	hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table1.addCell(hcell1);
        	
        	hcell1= new PdfPCell(new Phrase("Telefono",categoryFont));
        	hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table1.addCell(hcell1);
        	
        	hcell1 = new PdfPCell(new Phrase("Categoria",categoryFont));
        	hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table1.addCell(hcell1);
        	
        	table1.addCell(empleado.getNombre());
        	table1.addCell(empleado.getTelefono());
        	table1.addCell(empleado.getNombre_rol());
        	
        	
        	PdfPTable table2 = new PdfPTable(2);
        	PdfPCell hcell2;
        	
        	hcell2 = new PdfPCell(new Phrase("Id Nomina", categoryFont));
        	hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table2.addCell(hcell2);
        	
        	hcell2 = new PdfPCell(new Phrase("Id Empleado",categoryFont));
        	hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        	hcell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table2.addCell(hcell2); 
        	
		 	for (NominaModel nomina:listaNominas) {
		        		
		        		table2.addCell( Integer.toString(nomina.getId_nomina()));
		        		
		        		table2.addCell( Integer.toString(nomina.getId_empleado()));
		 	}
 			
		 	PdfPTable table3 = new PdfPTable(3);
			
			PdfPCell hcell3;
			hcell3 = new PdfPCell(new Phrase("Concepto",categoryFont));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table3.addCell(hcell3);
			
			hcell3 = new PdfPCell(new Phrase("Devengos", categoryFont));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table3.addCell(hcell3);
			
			hcell3= new PdfPCell(new Phrase("Deducciones",categoryFont));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table3.addCell(hcell3);
			

 	
			for (NominaModel nomina:listaNominas) {
				
				sueldo_base=Integer.toString(nomina.getValor());
				incentivos=Integer.toString(nomina.getId_incentivo());
				penalizacion=Float.toString(sueldo);
				total = nomina.getValor()+nomina.getId_incentivo()+sueldo;
				
	        	table3.addCell("Salario Base\n"+ 
	        					"Incentivos\n"+
	        					"Penalizaciones por inclumplimiento de horas de trabajo \n");
				table3.addCell(Integer.toString(nomina.getValor())+ "\n"+
	        					Integer.toString(nomina.getId_incentivo()));
	        	table3.addCell("\n"+
	        					"\n"+
	        					Float.toString(sueldo));
        		
			}
			
       
        	PdfPTable table4 = new PdfPTable(1);
        	
        	PdfPCell hcell4;
        	hcell4 = new PdfPCell(new Phrase("Liquido a recibir", categoryFont));
        	hcell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
        	hcell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	table4.addCell(hcell4);
			PdfPCell Total_dinero = new PdfPCell(new Phrase(Float.toString(total)));  
        	Total_dinero.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table4.addCell(Total_dinero);
            
            
            /*PdfPTable table5 = new PdfPTable(5);
			
			PdfPCell hcell5;
			hcell5 = new PdfPCell(new Phrase("ID_SUELDO", categoryFont));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table5.addCell(hcell5);
			
			hcell5= new PdfPCell(new Phrase("GET_VALOR",categoryFont));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table5.addCell(hcell5);
			
			hcell5 = new PdfPCell(new Phrase("ID_EMPLEADO",categoryFont));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table5.addCell(hcell5);
 	
			hcell5 = new PdfPCell(new Phrase("ID_INCENTIVO",categoryFont));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table5.addCell(hcell5);
			
			hcell5 = new PdfPCell(new Phrase("ID_NOMINA",categoryFont));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table5.addCell(hcell5);
			for (NominaModel nomina:listaNominas) {
				
				table5.addCell(Integer.toString(nomina.getId_sueldo()));
	        	table5.addCell(Integer.toString(nomina.getValor()));
	        	table5.addCell(Integer.toString(nomina.getId_empleado()));
	        	table5.addCell(Integer.toString(nomina.getId_incentivo()));
	        	table5.addCell(Integer.toString(nomina.getId_nomina()));
        		
			}
            */
        		        	
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
