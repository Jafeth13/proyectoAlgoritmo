/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.javaws.Main;
import domain.Career;
import domain.Course;
import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import static java.awt.font.TextHitInfo.leading;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


/**
 *
 * @author Matamoros Cordero
 */
public class Utility {

    public static int random() {
        return 1 + (int) Math.floor(Math.random() * 99);
    }

    public static int random(int bound) {
        //return 1+random.nextInt(bound);
        return 1 + (int) Math.floor(Math.random() * bound);
    }

    public static String format(double value) {
        return new DecimalFormat("###,###,###,###.##")
                .format(value);
    }

    public static String $format(double value) {
        return new DecimalFormat("$###,###,###,###.##")
                .format(value);
    }

    public static String perFormat(double value) {
        //#,##0.00 '%'
        return new DecimalFormat("#,##0.00'%'")
                .format(value);
    }

    public static boolean equals(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "integer":
                Integer x = (Integer) a;
                Integer y = (Integer) b;
                return x.equals(y);
            case "string":
                String s1 = (String) a;
                String s2 = (String) b;
                //return s1.compareTo(s2)==0; //OPCION 1
                return s1.equalsIgnoreCase(s2); //OPCION 2
           
              case "Career":
                Career xl = (Career) a;
                Career yl = (Career) b;
                return (xl.getId()==(yl.getId()));
            //OPCION 2
            case "Course":
                Course s5 = (Course) a;
                Course s6 = (Course) b;

                return (s5.getId().equals(s6.getId()) && s5.getName().equalsIgnoreCase(s6.getName()));
        }
        return false; //en cualquier otro caso
    }

    private static String instanceOf(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return "integer";
        }
        if (a instanceof String && b instanceof String) {
            return "string";
        }
        if (a instanceof Student && b instanceof Student) {
            return "Student";
        }
        if (a instanceof Course && b instanceof Course) {
            return "Course";
        }
        if (a instanceof Career && b instanceof Career) {
            return "Career";
        }
        return "unknown"; //desconocido
    }

    public static boolean greaterT(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "integer":
                Integer x = (Integer) a;
                Integer y = (Integer) b;
                return x > y;
            case "string":
                String s1 = (String) a;
                String s2 = (String) b;
                return s1.compareTo(s2) > 0; //OPCION 1

         
            case "Course":
                Course s9 = (Course) a;
                Course s10 = (Course) b;

                return s9.getName().compareTo(s10.getName()) > 0;

        }
        return false; //en cualquier otro caso
    }

    public static boolean leesT(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "integer":
                Integer x = (Integer) a;
                Integer y = (Integer) b;
                return x < y;
            case "string":
                String s1 = (String) a;
                String s2 = (String) b;
                return s1.compareTo(s2) < 0; //OPCION 1
//               return s1.equalsIgnoreCase(s2); //OPCION 2
            case "Student":
                String s3 = (String) a;
                String s4 = (String) b;
                return s3.equalsIgnoreCase(s4); //OPCION 2
            case "Course":
                String s6 = (String) a;
                String s7 = (String) b;
                ;
                return s6.equalsIgnoreCase(s7);
        }
        return false; //en cualquier otro caso
    }
    public static void exportToPDF(Object show,String name){
        System.out.println("SOY SHOW: \n"+show);
         try  {
             
             PDDocument documento = new PDDocument();
             PDPage pagina = new PDPage(PDRectangle.A6);
             documento.addPage(pagina);
             PDPageContentStream contenido = new PDPageContentStream(documento, pagina);
             
       

             
             contenido.beginText();
             contenido.setFont(PDType1Font.TIMES_BOLD, 12);
             contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
             contenido.showText(show.toString());

             contenido.endText();
             
             contenido.close();
             
            documento.save(name);
        } catch (IOException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
