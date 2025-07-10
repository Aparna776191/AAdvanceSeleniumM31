package DDT_Pratice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {

		File file = new File("./src/test/resources/multipage-pdf.pdf");

		PDDocument doc = PDDocument.load(file);
		
//		int pages = doc.getNumberOfPages();
//		System.out.println(pages);//fetches the num of pages in PDF Doc
		
		PDFTextStripper pdfData = new PDFTextStripper();
//		String readData = pdfData.getText(doc);
//		System.out.println(readData);//fetches all the pages Data
	
//		 pdfData.setStartPage(3);
//		 String pageData = pdfData.getText(doc);
//		 System.out.println(pageData);
		 
		 pdfData.setStartPage(4);
		 pdfData.setEndPage(4);
		 String pageData = pdfData.getText(doc);
		 System.out.println(pageData);//fetches particular page data
	}

}
