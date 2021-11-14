package es.uco.pw.data.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * A class to manage the MySQL connection (general methods and configuration. 
 * @author Developers
 * */

public class DBConnection {

	protected Connection connection = null;
	
	protected String url="jdbc:mysql://oraclepr.uco.es:3306/p92avavv";

	protected String user="p92avavv";

	protected String password="passwordpw";

	public Connection getConnection(){
	
		//DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        /*try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document dDoc = builder.parse("web.xml");

            XPath xPath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xPath.evaluate("/user", dDoc, XPathConstants.NODE);
            this.user = node.getNodeValue();
            Node node2 = (Node) xPath.evaluate("/url", dDoc, XPathConstants.NODE);
            this.url = node2.getNodeValue();
            Node node3 = (Node) xPath.evaluate("/url", dDoc, XPathConstants.NODE);
            this.password = node3.getNodeValue();
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}