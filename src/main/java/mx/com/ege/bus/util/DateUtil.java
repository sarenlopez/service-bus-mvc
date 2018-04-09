package mx.com.ege.bus.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

/**
 *
 * @author rrubio <rrubio at procesar.com>
 * @version 1.0
 */
public class DateUtil {

    /**
     * Constante que define el patron estandar de presentacion de fechas
     */
    private static final String PATRON_FECHA_DEFAULT = "dd/MM/yyyy 00:00:00.0";

    /**
     *
     */
    public static final long ONE_DAY = 24 * 60 * 60 * 1000L;

    /**
     *
     */
    public static final long ONE_HOUR = 60 * 60 * 1000L;

    /**
     *
     */
    public static final long ONE_MINUTE = 60 * 1000L;

    /**
     *
     */
    public static final long ONE_SECOND = 1000L;

    /**
     *
     */
    public static final String formatoValido = "yyyyMMdd";

    /**
     *
     */
    public static final String FECHA_INVALIDA = "Fecha invalida.";

    /**
     * Obtiene la fecha actual
     *
     * @return Date
     */
    public static final Date getFechaActual() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * Verifica si es un dia habil
     *
     * @param date
     * @return Boolean
     */
    public static final Boolean isDiaHabil(Date date) {
        return !isSabado(date) && !isDomingo(date);
    }

    /**
     * Valida si la fecha es sabado
     *
     * @param date
     * @return
     */
    public static final Boolean isSabado(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    }

    /**
     * Verifica si la fecha es domingo
     *
     * @param date
     * @return
     */
    public static final Boolean isDomingo(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }



    /**
     * Obtiene la fecha a partir de los parametros proporcionados
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static final Date getDate(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar(year, intToCalendarMonth(month), day);
        return calendar.getTime();
    }

    /**
     * Metodo que obtiene la hora que esta representando una fecha
     *
     * @param date Fecha
     * @return Entero con la hora
     */
    public static int getHour(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Metodo que obtiene el minuto que esta representando una fecha
     *
     * @param date Fecha
     * @return Entero con el minuto
     */
    public static int getMinute(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * Verifica si la fecha es valida con el formato yyyyMMdd
     *
     * @param strFecha
     * @return
     * @throws ParseException
     */
    public static final Boolean isValida(String strFecha) throws ParseException {
        Date fecha = DateUtils.parseDate(strFecha, new String[]{formatoValido});
        return fecha != null;
    }

    /**
     * obtiene la fecha en un formato dado
     *
     * @param pattern
     * @return
     */
    public static String formatCurrentDate(String pattern) {
        FastDateFormat formatter = FastDateFormat.getInstance(pattern);
        return formatter.format(getFechaActual());
    }

    /**
     * obtiene la fecha a partir del patron y la fecha dada
     *
     * @param pattern
     * @param fecha
     * @return
     */
    public static String formatDate(String pattern, Date fecha) {
        FastDateFormat formatter = FastDateFormat.getInstance(pattern);
        return formatter.format(fecha);
    }

    /**
     * Convertidor de fechas a un patron dado
     *
     * @param dt La fecha a convertir
     * @param pattern El patron de conversion (por ejemplo 'dd-MM-yyyy')
     *
     * @return La cadena transformada
     */
    public static String convertDateToString(java.util.Date dt, String pattern) {
        String formattedString = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formattedString = formatter.format(dt);
        return formattedString;
    }

    /**
     * Inicializar la hora ,minutos o segundos en ceros
     *
     * @param fecha
     * @return Fecha con la hora,minuto y segundos en ceros
     * @throws ParseException
     */
    public static Date resetHorario(Date fecha) throws ParseException {
        return convertDateToDate(fecha, PATRON_FECHA_DEFAULT);
    }

    /**
     * Convertidor de fechas a un patron dado esto sirve para inicializar
     * horas,minutos o segundos en ceros
     *
     * @param dt - La fecha a convertir
     * @param patron - El patron de conversion (por ejemplo 'dd-MM-yyyy')
     *
     * @return Date
     * @throws ParseException
     */
    public static Date convertDateToDate(Date dt, String patron) throws ParseException {
        String fecha = convertDateToString(dt, patron);
        return convertStringToDate(fecha, patron);
    }

    /**
     * Convertidor de cadenas que siguen un patr�n dado a fechas
     *
     * @param stringDate La cadena a transformar
     * @param pattern El formato de la fecha a convertir por ejemplo
     * convertStringToDate('29/10/1976',dd/MM/yyyy')
     * convertStringToDate('1976-10-29',yyyy-MM-dd')
     * @return java.util.Date
     * @throws ParseException
     */
    public static java.util.Date convertStringToDate(String stringDate, String pattern) throws ParseException {
        java.util.Date date = null;

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setLenient(true);
        date = formatter.parse(stringDate);

        return date;
    }

    /**
     * Agrega el nuevo valor a la fecha porporcionada
     *
     * @param fecha - la fecha a modificar
     * @param property- Propiedad de calendar
     * Calendar.Calendar.MONTH,Calendar.YEAR etc
     * @param valor - numero a agregar valor
     * @return Date
     */
    public static Date addValueProperty(Date fecha, int property, int valor) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(property, /*calendar.get(property)+*/ valor);
        return calendar.getTime();
    }

    /**
     * Asignamos el nuevo valor a la fecha porporcionada
     *
     * @param fecha - la fecha a modificar
     * @param property- Propiedad de calendar
     * Calendar.Calendar.MONTH,Calendar.YEAR etc
     * @param valor - numero a agregar valor
     * @return Date
     */
    public static Date setValueProperty(Date fecha, int property, int valor) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(property, valor);
        return calendar.getTime();
    }

