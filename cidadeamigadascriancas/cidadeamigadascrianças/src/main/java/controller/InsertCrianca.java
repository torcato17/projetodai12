package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Crianca;

public class InsertCrianca {

	//conecta a base de dados
			String DRIVER = "com.mysql.jdbc.Driver";
			// diz que o host � o mysql
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			String sql = "INSERT INTO d4YWRRmazE.crianca(nome_crianca, idade, concelho_crianca, username, password, email) VALUE (?,?,?,?,?,?)";
			
			Crianca cr = new Crianca();
			
			int resposta;
			public int criarCrianca(Crianca c) {
				
				String nome_crianca = c.getNomeCrianca();
				int idade = c.getIdade();
				String concelho = c.getConcelho();
				String username = c.getUsername();
				String password = c.getPassword();
				String email = c.getEmail();
				
				
				try {
					Class.forName(DRIVER);
					Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			        PreparedStatement st = con.prepareStatement(sql);
			        
			        st.setString(1, nome_crianca);
			        st.setInt(2, idade);
			        st.setString(3, concelho);
			        st.setString(4, username);
			        st.setString(5, password);
			        st.setString(6, email);
					        
			        resposta = st.executeUpdate();
			           
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	 	
				return resposta;
			}
}
