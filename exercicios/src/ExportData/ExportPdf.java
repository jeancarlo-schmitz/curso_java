package ExportData;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportPdf {
	public static final String RESULT = "C:\\Users\\jean.schmitz\\Desktop\\curso-java\\example.pdf";

	public static void main(String[] args) throws DocumentException, IOException {
	         Document document = new Document();
	         PdfWriter.getInstance(document, new FileOutputStream(RESULT));
	         document.open();
	            Font BOLD_UNDERLINED = new
	                    Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
	            Font NORMAL = new Font(FontFamily.TIMES_ROMAN, 12);
	                  
	            Paragraph p = new Paragraph();
	            p.setIndentationLeft(20);
	            p.add(new Phrase("Titulo: ", BOLD_UNDERLINED));
	            p.add("Teste de Titulo");
	            p.setAlignment(Element.ALIGN_JUSTIFIED);

	            p.add(" ");
	            document.add(p);
	            p = new Paragraph();
	            p.setExtraParagraphSpace(40);
	            p.setIndentationLeft(50);
	            p.add(new Phrase("Titulo 2: ", BOLD_UNDERLINED));
	            p.add("Teste de Titulo 2");

	            document.add(p);
	         document.close();
	}
}
