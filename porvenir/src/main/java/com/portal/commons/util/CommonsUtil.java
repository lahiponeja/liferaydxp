package com.portal.commons.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Clase utilitaria para uso generico de DPW.
 * 
 * @author luis.hernandez
 */
public class CommonsUtil {

	/*
	 * CONSTANTES
	 */
	public static final String BLANK = "";
	public static final String MONEDA = "$";
	public static final String FORMATO_FECHA = "dd-MM-yyyy'T'HH-mm-ss";
	public static final String FORMATO_NUMBER = "#,###";
	public static final String PORCENTAJE = "%";
	
	private CommonsUtil() {

	}
	
	/*
	 * UTILIZATARIOS PARA FORMATEO DE DATOS NUMERICOS 
	 */

	/**
	 * Formatea valores tipo float a String sin numero fraccionarios.
	 * 
	 * @param var Valor tipo float
	 * @return valor formateado a string
	 */
	public static String formatMoneyFloat(float var) {

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(true);
		return df.format(var);

	}
	
	/**
	 * Formatea los datos de tipo BigInteger en "200.000,00"
	 * 
	 * @param var
	 * @return
	 */
	public static String formatValueFloat(float var, boolean symbolMoney) {
		try {
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(0);
			df.setMinimumFractionDigits(0);
			df.setGroupingUsed(true);
			if (symbolMoney){
				return CommonsUtil.addSymbolMoney(df.format(var));
			}else{
				return df.format(var);
			}
		} catch (Exception e) {
			return BLANK;
		}
	}
	
	/**
	 * Formatea los datos de tipo Double en "200.000,00"
	 * @param var
	 * @param symbolMoney
	 * @return
	 */
	public static String formatValueDouble(Double var, boolean symbolMoney) {
		try {
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(0);
			df.setMinimumFractionDigits(0);
			df.setGroupingUsed(true);
			if (symbolMoney){
				return CommonsUtil.addSymbolMoney(df.format(var));
			}else{
				return df.format(var);
			}
		} catch (Exception e) {
			return BLANK;
		}
	}
	
	/**
	 * Formatea los datos de tipo String en "200.000,00"
	 * @param var
	 * @param symbolMoney
	 * @return
	 */
	public static String formatValueString(String var, boolean symbolMoney) {
		try {
			Double varDouble = Double.valueOf(var);
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(0);
			df.setMinimumFractionDigits(0);
			df.setGroupingUsed(true);
			if (symbolMoney){
				return CommonsUtil.addSymbolMoney(df.format(varDouble));
			}else{
				return df.format(varDouble);
			}
		} catch (Exception e) {
			return var;
		}
	}
	
	public static String formatBigInteger(BigDecimal var) {

		BigDecimal value = var.setScale(2, BigDecimal.ROUND_DOWN);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(true);
		return df.format(value);

	}
	
	/**
	 * Convierte un valor double a String sin numeros fraccionarios.
	 * 
	 * @param var Valor tipo double
	 * @return valor convertido a string 
	 */
	public static String formatMoneyDouble(Double var) {

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(true);
		return df.format(var);

	}
	
	/**
	 * Da formato a valores tipo bigdecimal.
	 * 
	 * @param var valor bigdecimal a formatear
	 * @return String del valor recibido
	 */
	public static String formatBigDecimal(BigDecimal var) {

		BigDecimal value = var.setScale(2, BigDecimal.ROUND_DOWN);		
		DecimalFormat df = new DecimalFormat(FORMATO_NUMBER, getDecimalFormatSymbols());
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(true);
		return df.format(value);

	}
	
	/*
	 * UTILIZATARIOS PARA FECHAS 
	 */
	/**
	 * Define del fomato para los decimales, se separa con coma los numeros decimales.
	 * @return Decimal format symbol adaptado.
	 */
	public static DecimalFormatSymbols getDecimalFormatSymbols(){
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(new Locale("en", "US"));
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.'); 
		return otherSymbols;
	}
	
	
	/**
	 * Obtiene la fecha actual en formato XMLGregorian para consumir los servicios.
	 * 
	 * @return fecha actual
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getDateGregorianCalendar() throws DatatypeConfigurationException {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(new Date());
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

	}
	
	/**
	 * Formatea una fecha dada con el formato "yyyy-MM-dd"
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar getDateGregorianCalendar(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			String dateString = sdf.format(date);
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString);			
		} catch (DatatypeConfigurationException e1) {
			return null;
		}
		return xmlGregorianCalendar;
	}

	/**
	 * Transforma de Gregorian calendar a String, metodo utilizado para la invocaion de servicios web.
	 *  
	 * @param xmlGregorianCalendar Fecha en formato gregorian
	 * @return Fecha convertida a String
	 */
	public static String stringToCalendar(Calendar calendar) {
		if (calendar != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA);
			formatter.setTimeZone(calendar.getTimeZone());
			return formatter.format(calendar.getTime());
		} else {
			return BLANK;
		}
	}
	
	/**
	 * Formatea una fecha tipo date en el formato 01 MAR 2015 9:00pm
	 * @param date
	 * @return String, fecha formateada
	 */
	public static String stringToCalendar(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		return sdf.format(date);
	}
	
	/*
	 * UTILIZATARIOS PARA MANEJO DE STRING
	 */
	
	/**
	 * Recibe un valor String y retorna el mismo valor concatenado con el simbolo pesos.
	 * 
	 * @param var Valor a formatear
	 * @return Valor foemateado
	 */
	public static String addSymbolMoney(String var) {
		return MONEDA.concat(var);
	}
	
	/**
	 * Recibe un valor String y retorna el mismo valor concatenado con el simbolo porcentaje.
	 * @param var
	 * @return
	 */
	public static String addSymbolPercent(String var){
		return var.concat(PORCENTAJE);
	}
	
	/*
	 * UTILIZATARIOS PARA MANEJO DE DATOS NUMERICOS DECIMAL, ENTERO
	 */
	
	/**
	 * Retorna el valor decimal de un dato tipo String
	 * @param value
	 * @return
	 */
	public static String getDecimal(String value){
		String [] valores = value.split(",");
		if (valores.length >1){
			return valores[1];
		}
		return BLANK;
	}
	
	/**
	 * Retorna un valor entero desde un dato tipo String
	 * @param value
	 * @return
	 */
	public static String getEntero(String value){
		Double valueEntero = null;
		try {
			valueEntero = Double.valueOf(value);
		} catch (Exception e) {
			return BLANK;
		}
		return String.valueOf(valueEntero.intValue());
	}
	
	/*
	 * UTILIZATARIOS VALIDACION DE HEADER DE LOS SERVICIOS
	 */
	
	/**
	 * Metodo para validar el header de la respuesta, donde se valida si hay error de negocio.
	 * 
	 * @param code
	 *            Codigo de error enviado en la cabecera de la respuesta del
	 *            servicio web
	 * @return true si el servicio web retorna error, false si no hay error
	 */
	public static boolean validateHeaderError(String code) {
		if (!"0".equals(code)) {
			return true;
		}
		return false;
	}

}