//TODO: En el constructor hay que inicializar un vector de espectadores que vuelque todos los datos del fichero
//en dicho vector. Luego se obtendrá el tamaño del vector para poder seguir escribiendo en el fichero de datos.

package fichero.users;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IOUsers {
	
	//funcion que añade un usuario al fichero de usuarios
	public void userToFich(String name, String mail, String username)
	{
		Properties propiedades = new Properties();
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFicheroPropiedades = rutaAbsoluta + "/usuarios.properties";
		try {
			InputStream entrada = new FileInputStream(rutaFicheroPropiedades); 
			//ABRIMOS EL FICHERO
	
			propiedades.load(entrada);
			//RELLENAMOS CON LOS NUEVOS DATOS
			int elems = propiedades.size();
			propiedades.setProperty("name"+((elems/3)+1), name);
			propiedades.setProperty("mail"+((elems/3)+1), mail); 
			propiedades.setProperty("username"+((elems/3)+1), username); 
			propiedades.store(new FileWriter(rutaFicheroPropiedades), "");

			}catch(FileNotFoundException e) { 
			e.printStackTrace();
			}catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	
}