    /**
     * Metodo que devuelve un objeto fecha a partir de una cadena con alguno de
     * los siguientes formatos:<br>
     * 99.99.9999<br>
     * 99/99/9999<br>
     * 99-99-9999<br>
     * 99,99,9999<br>
     * 99 99 9999<br>
     *
     * @param text Cadena con la fecha a convertir
     * @return Date
     * @throws NumberFormatException
     */
    public static final Date getDate(String text) throws NumberFormatException {
        Date date = null;
        if (text != null && text.trim().length() > 0) {
            text = text.trim();
            text = text.replaceAll("\\.", "");
            text = text.replaceAll("/", "");
            text = text.replaceAll("-", "");
            text = text.replaceAll(",", "");
            text = text.replaceAll(" ", "");
            try {
                Integer.parseInt(text);
                if (text.length() == 8) {
                    int day = Integer.parseInt(text.substring(0, 2));
                    int month = Integer.parseInt(text.substring(2, 4));
                    int year = Integer.parseInt(text.substring(4));
                    date = getDate(year, month, day);
                } else {
                    throw new NumberFormatException("Fecha invalida.");
                }
            } catch (NumberFormatException nfe) {
                // throw new NumberFormatException("Fecha invalida.");
                throw nfe;
            }
        }
        return date;
    }

    /**
     * Metodo que devuelve un objeto fecha a partir de una cadena con alguno de
     * los siguientes formatos:<br>
     * 9999.99.99<br> 9999/99/99<br> 9999-99-99<br> 9999,99,99<br> 9999 99
     * 99<br>
     *
     * @param text Cadena con la fecha a convertir
     * @return Date
     * @throws NumberFormatException
     */
    public static Date getDateInv(String text) throws NumberFormatException {

        Date date = null;
        String strTemp = text;
        if (StringUtils.isNotBlank(strTemp)) {
            strTemp = StringUtils.trim(strTemp);
            strTemp = StringUtils.replace(strTemp, "\\.", "");
            strTemp = StringUtils.replace(strTemp, "/", "");
            strTemp = StringUtils.replace(strTemp, "-", "");
            strTemp = StringUtils.replace(strTemp, ",", "");
            strTemp = StringUtils.replace(strTemp, " ", "");
            try {
                Integer.parseInt(strTemp);
                if (strTemp.length() == 8) {
                    int year = Integer.parseInt(strTemp.substring(0, 4));
                    int month = Integer.parseInt(strTemp.substring(4, 6));
                    int day = Integer.parseInt(strTemp.substring(6));
                    date = getDate(year, month, day);
                } else {
                    throw new NumberFormatException(FECHA_INVALIDA);
                }
            } catch (NumberFormatException nfe) {
                throw new NumberFormatException(FECHA_INVALIDA + nfe);
            }
        }
        return date;
    }

