package com.aurea.cx.messenger.example.StringOpsService;

import com.aurea.sonic.esb.pojo.annotation.InitParameter;
import com.aurea.sonic.esb.pojo.annotation.Operation;
import com.aurea.sonic.esb.pojo.annotation.Parameter;
import com.aurea.sonic.esb.pojo.annotation.SonicPOJO;

import org.apache.log4j.Logger;

/**
 * StringOpsService POJO Service 2019
 */
@SonicPOJO(description = "StringOpsService POJO service")
public class StringOpsService {
	private final Logger log = Logger.getLogger(this.getClass());
    
   /**
     * Init parameter: verbose
     */
    @InitParameter(description = "Log operation calls", defaultValue = "false")
    private boolean verbose;
    
    public void setVerbose(final boolean verbose) {
        this.verbose = verbose;
    }
         
    public boolean isVerbose() {
        return verbose;
    }
             
    /**
    * Operation: String contatenate(String[], String)
    */        
    @Operation(description = "Concatenate strings")
    public String concatenate(final String strList[], final String delimiter) {
        if (isVerbose()) {
            log.info("concatenate called with parameters strList={"+strList+"} and delimiter={"+delimiter+"}");
        }
        if (strList == null) {
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strList.length; i++) {
            sb.append(strList[i]);
            if (i < strList.length - 1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
    
    /**
    * Operation: String[] split(String, String)
    */
    @Operation(description = "Split string")
    public String[] split(final String str, final String delimiter) {
        if (isVerbose()) {
            log.info("split called with parameters str={"+str+"} delimiter={"+delimiter+"}");
        }
        if (str == null) {
            return new String[0];
        }
        return str.split(delimiter);
    }
    
    /**
    * Operation: float convert(float)
    */
    @Operation(description = "Convert Fahrenheit To Celcius")
    public float convert(@Parameter(contentType = "text/xml") final float fahrenheit) {
        if (isVerbose()) {
            log.info("convert called with parameter fahrenheitr={"+fahrenheit+"}");
        }
        return (fahrenheit - 32) * 5 / 9;
    }
    


}  
