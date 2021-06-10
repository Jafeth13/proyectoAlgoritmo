/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.javaws.Main;
import domain.Career;
import domain.Course;
import domain.DeEnrollment;
import domain.Enrollment;
import domain.ListException;
import domain.Security;
import domain.SinglyLinkedList;
import domain.Student;
import domain.TimeTable;
import static java.awt.font.TextHitInfo.leading;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
            case "Student":
                Student s5 = (Student) a;
                Student s6 = (Student) b;

                return s5.getStudentID().equals(s6.getStudentID());
                 case "Course":
                Course s8 = (Course) a;
                Course s9 = (Course) b;

                return s8.getId().equals(s9.getId());
                
             case "Security":
                Security secure = (Security) a;
                Security secure2 = (Security) b;

                return secure.getUser().equals(secure2.getUser()) && secure.getPassword().equals(secure2.getPassword());
                
                 case "TimeTable":
                     TimeTable to = (TimeTable) a;
                TimeTable ti = (TimeTable) b;

                return ti.getSchedule1().equalsIgnoreCase(to.getSchedule1())||ti.getSchedule2().equalsIgnoreCase(to.getSchedule2());
                 
                     case "Enrollment":
                Enrollment s81 = (Enrollment) a;
                Enrollment s91 = (Enrollment) b;

                return s81.getId()==(s91.getId());
                      case "DeEnrollment":
                Enrollment s812 = (Enrollment) a;
                DeEnrollment s932 = (DeEnrollment) b;

                return s812.getId()==(s932.getId());
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
        if (a instanceof Security && b instanceof Security) {
            return "Security";
        }
        if (a instanceof Security && b instanceof Security) {
            return "TimeTable";
        }
        if (a instanceof Enrollment && b instanceof Enrollment) {
            return "Enrollment";
        }
        if (a instanceof DeEnrollment && b instanceof Enrollment) {
            return "DeEnrollment";
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
 public static void file(Object b,String name) throws IOException{
     FileWriter file=new FileWriter(name+".txt");
     file.write(b+"\n");
     file.close();
 }
 
 public static void ReadFile(String string){
 
 File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (string+".txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }

     
 }
 
}