    /**
     * Metodo que devuelve un objeto fecha a partir de una cadena con alguno de
     * los siguientes formatos:<br>
     * 99.99.99<br> 99/99/99<br> 99-99-99<br> 99,99,99<br> 99 99 99<br>
     *
     * @param text Cadena con la fecha a convertir
     * @return Date
     * @throws NumberFormatException
     */
    public static Date getDateInv6(String text) throws NumberFormatException {

        Date date = null;
        String strTemp = text;
        if (StringUtils.isNotBlank(strTemp)) {
            strTemp = StringUtils.trim(strTemp);
            strTemp = StringUtils.replace(strTemp, "\\.", "");
            strTemp = StringUtils.replace(strTemp, "/", "");
            strTemp = StringUtils.replace(strTemp, "-", "");
            strTemp = StringUtils.replace(strTemp, ",", "");
            strTemp = StringUtils.replace(strTemp, " ", "");
            try {
                Integer.parseInt(strTemp);
                if (strTemp.length() == 6) {
                    int year = Integer.parseInt(strTemp.substring(0, 2));
                    int month = Integer.parseInt(strTemp.substring(2, 4));
                    int day = Integer.parseInt(strTemp.substring(4));
                    date = getDate(year, month, day);
                } else {
                    throw new NumberFormatException(FECHA_INVALIDA);
                }
            } catch (NumberFormatException nfe) {
                throw new NumberFormatException(FECHA_INVALIDA + nfe);
            }
        }
        return date;
    }

