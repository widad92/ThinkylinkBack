/**
 * OmniCoreUtils.java
 */
package com.omni.core.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import javax.faces.context.FacesContext;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.json.JSONObject;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * This class is {@link OmniCoreUtils} omniomni utility class.
 *
 *
 */
public class OmniCoreUtils {

    private OmniCoreUtils() {
    }

    private static final Logger LOGGER = OmniCoreUtils.getLogger(OmniCoreUtils.class);

    public static Logger getLogger(Class clazz) {
        try {
            InputStream inStream = OmniCoreUtils.class.getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);
            return Logger.getLogger(clazz);
        } catch (IOException ex) {
            LOGGER.error(ex);
        }

        return null;
    }

    public static Double pourcent(Double chiffre) {
        return chiffre / 100;
    }

    public static Double parseToFixed2(Double number) {
        return stringToDouble(roundTowDecimal(number));

//       return Double.parseDouble(roundTowDecimal(number));
    }

    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static Date stringToDate(String date) {
        try {
            if (date == null || date.equals("")) {
                return null;
            }
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Date dateToSqlFormat(String date) {
        try {
            String DATE_FORMAT_NOW = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            return sdf.parse(sdf.format(new SimpleDateFormat("dd/MM/yyyy").parse(date)));
        } catch (ParseException ex) {
            return null;
        }
    }

    public static int stringToInteger(String str) {
        int i = 0;
        if (str == null || str.equals("")) {
            return 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException nfe) {
                return 0;
            }
        }
        return i;
    }

    /**
     * Convert String to Double
     *
     * @param str
     * @return
     */
    public static Double stringToDouble(String str) {
        Double i = 0d;
        if (str == null || str.equals("")) {
            return 0d;
        } else {
            try {
                str = str.replaceAll("\\s", "");
                str = str.replace(",", ".");
                str = str.replace(Character.toString((char) 160), "");
                i = Double.parseDouble(str);
            } catch (NumberFormatException nfe) {
                return 0d;
            }
        }
        return i;
    }

    /**
     * Convert String to format Double
     *
     * @param str
     * @return
     */
    public static String stringToFormatTarif(String str) {
        if (str == null || str.equals("")) {
            return "0";
        } else {
            try {
                str = str.replaceAll("\\s", "");
                str = str.replace(",", ".");
                str = str.replace(Character.toString((char) 160), "");
                str = roundTowDecimal(Double.parseDouble(str));
                str = str.replace("-", "- ");
            } catch (NumberFormatException e) {
                return "0";
            }
        }
        return str;
    }

    /**
     * Format un double en double à deux décimaux après la virgule
     *
     * @param d
     * @return
     */
    public static String roundTowDecimal(Double d) {
        String dFormated;
        if (d == 0) {
            return "0";
        }
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        DecimalFormat formatter1 = new DecimalFormat("###,###.00", symbols);
        dFormated = formatter1.format(d);
        return dFormated;
    }

    /**
     * retourne le nombre d'année entre deux dates
     *
     * @param oldDate
     * @return
     */
    public static int nbreYearsBeforeToday(Date oldDate) {
        Date today = new Date();
        return (int) ((today.getTime() - oldDate.getTime()) / (1000 * 60 * 60 * 24) / 365);
    }

    /**
     * fait le hashage 512 d'une chaine passée
     *
     * @param base
     * @return
     */
    public static String sha512(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(base.getBytes(OmniCoreConstants.EMAIL_ENCODING));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int randInt() {
        int min = 1;
        int max = 9999999;
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static String getValueFromPropertyCode(String code) {
        InputStream inStream = OmniCoreUtils.class.getResourceAsStream("prop.properties");
        Properties prop = new Properties();
        try {
            prop.load(inStream);
            String result = prop.getProperty(code);
            return result;
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public static String getServerRealPath() {
        String realPath = OmniCoreConstants.EMPTY_STRING;
        try {
            //realPath = request.getSession().getServletContext().getRealPath(OmniCoreConstants.SLASH_STRING);
            realPath = new File(OmniCoreUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent();
            realPath = realPath.replace("WEB-INF\\lib", "");
            realPath = realPath.replace("WEB-INF/lib", "");
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(OmniCoreUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realPath;
    }

    public static VelocityEngine getVelocityEngine() {
        try {
            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.setProperty(RuntimeConstants.INPUT_ENCODING, "UTF-8");
            velocityEngine.setProperty(RuntimeConstants.OUTPUT_ENCODING, "UTF-8");
            velocityEngine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, getServerRealPath() + OmniCoreConstants.EMAIL_PATH);
            velocityEngine.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
            velocityEngine.init();
            return velocityEngine;
        } catch (Exception e) {
            LOGGER.error("getVelocityEngine: " + e);
            throw new RuntimeException("getVelocityEngine: ", e);
        }
    }

    public static void sendBadRequestError(HttpServletResponse res) throws IOException {
        JSONObject jObject = new JSONObject();
        jObject.put("status", 400);
        jObject.put("error", "Bad Request");
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        httpServletResponse
                .setStatus(HttpServletResponse.SC_BAD_REQUEST);
        httpServletResponse.setHeader(OmniCoreConstants.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, OmniCoreConstants.STAR_STRING);
        httpServletResponse.setHeader(OmniCoreConstants.ACCESS_CONTROL_ALLOW_CREDENTIELS_HEADER, OmniCoreConstants.TRUE_STRING);
        httpServletResponse.setContentType(OmniCoreConstants.JSON_CONTENT);
        httpServletResponse.getWriter().write(jObject.toString());
    }

    public static void sendUnauthorizedRequestError(HttpServletResponse res) throws IOException {
        JSONObject jObject = new JSONObject();
        jObject.put("status", "401");
        jObject.put("error", "Verify login and password");
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        httpServletResponse
                .setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setHeader(OmniCoreConstants.ACCESS_CONTROL_ALLOW_CREDENTIELS_HEADER, OmniCoreConstants.TRUE_STRING);
        httpServletResponse.setContentType(OmniCoreConstants.JSON_CONTENT);
        httpServletResponse.getWriter().write(jObject.toString());
    }

    public static void sendConflitRequestError(HttpServletResponse res) throws IOException {
        JSONObject jObject = new JSONObject();
        jObject.put("status", "409");
        jObject.put("error", "Resource not found");
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        httpServletResponse
                .setStatus(HttpServletResponse.SC_CONFLICT);
        httpServletResponse.setHeader(OmniCoreConstants.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, OmniCoreConstants.STAR_STRING);
        httpServletResponse.setHeader(OmniCoreConstants.ACCESS_CONTROL_ALLOW_CREDENTIELS_HEADER, OmniCoreConstants.TRUE_STRING);
        httpServletResponse.setContentType(OmniCoreConstants.JSON_CONTENT);
        httpServletResponse.getWriter().write(jObject.toString());
    }

    /**
     * copy uploadFile to file destination
     *
     * @param inputStream
     * @param dest
     * @param name
     * @param deleteBeforeUpload
     * @param compressImage
     */
    public static void copyFileToDestination(
            InputStream inputStream,
            String name,
            String dest,
            boolean deleteBeforeUpload,
            boolean compressImage
    ) {
        OutputStream outputStream = null;
        try {
            File path = new File(dest);
            if (!path.exists()) {
                path.mkdirs();
            } else if (deleteBeforeUpload) {
                if (!path.delete()) {
                    LOGGER.error("Error when delete " + dest);
                }
                path.mkdirs();
            }

            String originaleName = dest + File.separator + name;
            String ext = FilenameUtils.getExtension(name);

            outputStream = new FileOutputStream(new File(dest + File.separator + name));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg")) {

                BufferedImage image = ImageIO.read(new File(originaleName));
                File compressedImageFile = new File(originaleName);
                OutputStream os = new FileOutputStream(compressedImageFile);
                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(FilenameUtils.getExtension(name));
                ImageWriter writer = (ImageWriter) writers.next();
                ImageOutputStream ios = ImageIO.createImageOutputStream(os);
                writer.setOutput(ios);

                ImageWriteParam param = writer.getDefaultWriteParam();

                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.4f);  // Quality value
                writer.write(null, new IIOImage(image, null, null), param);
                os.close();
                ios.close();
                writer.dispose();
            }

        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void deleteFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                if (!file.delete()) {
                    LOGGER.error("Error when delete " + filePath);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error when delete " + filePath + " ==> " + e);
        }
    }

    public static String generateToken(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String generateNumber(int len) {
        String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String parseStringToHTMLAlias(String _originalString) {
        String _finalString = _originalString.toLowerCase();
        //Replace accent
        _finalString = Normalizer.normalize(_finalString, Normalizer.Form.NFD);
        _finalString = _finalString.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");//Replace éèàç by ascii
        _finalString = _finalString.replaceAll("\\s\\s+", " ");// Escape multiple space, tabs, newlines, etc,
        _finalString = _finalString.replaceAll("[^a-zA-Z0-9\\-\\s]", "");// Escape special chars
        _finalString = _finalString.replaceAll(" ", "-");//Replace space by -
        _finalString = _finalString.replaceAll("&", "");//Delete &

        return _finalString;
    }

    public static void sendNotificationsPWA(String token, String title, String message, String urlClick) {

        try {
            String url = "https://fcm.googleapis.com/fcm/send";

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            String basicAuth = "key=" + OmniCoreConstants.PWA_KEY;
            conn.setRequestProperty("Authorization", basicAuth);

            String data = "{ \n"
                    + " \"notification\": {\n"
                    + "  \"title\": \"" + title + "\", \n"
                    + "  \"body\": \"" + message + "\", \n"
                    + "  \"icon\": \"" + OmniCoreConstants.NOTIFICATION_PWA_LOGO + "\","
                    + "  \"badge\": \"" + OmniCoreConstants.NOTIFICATION_PWA_BADGE + "\","
                    + "  \"click_action\": \"" + urlClick + "\","
                    + " \"vibrate\": [100, 50, 100], \n"
                    + " },\n"
                    + " \"to\" : \"" + token + "\"\n"
                    + "}";
            try (OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream())) {
                out.write(data);
            }
            new InputStreamReader(conn.getInputStream());

        } catch (IOException e) {
        }

    }

    /**
     * @return
     */
    public static String getChemin() {
        String chemin = "";
        if (FacesContext.getCurrentInstance() != null) {
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext();
            chemin = ctx.getRealPath("/");
        }
        return chemin;
    }

    public static void copyNonNullProperties(Object src, Object target) {
        try {
            BeanUtilsBean notNull = new NullAwareBeanUtilsBean();
            notNull.copyProperties(target, src);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            java.util.logging.Logger.getLogger(OmniCoreUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        List<String> emptyNames = new ArrayList<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static boolean isNullOrEmpty(String tmp) {
        return tmp == null || tmp.isEmpty();
    }
    // name = client OR Organisation 

    public static String genereReference(String name, String type) {
        return type.substring(0, Math.min(type.length(), 2)).toUpperCase() + generateNumber(3) + name.substring(0, Math.min(name.length(), 2)).toUpperCase() + generateNumber(2);
    }

}
