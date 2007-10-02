/*
 * Config.java
 *
 * Created on 1 de octubre de 2007, 0:53
 */

package objects;


/**
 *
 * @author Juanjito
 */
public class Config
{

    protected static String servername; //especifica la ruta del servidor tomcat
    protected static String serverport; //especifica el puerto de tomcat
    protected static String application; //especifica el nombre de la aplicacion
    protected static String publickey; //especifica la clave publica con la que se encriptara
    
    public Config(String serverName, String serverPort, String application, 
                  String key)
    {
        this.servername=serverName;
        this.serverport=serverPort;
        this.application=application;
        this.publickey=key;
    }
    
    public static String getServerName(){return servername;}
    public static String getServerPort(){return serverport;}
    public static String getApplication(){return application;}
    public static String getKey(){return publickey;}
    
}