    /**
     * Metodo que devuelve un String con la fecha formateada dd.mm.yyyy
     *
     * @param date
     * @return String con la fecha formateada
     */
    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        return getDayAsString(date) + "." + getMonthNumberAsString(date) + "." + getYear(date);
    }

    /**
     * Metodo que regresa una cadena que contiene el dia que esta representando
     * una fecha
     *
     * @param date Fecha
     * @return String con el dia, ejemplo "05" para el dia 5
     */
    public static String getDayAsString(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day < 10) {
            return "0" + day;
        }
        return "" + day;
    }

    /**
     * Metodo que regresa una cadena que contiene el mes que esta representando
     * una fecha
     *
     * @param date Fecha
     * @return String con el mes, ejemplo "05" para mayo
     */
    public static String getMonthNumberAsString(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int month = calendarMonthToInt(cal.get(Calendar.MONTH));
        if (month < 10) {
            return "0" + month;
        }
        return "" + month;
    }

    /**
     * Metodo que obtiene el año que esta representando una fecha
     *
     * @param date Fecha
     * @return Entero con el año
     */
    public static int getYear(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * Metodo que obtiene el mes que esta representando una fecha
     *
     * @param date Fecha
     * @return Entero con el mes
     */
    public static int getMonth(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return calendarMonthToInt(cal.get(Calendar.MONTH));
    }

    /**
     * Metodo que obtiene el dia que esta representando una fecha
     *
     * @param date Fecha
     * @return Entero con el dia
     */
    public static int getDay(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Metodo que regresa el entero que representa el mes. Para el objeto
     * java.util.Date el mes empieza en cero
     *
     * @param calendarMonth
     * @return Entero que representa el mes
     */
    private static int calendarMonthToInt(int calendarMonth) {
        if (calendarMonth >= 0 && calendarMonth <= 12) {
            return calendarMonth + 1;
        } else {
            return 1;
        }
    }

    /**
     * Metodo que compara dos fechas, hasta el nivel de dia
     *
     * @param first Primera fecha
     * @param second Segunda fecha
     * @return <br> true - si la primera fecha es menor o igual a la segunda<br>
     * false - en caso contrario
     */
    public static boolean isInSameDayOrBefore(Date first, Date second) {

        boolean flag = false;
        Calendar firstCal = new GregorianCalendar();
        Calendar secondCal = new GregorianCalendar();
        firstCal.setTime(first);
        secondCal.setTime(second);

        if (first.before(second)) {
            flag = true;
        } else if (firstCal.get(Calendar.YEAR) == secondCal.get(Calendar.YEAR)
                && firstCal.get(Calendar.MONTH) == secondCal.get(Calendar.MONTH)
                && firstCal.get(Calendar.DAY_OF_MONTH) == secondCal.get(Calendar.DAY_OF_MONTH)) {
            flag = true;
        }
        return flag;
    }

    /**
     * Metodo que compara dos fechas, hasta el nivel de dia
     *
     * @param first Primera fecha
     * @param second Segunda fecha
     * @return <br>true - si la primera fecha es igual a la segunda
     * fecha<br>false - en caso contrario
     */
    public static boolean isInSameDay(Date first, Date second) {
        boolean flag = false;
        Calendar firstCal = new GregorianCalendar();
        Calendar secondCal = new GregorianCalendar();
        firstCal.setTime(first);
        secondCal.setTime(second);

        if (firstCal.get(Calendar.YEAR) == secondCal.get(Calendar.YEAR)
                && firstCal.get(Calendar.MONTH) == secondCal.get(Calendar.MONTH)
                && firstCal.get(Calendar.DAY_OF_MONTH) == secondCal.get(Calendar.DAY_OF_MONTH)) {
            flag = true;
        }
        return flag;
    }

    /**
     * /** Metodo que regresa el entero que representa el mes. Para el objeto
     * java.util.Date el mes empieza en cero
     *
     * @param month Mes
     * @return Entero que representa el mes
     */
    private static int intToCalendarMonth(int month) {

        if (month > 0 && month < 7) {
            return validaMesesIniciales(month);
        } else if (month > 6 && month <= 12) {
            return validaMesesFinales(month);
        } else {
            return Calendar.JANUARY;
        }
    }

    /**
     * Metodo que realiza la validacion de los ultimos meses del año
     *
     * @param month
     * @return
     */
    private static int validaMesesFinales(int month) {

        int mes = 0;
        if (month == 7) {
            mes = Calendar.JULY;
        } else if (month == 8) {
            mes = Calendar.AUGUST;
        } else if (month == 9) {
            mes = Calendar.SEPTEMBER;
        } else if (month == 10) {
            mes = Calendar.OCTOBER;
        } else if (month == 11) {
            mes = Calendar.NOVEMBER;
        } else if (month == 12) {
            mes = Calendar.DECEMBER;
        }
        return mes;
    }

    /**
     * Metodo para relizar la validacion de los primeros meses del año
     *
     * @param month
     * @return
     */
    private static int validaMesesIniciales(int month) {

        int mes = 0;
        if (month == 1) {
            mes = Calendar.JANUARY;
        } else if (month == 2) {
            mes = Calendar.FEBRUARY;
        } else if (month == 3) {
            mes = Calendar.MARCH;
        } else if (month == 4) {
            mes = Calendar.APRIL;
        } else if (month == 5) {
            mes = Calendar.MAY;
        } else if (month == 6) {
            mes = Calendar.JUNE;
        }
        return mes;
    }

    /**
     * Metodo para adicionar un cierto numero de dias a una fecha
     *
     * @param target fecha origen
     * @param days numero de dias a agregar
     * @return Fecha modificada
     */
    public static final Date addDays(Date target, int days) {
        return addSubstractDays(target, days, true);
    }

    /**
     * Metodo que devuelve una fecha adicionandole o restandole un numero de
     * dias
     *
     * @param target Fecha a la que se le 'moveran' los dias
     * @param days Numero de dias a sumar o restar
     * @param isAdd <br>true - suma days 'dias'<br>false - resta days 'dias'
     * @return Fecha modificada
     */
    public static final Date addSubstractDays(Date target, int days, boolean isAdd) {
        long msPerDay = 1000 * 60 * 60 * 24;
        long msTarget = target.getTime();
        long msSum = 0;
        if (isAdd) {
            msSum = msTarget + (msPerDay * days);
        } else {
            msSum = msTarget - (msPerDay * days);
        }
        Date result = new Date();
        result.setTime(msSum);
        return result;
    }

    /**
     * <p>
     * Gets a flag indicating whether a date is a weekend (i.e. Saturday or
     * Sunday).
     * </p>
     *
     * @param date the date to be checked.
     *
     * @return <code>true</code> if <code>date</code> is a weekend;
     * <code>false</code> otherwise.
     */
    public static boolean isWeekEnd(Date date) {
        validateNotNull(date, "date");
        Calendar calendar = stripTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        return (day == Calendar.SUNDAY) || (day == Calendar.SATURDAY);
    }

    /**
     * <p>
     * Validates the value of a variable with type <code>Object</code>. The
     * value cannot be <code>null</code>.
     * </p>
     *
     * @param value value of the variable.
     * @param name name of the variable.
     *
     * @throws NullPointerException if <code>value</code> is <code>null</code>.
     */
    public static void validateNotNull(Object value, String name) {
        if (value == null) {
            throw new NumberFormatException(name + " cannot be null.");
        }
    }

    /**
     * <p>
     * Validates the value of a string variable. The value cannot be empty
     * string, but may be <code>null</code>.
     * </p>
     *
     * @param value value of the variable.
     * @param name name of the variable.
     *
     * @throws IllegalArgumentException if <code>value</code> is empty string.
     */
    public static void validateNotEmpty(String value, String name) {
        if (value != null && value.length() == 0) {
            throw new IllegalArgumentException(name + " cannot be empty string.");
        }
    }

    /**
     * <p>
     * Validates the value of a string variable. The value cannot be
     * <code>null</code> and empty string.
     * </p>
     *
     * @param value value of the variable.
     * @param name name of the variable.
     *
     * @throws NullPointerException if <code>value</code> is <code>null</code>.
     * @throws IllegalArgumentException if <code>value</code> is empty string.
     */
    public static void validateNotNullOrEmpty(String value, String name) {
        validateNotNull(value, name);
        validateNotEmpty(value, name);
    }

    /**
     * <p>
     * Strips the time properties in a <code>Date</code> instance. All time
     * properties are cleared. A <code>Calendar</code> instance is returned
     * instead of <code>Date</code> instance. If the given <code>Date</code> is
     * <code>null</code>, <code>null</code> is returned.
     * </p>
     *
     * @param dateTime the <code>Date</code> instance containing time properties
     * to be striped.
     *
     * @return striped <code>Calendar</code> instance containing only date
     * properties.
     */
    public static Calendar stripTime(Date dateTime) {
        if (dateTime == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        // Strip the time. Clear all time properties.
        calendar.setTime(dateTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }

    /**
     * <p>
     * Swaps the dates if the first one is later than the second one.
     * </p>
     *
     * @param first the first date to be swapped.
     * @param second the second date to be swapped.
     */
    public static void swapDate(Calendar first, Calendar second) {
        if (first.after(second)) {
            Date time = first.getTime();
            first.setTime(second.getTime());
            second.setTime(time);
        }
    }

    /**
     * <p>
     * Validates the value of a string array. The values in the array must be
     * non-empty string, and cannot be duplicate.
     * </p>
     *
     * @param value value of the string array.
     * @param name name of the string array.
     *
     * @throws IllegalArgumentException if <code>value</code> contains
     * <code>null</code>; or <code>value</code> contains empty string; or
     * <code>value</code> contains duplicate strings.
     */
    public static void validateStringArrayNotNullEmptyOrDuplicate(String[] value, String name) {
        Set set = new HashSet();

        for (int i = 0; i < value.length; ++i) {
            if (value[i] == null) {
                throw new IllegalArgumentException(name + " cannot contain null.");
            }

            if (value[i].length() == 0) {
                throw new IllegalArgumentException(name + " cannot contain empty string.");
            }

            if (set.contains(value[i])) {
                throw new IllegalArgumentException(name + " cannot contain duplicate strings.");
            }

            set.add(value[i]);
        }
    }

    /**
     * <p>
     * Gets the number of days between two dates. The earlier date counts, and
     * the later date does not count.
     * </p>
     *
     * @param earlierDate the earlier date of the date interval.
     * @param laterDate the later date of the date interval.
     *
     * @return the number of days between two dates.
     */
    public static long daysBetween(Date earlierDate, Date laterDate) {
        long duration = DateUtil.stripTime(laterDate).getTime().getTime() - DateUtil.stripTime(earlierDate).getTime().getTime();

        // Round to the nearest day, to solve daylight saving difference.
        return (duration + (ONE_DAY / 2)) / ONE_DAY;
    }
}
