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
			if (elems==0) {
				propiedades.setProperty("name"+1, name);
				propiedades.setProperty("mail"+1, mail); 
				propiedades.setProperty("username"+1, username);
				propiedades.store(new FileWriter(rutaFicheroPropiedades), "");
			}
			else {
				for(int i=1; i<elems;i++) {
					propiedades.setProperty("name"+i, name);
					propiedades.setProperty("mail"+i, mail); 
					propiedades.setProperty("username"+i, username); 
					//CARGAMOS LOS DATOS AL FICHERO
					propiedades.store(new FileWriter(rutaFicheroPropiedades), "");
				}
			}
			

			}catch(FileNotFoundException e) {
			e.printStackTrace();
			}catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	
}



