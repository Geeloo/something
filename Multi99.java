package multi99; 


public class Multi99 { 

 private static StringBuffer buffer = new StringBuffer(); 

 private static final int MAX_LINES = 9; 

 private static final int MAX_COLUMNS = 9; 

 private static final int START = 1; 

 public static void main(String[] args) { 

  prt_line(START,MAX_LINES); 

 } 


 private static void prt_line(int currentLine ,int lines){ 

  if(currentLine > lines) 

   return; 

  prt_column(START,currentLine); 

  currentLine += 1; 

  prt_line(currentLine , MAX_LINES); 

 } 

 private static void prt_column(int currentColumn , int columns){ 

  if(currentColumn > columns){ 

   System.out.println(""); 

   return; 

  } 


  System.out.print(buffer.append(currentColumn) 

          .append("*") 

          .append(columns) 

          .append("=") 

          .append(currentColumn * columns) 

          .append("\t")); 

  buffer.delete(0, buffer.length()); 

  currentColumn += 1; 

  prt_column(currentColumn,columns); 

 } 


} 

