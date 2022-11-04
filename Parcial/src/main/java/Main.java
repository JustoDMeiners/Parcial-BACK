import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.Model.Odontologo;
import org.example.Repository.OdontologoDAOH2;
import org.example.Service.OdontologoService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {

    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        startLogger();

        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        odontologo.setNombre("Justo");
        odontologo.setApellido("Diaz Meiners");
        odontologo.setMatricula("1998DM");



        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoDao(new OdontologoDAOH2());


        odontologoService.agregar(odontologo);
       // odontologoService.eliminar(1L);
    }
    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}