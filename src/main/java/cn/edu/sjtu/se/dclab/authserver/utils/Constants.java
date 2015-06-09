package cn.edu.sjtu.se.dclab.authserver.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

public class Constants {
    private static final Logger LOG = LoggerFactory.getLogger(Constants.class);

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public static int THRIFT_SERVER_PORT;
    public static String THRIFT_SERVER_IP;
    public static String THRIFT_SERVER_ROOTNAME;

    public static String NETWORK_INTERFACE;

    public static void init(String path) {
        Properties props = new Properties();
        FileInputStream file = null;
        try {
            LOG.debug(System.getenv("CONF_DIR"));
            file = new FileInputStream(path);
            props.load(file);
            file.close();
            
            THRIFT_SERVER_PORT = Integer.parseInt(props.getProperty("thrift.port", "7911"));
            THRIFT_SERVER_IP = props.getProperty("thrift.ip", "192.168.1.110");
            THRIFT_SERVER_ROOTNAME = props.getProperty("thrift.server.rootname", "authserver");
        } catch(FileNotFoundException ex) {
            LOG.debug("application.properties not found.\n" + ex.getMessage());
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ioe) {
                LOG.debug(ex.getMessage());
            }
        } catch (IOException ex) {
            LOG.debug(ex.getMessage());
        } finally {
            file = null;
        }
    }


}
