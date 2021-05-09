package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Material;

public class SelectMaterial {
	//conecta a base de dados
			String DRIVER = "com.mysql.jdbc.Driver";
			// diz que o host é o mysql
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			String sql = "SELECT * FROM d4YWRRmazE.comentário where id.conteudo = ?"; 
			ResultSet rs;
			Material mat = new Material();
			
			
			public Material retornaComentario(Material ma) {
				try {
					Class.forName(DRIVER);
					 Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				        PreparedStatement st = con.prepareStatement(sql);
				        rs = st.executeQuery();
				        //executeUpdate(); se for um update
				        rs.next();
				        //  avança no array em ves de criar um vazio 
				        
				        String material = rs.getString("material");
				        // ma.setConteudo(material);
				        //fazer cenos para o username
				        
				        
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();	
				}
				return ma;
			}
	}