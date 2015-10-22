/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author hquintana
 */
public class Utiles {
    public static String inputStreamToString(InputStream is) throws IOException{
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
	try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
		sb.append(line);
            }
	} finally {
            if (br != null) {
                br.close();

            }
        }
        return sb.toString();
    }
    
    public static String getValueFromProperty(String property) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        InputStream input = null;
        String res = "";
        try {
            // load a properties file
            prop.load(classLoader.getResourceAsStream("pe/edu/ulima/utilitarios/config.properties"));

            res = prop.getProperty(property);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Utiles.getValueFromProperty("login"));
    }
}
