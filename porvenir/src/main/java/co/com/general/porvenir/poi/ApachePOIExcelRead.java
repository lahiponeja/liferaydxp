package co.com.general.porvenir.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.com.general.porvenir.dto.Afiliado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePOIExcelRead {

	 public static List<Afiliado> readExcel(File file) {

	        try {
	        	List<Afiliado> afiliados = new ArrayList<>();
	            FileInputStream excelFile = new FileInputStream(file);
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();
	                while (cellIterator.hasNext()) {
	                	Afiliado afiliado = new Afiliado();
	                	
	                    Cell currentCell = cellIterator.next();
	                    
	                    if (currentCell.getColumnIndex() == 0){
	                    	afiliado.setIdEmpleador(currentCell.getStringCellValue());
	                    }
	                  
	                    if (currentCell.getColumnIndex() == 1){
	                    	afiliado.setIdAfiliado(currentCell.getStringCellValue());
	                    }
	                    
	                    if (currentCell.getColumnIndex() == 2){
	                    	try {
	                    		afiliado.setMontoRetiro(Integer.valueOf(currentCell.getStringCellValue()));
							} catch (Exception e) {
								afiliado.setMontoRetiro(0);
							}
	                    	
	                    }
	                    
	                    if (currentCell.getColumnIndex() == 3){
	                    	afiliado.setNombreAfiliado(currentCell.getStringCellValue());
	                    }
	                    afiliados.add(afiliado);
	                }
	            }
	            return afiliados;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
