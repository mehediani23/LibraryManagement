

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
public class Hellk {  
  
    public static final String IMAGE = "D:\\Collection_Exercise\\kuet.png";
        public static void genarate_pdf() throws Exception{
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
              LocalDate localDate = LocalDate.now();

                /* Create Connection objects */
                Class.forName ("oracle.jdbc.OracleDriver"); 
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mehedi","kuet1259");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
                ResultSet query_set = stmt.executeQuery("SELECT * FROM NewBook");
                /* Step-2: Initialize PDF documents - logical objects */ 
                //public static final String IMAGE = "resources/images/berlin2013.jpg";
                
                
                Document my_pdf_report = new Document(PageSize.B4);
                PdfWriter writer=PdfWriter.getInstance(my_pdf_report, new FileOutputStream("D:\\Collection_Exercise\\pdf_report_from_sql_using_java.pdf"));
                my_pdf_report.open();   
                Paragraph p= new Paragraph("Available Books", new Font(FontFamily.HELVETICA, 12));
                p.setAlignment(Element.ALIGN_CENTER);
                my_pdf_report.add(p);
                //Paragraph p1= new Paragraph("\n", new Font(FontFamily.HELVETICA, 12));
                //p1.setAlignment(Element.ALIGN_TOP);
                //my_pdf_report.add(p1);
                Paragraph p2= new Paragraph("Date:"+dtf.format(localDate), new Font(FontFamily.HELVETICA, 12));
                p2.setAlignment(Element.TITLE);
                my_pdf_report.add(p2);
                Paragraph p4= new Paragraph("\n", new Font(FontFamily.HELVETICA, 12));
                p4.setAlignment(Element.ALIGN_TOP);
                my_pdf_report.add(p4);
                 /*PdfContentByte canvas = writer.getDirectContentUnder();
                  /Image image = Image.getInstance(IMAGE);
                  image.scaleAbsolute(PageSize.A4.rotate());
                  image.setAbsolutePosition(0, 0);
                  canvas.addImage(image);*/
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(7);
                //create a cell object
                PdfPCell table_cell;
                String Book_ID1 ="BOOk_ID";
                table_cell=new PdfPCell(new Phrase(Book_ID1));
                my_report_table.getFooter();
                my_report_table.addCell(table_cell);
                 String Name1 ="Name";
                table_cell=new PdfPCell(new Phrase(Name1));
                my_report_table.addCell(table_cell);
                String Name2 ="Category";
                table_cell=new PdfPCell(new Phrase(Name2));
                my_report_table.addCell(table_cell);
                 String Name3 ="Author";
                table_cell=new PdfPCell(new Phrase(Name3));
                my_report_table.addCell(table_cell);
                 String Name4 ="publisher";
                table_cell=new PdfPCell(new Phrase(Name4));
                my_report_table.addCell(table_cell);
                String Name5 ="pages";
                table_cell=new PdfPCell(new Phrase(Name5));
                my_report_table.addCell(table_cell);
                String Name6 ="ISBN_NO";
                table_cell=new PdfPCell(new Phrase(Name6));
                my_report_table.addCell(table_cell);
                while (query_set.next()) {                
                                String Book_ID = query_set.getString("BOOk_ID");
                                System.out.println(Book_ID);
                                table_cell=new PdfPCell(new Phrase(Book_ID));
                                my_report_table.addCell(table_cell);
                                String name=query_set.getString("NAME");
                                table_cell=new PdfPCell(new Phrase(name));
                                my_report_table.addCell(table_cell);
                                String category=query_set.getString("category");
                                table_cell=new PdfPCell(new Phrase(category));
                                my_report_table.addCell(table_cell);
                                String Author=query_set.getString("Author");
                                table_cell=new PdfPCell(new Phrase(Author));
                                my_report_table.addCell(table_cell);
                                 String Publisher=query_set.getString("Publisher");
                                table_cell=new PdfPCell(new Phrase(Publisher));
                                my_report_table.addCell(table_cell);
                                 String Pages=query_set.getString("Pages");
                                table_cell=new PdfPCell(new Phrase(Pages));
                                my_report_table.addCell(table_cell);
                                String ISBN_NO=query_set.getString("ISBN_NO");
                                table_cell=new PdfPCell(new Phrase(ISBN_NO));
                                my_report_table.addCell(table_cell);
                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);                       
                my_pdf_report.close();
                
                /* Close all DB related objects */
                
                query_set.close();
                stmt.close(); 
                conn.close();               
                
        }
}