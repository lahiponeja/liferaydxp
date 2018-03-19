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
	            	Afiliado afiliado = new Afiliado();
	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();
	                while (cellIterator.hasNext()) {
	                	
	                	
	                    Cell currentCell = cellIterator.next();
	                    
	                    if (currentCell.getColumnIndex() == 0){
	                    	if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                    		afiliado.setIdEmpleador(currentCell.getStringCellValue());
	                        } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        	afiliado.setIdEmpleador(String.valueOf(currentCell.getNumericCellValue()));
	                        }
	                    }
	                  
	                    if (currentCell.getColumnIndex() == 1){
	                    	if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                    		afiliado.setIdAfiliado(currentCell.getStringCellValue());
	                        } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        	afiliado.setIdAfiliado(String.valueOf(currentCell.getNumericCellValue()));
	                        }
	                    }
	                    
	                    if (currentCell.getColumnIndex() == 2){
	                    	try {
	                    		if (currentCell.getCellTypeEnum() == CellType.STRING) {
		                    		afiliado.setMontoRetiro(Double.valueOf(currentCell.getStringCellValue()));
		                        } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
		                        	afiliado.setMontoRetiro(currentCell.getNumericCellValue());
		                        }
							} catch (Exception e) {
								afiliado.setMontoRetiro(0.0);
							}
	                    	
	                    }
	                    
	                    if (currentCell.getColumnIndex() == 3){
	                    	if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                    		afiliado.setNombreAfiliado(currentCell.getStringCellValue());
	                        } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        	afiliado.setNombreAfiliado(String.valueOf(currentCell.getNumericCellValue()));
	                        }
	                    }
	                }
	                afiliados.add(afiliado);
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
