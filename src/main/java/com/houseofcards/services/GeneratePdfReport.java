package com.houseofcards.services;

import com.houseofcards.entities.generated.Products;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfReport {

	
	
	public static <T> ByteArrayInputStream report(Iterable<T> entities) throws DocumentException {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        
        PdfPTable table = new PdfPTable(entities.getClass().getDeclaredFields().length);
        table.setWidthPercentage(60);
        //table.setWidths(new int[entities.iterator().next().getClass().getDeclaredFields().length]);
        
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        PdfPCell hcell;     
        
		for (int i = 0; i < entities.getClass().getDeclaredFields().length; i++) {
			hcell = new PdfPCell(new Phrase(entities.iterator().next().getClass().getDeclaredFields()[i].getName(), headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
		}
		
		entities.forEach(entity -> {
			PdfPCell cell  = new PdfPCell();
			
			for (int i = 0; i < entity.getClass().getDeclaredFields().length; i++) {
				try {
					PropertyDescriptor pd = new PropertyDescriptor(entity.getClass().getDeclaredFields()[i].getName(), entity.getClass());
					
					
					//entity.getClass().getDeclaredFields()[i].setAccessible(true);
					
					//Object o = pd.getReadMethod().invoke(entity);
					
					System.out.println(pd.getReadMethod().invoke(entity));
					
					
					
					//cell.setPhrase(new Phrase((Phrase.getInstance(pd.getReadMethod().invoke(entity).toString()))));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
				
			}
		});
		
		PdfWriter.getInstance(document, out);
        document.open();
        document.add(table);
        
        document.close();
        
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	
    public static ByteArrayInputStream productReport(Iterable<Products> products) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1, 4, 2, 3});
            
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Inventory", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Price", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (Products product : products) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(product.getPkProductId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(product.getProductName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(product.getInventoryQuantity())));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(product.getPrice())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
