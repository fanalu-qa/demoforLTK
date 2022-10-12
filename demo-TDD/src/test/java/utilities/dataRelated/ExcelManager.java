package utilities.dataRelated;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	
	public ArrayList<Map<String, String>> parse(int i) {// i is the natural sheet number
	   	 try {
	   		 // File myfile= new File("src/test/resources/testData/teklabData.xlsx");
	   		 // FileInputStream file =new FileInputStream(myfile);

	   		 // Workbook wb = WorkbookFactory.create(stream);  
	   		 FileInputStream file = new FileInputStream(new File("src/test/resources/testData/teklabData.xlsx"));

	   		 // Create Workbook instance holding reference to .xlsx file
	   		 XSSFWorkbook workbook = new XSSFWorkbook(file);
	   		 // Get first/desired sheet from the workbook, we did a trick to make the sheet
	   		 // at i-1
	   		 XSSFSheet sheet = workbook.getSheetAt(i - 1);

	   		 // create an rowIter to iterate all the rows in this sheet, skipping empty rows
	   		 Iterator<Row> rowIter = sheet.rowIterator();

	   		 // Create the Header Map
	   		 List<String> headers = new ArrayList<String>();

	   		 // we only did the if once, so we could get the header row content
	   		 if (rowIter.hasNext()) {
	   			 // store the current row element to 'row'. Right now it is header row
	   			 Row row = rowIter.next();
	   			 // put cell values in to 'headers' container
	   			 for (Cell cell : row) {
	   				 headers.add(cell.getStringCellValue());
	   				 // for the cell.getStringCellValue(), we could consider using dataFormatter to
	   				 // format it to String
	   				 // headers.add( new DataFormatter().formatCellValue(cell) );

	   			 }
	   		 }

	   		 // this is a content container
	   		 ArrayList<Map<String, String>> contents = new ArrayList<Map<String, String>>();
	   		 // the cursor already move to content row when we start the while loop,
	   		 // so we are storing all content row with header as a pair
	   		 while (rowIter.hasNext()) {
	   			 // store the current row element to 'row'
	   			 Row row = rowIter.next();

	   			 Map<String, String> values = new HashMap<String, String>();

	   			 for (Cell cell : row) {
	   				 // TODO safeguard for header resolving, cell column index
	   				 // might be out of bound of header array
	   				 // cell.setCellType(Cell.CELL_TYPE_STRING);
	   				 values.put(headers.get(cell.getColumnIndex()), cell.getStringCellValue());
	   				 // values.put(headers.get(cell.getColumnIndex()),new
	   				 // DataFormatter.formatCellValue(cell) );
	   			 }

	   			 contents.add(values);
	   		 }

	   		 // add these two new line to close file stream and workbook
	   		 file.close();
	   		 workbook.close();

	   		 return contents;
	   	 } catch (IOException e) {
	   		 throw new RuntimeException(e);
	   	 }
	    }

	    
	    public ArrayList<Map<String, String>> getdata(ArrayList<Map<String, String>> contents, String column,
	   		 String value) {
	   	 ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();

	   	 for (Map<String, String> element : contents) {

	   		 // find the row that is our target	element.get(column)  --> value yahoo1
	   		 if (element.get(column).equals(value)) {
	   			 // once we found it, we put it in the result map
	   			 result.add(element);
	   		 }
	   	 }
	   	 // System.out.println(result.toString());
	   	 return result;
	    }




}
